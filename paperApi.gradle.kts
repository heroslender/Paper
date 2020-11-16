plugins {
    `java-library`
}

repositories {
    maven("https://hub.spigotmc.org/nexus/content/groups/public/")
}

dependencies {
    // api dependencies are listed transitively to API consumers
    api("commons-lang:commons-lang:2.6")
    api("com.google.guava:guava:21.0")
    api("com.google.code.gson:gson:2.8.0")
    api("net.md-5:bungeecord-chat:1.16-R0.3")
    api("org.yaml:snakeyaml:1.26")
    api("org.slf4j:slf4j-api:1.7.25")

    // These dependencies are not stated transitively to API consumers
    implementation("org.jetbrains:annotations-java5:19.0.0")

    testImplementation("junit:junit:4.13.1")
    testImplementation("org.hamcrest:hamcrest-library:1.3")
    testImplementation("org.ow2.asm:asm-tree:8.0.1")
}
