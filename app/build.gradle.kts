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
    implementation("io.javalin:javalin:6.1.3")
    implementation("io.javalin:javalin-rendering:6.1.3")
    implementation("io.javalin:javalin-bundle:6.1.3")
    implementation("ch.qos.logback:logback-classic:1.2.10")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}