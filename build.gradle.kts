plugins {
    id("com.github.johnrengelman.shadow") version "6.0.0" apply false
    id("io.papermc.paperweight") version "1.0.0-SNAPSHOT"
}

group = "com.destroystokyo.paper"
version = "1.16.4-R0.1-SNAPSHOT"

subprojects {
    apply(plugin = "com.github.johnrengelman.shadow")

    tasks.withType<JavaCompile>().configureEach {
        options.encoding = "UTF-8"
    }

    repositories {
        mavenCentral()
        maven("https://repo1.maven.org/maven2/")
        maven("https://oss.sonatype.org/content/groups/public/")
        maven("https://repo.md-5.net/content/repositories/releases/")
        maven("https://ci.emc.gs/nexus/content/groups/aikar/")
        maven("https://papermc.io/repo/repository/maven-public/")
    }
}

paperweight {
    minecraftVersion.set("1.16.4")
    mcpConfigVersion.set("20201102.104115")
    mcpMappingsChannel.set("snapshot")
    mcpMappingsVersion.set("20201115-1.15.1")
}

