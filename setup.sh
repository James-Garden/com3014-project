echo "Your \$JAVA_HOME is located below. Make sure it points to a Java 21 JDK."
echo $JAVA_HOME

cd ./user-api
# Build the User API .jar file without running the tests
bash mvnw clean -DskipTests package
cd ..

cd ./recipe-api
bash mvnw clean package
cd ..

docker compose build
echo 'Done! Run `docker compose up` to start the project.'
