plugins {
    kotlin("jvm") version "1.7.22"
    id("application")
}

repositories {
    mavenCentral()
}

tasks {
    application {
        mainClassName("Day2Kt")
    }
    
    sourceSets {
        main {
            java.srcDirs("src")
        }
    }

    wrapper {
        gradleVersion = "7.6"
    }
}
