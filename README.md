Requirements
For building and running the application you need:

JDK 1.8+
Gradle 7
Intellij IDE
PostgreSQL DB (either Locally or Docker Image)

Running the application locally

Please click "PsBuild" task from gradle explorer in intellij ide

Please make sure you are chosen local properties profile and updated vm arguments

-Dspring.profiles.active=local  // active profile can change according to upper environment
-Dspring.datasource.url=jdbc:postgresql://localhost:5432/postgres  // you can modify if you are running docker image for postgresql
-Djasypt.encryptor.password=car  // jasypt password generated secret key
-Dspring.jpa.show-sql=true // can enable or disable in upper environment

Use the Jasypt Online Tool :
This "https://www.devglan.com/online-tools/jasypt-online-encryption-decryption" can be used to generate an encrypted key by passing the chosen secret key.

then execute the main method in the ..\com\tbpay\preference\PreferenceApplication.javaApplication class from your IDE.

if you have chosen to run locally please use below PostgreSQL way 1 :
// As we used PostgreSQL DB please make sure you've installed postgreSQL13 in local machine

then just Run application (Service will start in 8081 )
Deploying the application to kubernetes
PostgreSQL way 2 :
// Use the postgreSQL image we created then add that in VM options by changing below line 

-Dspring.datasource.url=jdbc:postgresql://{Docker postgresql Image host Name}:5432/postgres  // you can modify if you are running docker image for postgresql

Build Docker file and push image in container (k8s) after PreferenceCreate and postgreSQL services Docker files



