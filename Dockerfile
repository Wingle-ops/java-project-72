# Используйте официальный образ OpenJDK в качестве базового
FROM openjdk:21-jre-slim

# Установите рабочую директорию
WORKDIR /app

# Скопируйте jar-файл вашего приложения в контейнер
COPY app/build/classes/java/main/hexlet/code/App.jar App.jar

# Укажите команду для запуска приложения
CMD ["java", "-jar", "app.jar"]
