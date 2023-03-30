plugins{
    `kotlin-dsl`
}

group "com.codebootup"
version = (project.properties["buildVersion"] ?: "1.0.0-SNAPSHOT")

repositories{
    mavenCentral()
}