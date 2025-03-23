FROM gradle:8.7.0-jdk21

WORKDIR /app

# Копируем только необходимые файлы для сборки
COPY build.gradle settings.gradle ./
COPY src ./src

# Устанавливаем зависимости
RUN gradle build --no-daemon

# Копируем оставшиеся файлы (если нужно)
COPY . .

# Выполняем сборку
RUN gradle installDist

# Запускаем приложение
CMD ["./build/install/app/bin/App"]