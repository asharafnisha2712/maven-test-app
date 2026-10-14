# Maven Test App

A small Java 17 Maven application with unit tests, a Docker image, and a Harness CI pipeline.

## Run locally

Requires JDK 17+ and Maven 3.9+.

```sh
mvn --batch-mode clean verify
java -jar target/maven-test-app-1.0.0.jar Ada
docker build -t maven-test-app:local .
```

The application prints `Hello, Ada!`. Omitting the name uses `world`.

## Harness pipeline

The pipeline definition is in `.harness/pipelines/maven-ci.yaml`. It builds and tests
the Maven project, scans the source tree and Dockerfile with Trivy, builds the
container image, and scans that image. High and critical findings fail the pipeline.
The image is built locally in the CI job and is not pushed to a registry.

Before importing or running the pipeline in Harness:

1. Create or select a Harness CI project for this repository.
2. Create a GitHub connector with access to `asharafnisha2712/maven-test-app`.
3. Replace `YOUR_ORG_ID`, `YOUR_PROJECT_ID`, and `YOUR_GITHUB_CONNECTOR` in the
   pipeline YAML with the corresponding Harness identifiers.
4. Import `.harness/pipelines/maven-ci.yaml` into the project and run it on a branch.

The pipeline uses Harness's built-in `account.harnessImage` connector to pull its
public Maven, Docker, and Trivy images. Trivy downloads its vulnerability database
at runtime, so the CI infrastructure needs outbound network access. This pipeline
uses Harness Cloud Linux/Amd64 infrastructure and a privileged Docker-in-Docker
service. Harness Cloud availability and billing are controlled by your account plan;
Harness free plans require credit-card validation to use Harness Cloud.
