plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("com.google.code.gson:gson:2.13.2")
    // Základní modul Jackson pro datové vazby
    implementation("com.fasterxml.jackson.core:jackson-databind:2.16.1")
// Modul Jackson pro zpracování XML dat
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.16.1")

}

tasks.test {
    useJUnitPlatform()
}