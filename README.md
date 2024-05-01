Cupboard Cookbook
==============

# Start the project

## Requirements

* Docker
* Java 21
* Node
    * Built and tested on Node 20
    * Others Node versions may work, but not guaranteed

## Setup and run

1. Run `setup.sh` to build the project
2. Run `docker compose up` in the `com3014-project` directory to start all the microservices
3. Go to `http://localhost:4000` to access the website

To shut down the project, either:

* Press Ctrl + C on the terminal you ran `docker compose up` in to shut down
* Run `docker compose down` in the `com3014-project` directory

Now if you want to start the project again, just re-run `docker compose up`

### Troubleshooting

If `./script.sh` fails due to a maven error, check the following:

1. Check your Java version with `java -version`, it should be version 21
2. On windows go to `Edit system environment variables` and check that `JAVA_HOME` both exists and 
is pointing to your JDK 21 installation folder
