plugins{
    `kotlin-dsl`
}

group "com.codebootup"
version = (project.properties["buildVersion"] ?: "1.0.0-SNAPSHOT")

repositories{
    mavenCentral()
}

dependencies{
    implementation("org.jetbrains.kotlin:kotlin-allopen:1.8.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
}