FROM openjdk:11
COPY ./build/libs/fetchUser-0.0.1-SNAPSHOT.jar fetchUser-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","fetchUser-0.0.1-SNAPSHOT.jar"]
