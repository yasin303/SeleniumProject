plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.7.2")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.9.2")
    testImplementation("io.cucumber:cucumber-java:7.15.0")
    testImplementation("io.cucumber:cucumber-junit:7.15.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.4")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.11.4")
}

tasks.test {
    useJUnit()
}

configurations {
    create("cucumberRuntime") {
        extendsFrom(configurations["testImplementation"])
    }
}

tasks.register("cucumber") {
    description = "Running Cucumber Test"
    dependsOn("assemble", "compileTestJava")

    doLast {
        javaexec {
            mainClass.set("io.cucumber.core.cli.Main")
            classpath = files(
                configurations["cucumberRuntime"],
                sourceSets["main"].output,
                sourceSets["test"].output
            )
            args = listOf(
                "--plugin", "html:reports/test-report.html",
                "--plugin", "pretty",
                "--glue", "com.yasin",
                "--tags", System.getProperty("tags") ?: "",
                "src/test/resources"
            )
        }
    }
}
