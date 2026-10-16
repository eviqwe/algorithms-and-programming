plugins {
    id("java")
}

subprojects {
    apply(plugin = "java")

    repositories {
        mavenCentral()
    }

    dependencies {
        val testImplementation by configurations
        testImplementation(platform("org.junit:junit-bom:5.10.2"))
        testImplementation("org.junit.jupiter:junit-jupiter")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

group = "com.java-labs"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}