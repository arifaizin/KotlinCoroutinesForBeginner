plugins {
    kotlin("jvm") version "1.5.10"
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.2.2")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}