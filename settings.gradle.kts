pluginManagement {
    includeBuild("../build-logic")
}

plugins {
    id("multimodule")
}

fun includeSubs(base: String, path: String = base, vararg subs: String) {
    subs.forEach {
        include(":$base-$it")
        project(":$base-$it").projectDir = File("$path/$it")
    }
}

listOf(
    "krono-core", "kommander", "symphony", "kollections",
    "koncurrent", "cinematic", "kase", "lexi"
).forEach { includeBuild("../$it") }

rootProject.name = "krono-client"

includeSubs("krono", ".", "fields")
