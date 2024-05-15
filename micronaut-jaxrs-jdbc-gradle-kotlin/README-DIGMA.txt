
./gradlew build

to use podman on linux
export DOCKER_HOST=unix://${XDG_RUNTIME_DIR}/podman/podman.sock

to create 4 pets
curl -id '{"name":"Rambo", "type":"DOG"}' -H "Content-Type: application/json" -X POST http://localhost:8080/pets && curl -id '{"name":"Django", "type":"DOG"}' -H "Content-Type: application/json" -X POST http://localhost:8080/pets && curl -id '{"name":"Brus", "type":"DOG"}' -H "Content-Type: application/json" -X POST http://localhost:8080/pets && curl -id '{"name":"Chase", "type":"DOG"}' -H "Content-Type: application/json" -X POST http://localhost:8080/pets


to get all pets
curl -i localhost:8080/pets


to run with otel agent instead of micronaut tracing
INSTRUMENTATION_FLAVOR=Default

for extended observability
USE_DIGMA_AGENT=true

and add extended observability
example.micronaut.processor
