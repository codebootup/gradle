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
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

tasks.named("compileTestKotlin", KotlinJvmCompile::class){
    compilerOptions{
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

java{
    toolchain{
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.test{
    useJUnitPlatform()
}