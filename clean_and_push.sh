mvn clean install
docker build . -t pelease/achieve2:9.0.0
docker push pelease/achieve2:9.0.0
