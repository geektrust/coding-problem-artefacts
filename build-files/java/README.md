## Why these build files?

Build files help in automating the execution and testing for the solution. When you are writing your solution in Java, we want you to add a build file to your solution, so that we can build, excute and test it.

For Java we support 2 build systems
* [Maven](http://maven.apache.org/)
* [Gradle](https://gradle.org/)

If you are new to build systems and have not used Maven or Gradle before please read these articles to understand how to setup a Java project with
* [How to create a Java Project with Maven](https://www.mkyong.com/maven/how-to-create-a-java-project-with-maven/)
* [Building Java Application with Gradle](https://guides.gradle.org/building-java-applications/)

These articles are just guidelines to get you started. For Geektrust coding problems you have to use the `pom.xml` and `build.gradle` files we provide. You will have to use one of them in your Java project depending on what build file you select. Please download the files from here.
* [Maven -  pom.xml](https://raw.githubusercontent.com/geektrust/coding-problem-artefacts/master/build-files/java/pom.xml)
* [Gradle - build.gradle](https://raw.githubusercontent.com/geektrust/coding-problem-artefacts/master/build-files/java/build.gradle)


### Maven pom.xml

In the Maven `pom.xml` file we have provided a [maven-jar-plugin](https://maven.apache.org/plugins/maven-jar-plugin/) which is used to create a build jar file. Please do not edit the `finalName` (*geektrust* in this case) under its `configuration` section, and add the fully qualified name of your Main class file in the `mainClass` section under `manifest`. You can also edit the Group ID and the Artifact ID.

For e.g if fully qualified name of your Main class in the project is `com.example.Main` then your `pom.xml` will look like this 
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.example</groupId>
	<artifactId>geektrust-problems</artifactId>
	<version>1.0</version>
	<properties>
		<maven.compiler.source>1.8</maven.compiler.source>
		<maven.compiler.target>1.8</maven.compiler.target>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<java.version>1.8</java.version>
	</properties>

	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-jar-plugin</artifactId>
				<configuration>
					<finalName>geektrust</finalName> <!-- Please do not change this final artifact name-->
					<archive>
					<manifest>
						<!-- This is main class of your program which will be executed-->
						<mainClass>com.example.Main</mainClass>
					</manifest>
					</archive>
				</configuration>
			</plugin>

		</plugins>
	</build>
</project>
```

### Gradle build.gradle

In the Gradle `build.gradle` file we have provided a [Gradle Jar Task](https://docs.gradle.org/current/dsl/org.gradle.api.tasks.bundling.Jar.html) which is used to create a build jar file. Please do not edit the `archiveBaseName` (*geektrust* in this case) under its `jar` section, and add the fully qualified name of your Main class file in the `attributes` section under `manifest`. You can also edit the Group ID.

For e.g if fully qualified name of your Main class in the project is `com.example.Main` then your `build.gradle` will look like this.

```
plugins {
    id 'java'
}

group = 'com.example'
version = '1.0'
sourceCompatibility = 1.8
targetCompatibility = 1.8


jar {
    archiveBaseName = 'geektrust' //Please do not change this final artifact name
    version =  null
    manifest {
        attributes 'Main-Class' : 'com.example.Main' //This is main class of your program which will be executed
    }
}

repositories {
     mavenCentral()
}
```