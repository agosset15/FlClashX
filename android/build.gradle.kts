
allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

val newBuildDir: Directory = rootProject.layout.buildDirectory.dir("../../build").get()
rootProject.layout.buildDirectory.value(newBuildDir)

subprojects {
    val subprojectBuildDir = if (project.projectDir.toPath().root == rootProject.projectDir.toPath().root) {
        newBuildDir.dir(project.name)
    } else {
        project.layout.buildDirectory.dir("build").get()
    }
    project.layout.buildDirectory.value(subprojectBuildDir)
}
subprojects {
    project.evaluationDependsOn(":app")
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}
