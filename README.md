<a href="https://discord.gg/jDAGR26yXe"><img src="https://img.shields.io/discord/1068818982485901432?color=5865F2&logo=discord&logoColor=white" alt="Discord server" /></a>

# BlueCloud
A simple, modular and leightweight [Minecraft](https://minecraft.net) cloud system.

> [!WARNING]
> Do not use the cloud yet, it's still work in progress.

## Goals
Our goals is **not** to create a production-ready cloud system. We want to learn more about backend development.
If you are searching for a production-ready cloud system, you should take a look at [nextCluster](https://github.com/nextCluster/nextCluster).

## Features
| Feature        | Description                                                  | Status |
|----------------|--------------------------------------------------------------|--------|
| **Runner**     | The module that handles process creation.                    | 🚧     |
| **API**        | A api for developers using dependency injection.             | 🚧     |
| **Wrapper**    | The wrapper between the node and the runner.                 | 🚧     |
| **Node**       | The main part of the cloud system.                           | ❌      |
| **Templates**  | A template system for services.                              | ❌      |
| **Sync**       | A synchronisation service for the cloud system. (e.g. Netty) | ❌      |
| **CLI**        | A command line interface for the cloud system.               | ❌      |
| **Website**    | A website for this project.                                  | ❌      |
| **Dashboard**  | A web interface for managing the cloud.                      | ❌      |
| **Modules**    | A module system for the cloud system                         | ❌      |
| **Docker**     | A Dockerfile for the cloud system.                           | ❌      |
| **Kubernetes** | A Kubernetes deployment file for the cloud system.           | ❌      |

### Modules
| Module             | Description                                                                    | Status |
|--------------------|--------------------------------------------------------------------------------|--------|
| **Rest-API**       | A rest api for the cloud system.                                               | ❌      |
| **Proxy-Module**   | A module consisting of an maintenance, motd and tablist system.                | ❌      |
| **NPCs**           | An NPC system that gives players the opportunity to connect to other servers.  | ❌      |
| **Signs**          | An Sign system that gives players the opportunity to connect to other servers. | ❌      |
| **Ingame-Notify**  | A ingame notification system (e.g. when a cloud service starts).               | ❌      |
| **Webhook-Notify** | A webhook for notifications (e.g. when a cloud service starts).                | ❌      |

### Platforms
> [!NOTE]  
> Bedrock platforms are planned for the future.
> 
| Platform                                             | Description                                   | Status |
|------------------------------------------------------|-----------------------------------------------|--------|
| **[Velocity](https://papermc.io/software/velocity)** | A modern Minecraft Proxy solution.            | 🚧     |
| **[PaperMC](https://papermc.io/software/paper)**     | A modern [Spigot](https://spigotmc.org) Fork. | 🚧     |
| **[FabricMC](https://fabricmc.net/)**                | A modern modded Minecraft Server solution.    | ❌      |

## Installation
Currently, you have to compile it yourself.

```shell
git clone https://github.com/BLUEAMETHYST-Studios/bluecloud.git
cd bluecloud
gradlew build
```

## Dependencies
> [!IMPORTANT]  
> Since this cloud system is not production-ready, we do not provide any dependencies. If you still want to use it you can push it to your MavenLocal by using `gradlew :api:publishToMavenLocal`.

<details>
  <summary>Maven</summary>
  
```xml
<dependencies>
    <dependency>
        <groupId>me.blueamethyst.bluecloud</groupId>
        <artifactId>api</artifactId>
        <version>${VERSION}"</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```
</details>

<details>
  <summary>Gradle</summary>
  
```groovy
dependencies {
    compileOnly 'me.blueamethyst.bluecloud:api:${VERSION}'
}
```
</details>

<details>
  <summary>Gradle (KTS)</summary>

```kotlin
dependencies {
    compileOnly("me.blueamethyst.bluecloud:api:${VERSION}")
}
```
</details>