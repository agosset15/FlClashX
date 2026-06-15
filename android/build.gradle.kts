
allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

val newBuildDir: Directory = rootProject.layout.buildDirectory.dir("../../build").get()
rootProject.layout.buildDirectory.value(newBuildDir)

allprojects {
    fun configure() {
        if (project.extensions.findByName("android") != null) {
            val android = project.extensions.getByName("android") as com.android.build.gradle.BaseExtension
            android.defaultConfig.minSdk = 23
        }
    }
    if (state.executed) {
        configure()
    } else {
        afterEvaluate { configure() }
    }
    
    tasks.whenTaskAdded {
        if (name.contains("UnitTest") || name.contains("AndroidTest")) {
            enabled = false
        }
    }
}

subprojects {
    val subprojectBuildDir = if (project.projectDir.toPath().root == rootProject.projectDir.toPath().root) {
        newBuildDir.dir(project.name)
    } else {
        project.layout.buildDirectory.dir("build").get()
    }
    project.layout.buildDirectory.value(subprojectBuildDir)
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}
