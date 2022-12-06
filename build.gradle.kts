plugins {
    kotlin("jvm") version "1.7.22"
	application
	id("com.github.johnrengelman.shadow") version "7.1.2"
}

repositories {
    mavenCentral()
}

application {
	mainClass.set("Day5Kt")
}

tasks {
	withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
		archiveFileName.set("aoc-2022.jar")
		mergeServiceFiles()
	}

	build {
		dependsOn(shadowJar)
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
