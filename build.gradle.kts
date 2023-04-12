import org.gradle.api.publish.maven.internal.publication.DefaultMavenPublication

plugins {
    `kotlin-dsl`
    `maven-publish`
    `signing`
    id("com.gradle.plugin-publish") version "1.1.0"
}

group "com.codebootup.gradle"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-allopen:1.8.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
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
        val extension = extensions
            .getByName("publishing") as PublishingExtension
        sign(extension.publications)
    }
}
