#!/bin/bash

set -a
source .env.development
set +a
echo "Loaded environment variables."

./mvnw spring-boot:run
