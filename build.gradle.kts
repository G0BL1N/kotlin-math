plugins {
    kotlin("multiplatform") version "1.3.30-eap-11"
}

repositories {
    mavenCentral()
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    maven("https://dl.bintray.com/kotlin/kotlin-dev")
}

kotlin {
    mingwX64("mingw")
    js() {
        compilations["main"].kotlinOptions.outputFile = "${projectDir}/build/js/kotlin-math.js"
    }
    jvm()

    sourceSets {
        val commonMain by getting {
            kotlin.srcDir("src")
            dependencies {
                implementation(kotlin("stdlib"))
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(kotlin("stdlib-js"))
            }
        }
    }
}
