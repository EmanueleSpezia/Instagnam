###########################################################
# Dockerfile per l'applicazione sentence / sentence service 
###########################################################

FROM openjdk:8-jdk 

ADD build/libs/ricette.jar ricette.jar

ENTRYPOINT ["java", "-Xmx128m", "-Xms128m", "-jar", "ricette.jar"]

HEALTHCHECK --start-period=30s --interval=10s CMD curl -f http://localhost:8080/actuator/health || exit 1