plugins {
    id("com.github.ben-manes.versions") version "0.48.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    application
    id("io.freefair.lombok") version "8.6"
}

application {
    mainClass.set("hexlet.code.App")
}

group = "exercise"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.h2database:h2:2.1.214") // Зависимости Джавалин и БД
    implementation("com.zaxxer:HikariCP:5.0.1")
    implementation("io.javalin:javalin:6.1.3")
    implementation("io.javalin:javalin-bundle:6.1.3")
    implementation("ch.qos.logback:logback-classic:1.2.10")

    implementation("gg.jte:jte:3.1.9") // Шаблонизаторы
    implementation("io.javalin:javalin-rendering:6.1.3")

    implementation ("org.projectlombok:lombok:1.18.28") // Зависимости Ломбук
    annotationProcessor ("org.projectlombok:lombok:1.18.28")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("org.jsoup:jsoup:1.15.4")
}

tasks.test {
    useJUnitPlatform()
}