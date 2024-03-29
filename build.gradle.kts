import org.gradle.api.publish.maven.internal.publication.DefaultMavenPublication

plugins {
    `kotlin-dsl`
    `maven-publish`
    `signing`
    id("com.gradle.plugin-publish") version "1.1.0"
}

group "com.codebootup.gradle"
version = (project.properties["buildVersion"] ?: "3.0.0")

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-allopen:1.9.22")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.22")
}

gradlePlugin {
    website.set("https://github.com/codebootup")
    vcsUrl.set("https://github.com/codebootup/gradle.git")
    plugins.all {
        if(this.id == "com.codebootup.kotlin"){
            displayName = "Kotlin Code Bootup"
            description = "Plugin that encapsulates a common Kotlin build script"
            tags.set(listOf("build"))
        }
    }
}

signing {
    val signingKey = providers
        .environmentVariable("GPG_SIGNING_KEY")
    val signingPassphrase = providers
        .environmentVariable("GPG_SIGNING_PASSPHRASE")
    if (signingKey.isPresent && signingPassphrase.isPresent) {
        useInMemoryPgpKeys(signingKey.get(), signingPassphrase.get())
        publishing.publications.filterIsInstance<DefaultMavenPublication>().forEach {
            sign(it)
        }
    }
}

publishing {
    publications.all {
        if (this is DefaultMavenPublication) {
            this.pom {
                pom {
                    name.set("codebootup gradle")
                    description.set("Project encapsulating common gradle build scripts to bootstrap application quickly")
                    url.set("https://github.com/codebootup/gradle")
                    groupId = "com.codebootup"
                    licenses {
                        license {
                            name.set("The Apache License, Version 2.0")
                            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        }
                    }
                    developers {
                        developer {
                            id.set("codebootuplee")
                            name.set("Lee Cooper")
                            email.set("lee@codebootup.com")
                        }
                    }
                    scm {
                        connection.set("scm:git:git@github.com:codebootup/gradle.git")
                        developerConnection.set("scm:git:ssh://github.com:codebootup/gradle.git")
                        url.set("https://github.com/codebootup/gradle/tree/main")
                    }
                }
            }
        }
    }
}