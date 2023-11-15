plugins {
    id("java")
    id("application")
    id("org.javamodularity.moduleplugin") version ("1.8.12")
    id("org.openjfx.javafxplugin") version ("0.0.13")
    id("org.beryx.jlink") version ("2.25.0")
}

group = "hust.uiux.year20231.apartment"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}

application {
    mainModule = "hust.uiux.year.apartment"
    mainClass = "hust.uiux.year20231.apartment.Application"
}

javafx {
    version = "17.0.6"
    modules("javafx.controls", "javafx.fxml")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.compileJava {
    options.encoding = "UTF-8"
}

jlink {
    imageZip = project.file("${buildDir}/distributions/app-${javafx.platform.classifier}.zip")
    options.addAll("--strip-debug", "--compress", "2", "--no-header-files", "--no-man-pages")
    launcher {
        name = "app"
    }
}

tasks.jlinkZip {
    group = "distribution"
}