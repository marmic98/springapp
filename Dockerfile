# Usa un'immagine di base che contiene Java 17
FROM openjdk:17

# Crea una directory temporanea per il lavoro
VOLUME /tmp

# Copia il file JAR generato nella directory dell'immagine Docker
# ARG specifica un argomento che verrà passato durante la build
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Esponi la porta su cui la tua applicazione Spring Boot sta girando
EXPOSE 8080

# Imposta il comando per avviare l'applicazione
ENTRYPOINT ["java", "-jar", "/app.jar"]
