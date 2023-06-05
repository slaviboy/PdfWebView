plugins {
    id("com.android.application") version "8.0.0-beta03" apply false
    id("com.android.library") version "8.0.0-beta03" apply false
    id("org.jetbrains.kotlin.android") version "1.8.21" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}