NS=app-new-core
APP=cr-bitacora-parametros-service
SHA=$(shell git rev-parse --short HEAD)
export ORIGIN?=$(shell git remote -v | head -1 | grep -oE '(google|azure)')
export TEAM?=$(shell git remote -v | head -1 | grep -oE "findepdev\/[^\/]*" | sed "s/findepdev\///g")

submit:
	gcloud config set project findep-calidad-uat-mx
	gcloud builds submit --config cloudbuild.yaml --timeout=25m --substitutions=SHORT_SHA=$(SHA) .
	echo "===> Solicita tu despliegue con el siguiente SHA: $(SHA)"

delete:
	gcloud config set project findep-calidad-uat-mx
	gcloud builds submit --config delete.yaml .

instance:
	gcloud config set project findep-calidad-uat-mx
	envsubst '$${ORIGIN},$${TEAM}' < "./pipe/instance.template.yaml" > "./pipe/instance.yaml"
	gsutil -m cp -r ./pipe/instance.yaml gs://k8s-backups-uat/$(NS)/$(APP)/pipe/
	cd pipe && \
	gcloud builds submit --config instance.yaml .

rollback:
	gcloud config set project findep-calidad-uat-mx
	gcloud builds submit --config rollback.yaml --substitutions=SHORT_SHA=$(SHA_ANTERIOR) .

sonar-java:
	mvn clean install sonar:sonar

sonar-js:
	npm run test:unit
	node sonar.config.js
