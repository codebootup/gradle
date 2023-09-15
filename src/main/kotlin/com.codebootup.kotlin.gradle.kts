import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm")
}

dependencies{
    testImplementation(kotlin("test"))
}

tasks.named("compileKotlin", KotlinJvmCompile::class){
    compilerOptions{
        jvmTarget.set(JvmTarget.JVM_19)
    }
}

tasks.named("compileTestKotlin", KotlinJvmCompile::class){
    compilerOptions{
        jvmTarget.set(JvmTarget.JVM_19)
    }
}

java{
    toolchain{
        languageVersion.set(JavaLanguageVersion.of(19))
    }
}

tasks.test{
    useJUnitPlatform()
}