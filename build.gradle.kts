plugins {
    id("java")
}

group = "com.yuanshi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("org.mongodb:mongo-java-driver:3.12.11")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}