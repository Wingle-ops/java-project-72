FROM gradle:8.7.0-jdk21

WORKDIR /app

# Копируем необходимые файлы для сборки
COPY app/build.gradle ./
COPY app/settings.gradle ./
COPY app/src ./src

# Устанавливаем зависимости
RUN gradle build --no-daemon

# Выполняем сборку
RUN gradle installDist

# Запускаем приложение
CMD ["./build/install/app/bin/App"]