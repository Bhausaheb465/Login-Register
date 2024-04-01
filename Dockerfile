FROM openjdk
COPY target/16-Assignment-LoginUser-0.0.1-SNAPSHOT.jar /user/app/
WORKDIR /user/app/
EXPOSE 9090
ENTRYPOINT [ "java", "-jar", "16-Assignment-LoginUser-0.0.1-SNAPSHOT.jar" ]