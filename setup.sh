cd ./user-api

echo $JAVA_HOME
# Build the User API .jar file without running the tests
bash mvnw clean -DskipTests package
cd ..

docker compose build
echo 'Done! Run `docker compose up` to start the project.'
