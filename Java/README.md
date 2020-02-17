# Solution without Build files

If you are providing a solution without using the build file, we want you to name your `Main` class as `Geektrust.java`. This is the file that will contain your main method.

This file should receive in the command line argument and parse the file passed in. Once the file is parsed and the application processes the commands, it should only print the output. You need to initialise the family tree on program start. The command line argument file should only contain statements for modifying and verifying the family tree.

For e.g your `Geektrust.java` file will look like this

```java
public class Geektrust {

	public static void main(String[] args)  {
		initialiseFamilyTree();
		String filePath = args[0];
		//Parse the file and call your code
		//Print the output
	}
	private static void initialiseFamilyTree(){
		// Initialise the existing family tree
	}
....
....
}
```

We build and run the solution by using the following commands

```
javac <path_of_package>/Geektrust.java
java <package>.Geektrust <absolute_path_to_input_file>
```


# Solution with Build files

For Java we support 2 build systems
* [Maven](http://maven.apache.org/)
* [Gradle](https://gradle.org/)

If you are new to build systems and have not used Maven or Gradle before, please read these articles to understand how to setup a Java project with:
* [Maven - How to create a Java Project with Maven](https://www.mkyong.com/maven/how-to-create-a-java-project-with-maven/)
* [Gradle - Building Java Application with Gradle](https://guides.gradle.org/building-java-applications/)

These articles are just guidelines to get you started. For Geektrust coding problems you have to use the `pom.xml` and `build.gradle` files we provide. You will have to use one of them in your Java project depending on what build file you select. Please download the files from here.
* [Maven -  pom.xml](https://raw.githubusercontent.com/geektrust/coding-problem-artefacts/master/Java/pom.xml)
* [Gradle - build.gradle](https://raw.githubusercontent.com/geektrust/coding-problem-artefacts/master/Java/build.gradle)


## Maven pom.xml

In the Maven `pom.xml` file we have provided a [maven-assembly-plugin](https://maven.apache.org/plugins/maven-assembly-plugin/) which is used to create a single jar file, aggregated with its dependencies, modules, site documentation, and other files. Please do not edit the `finalName` (*geektrust* in this case) under its `configuration` section. Make sure the 'finalName' tag is inside the  maven-assembly-plugin configuration. This should generate an executable 'geektrust.jar' in the target folder.

Add the fully qualified name of your Main class file in the `mainClass` section under `manifest`. You can also edit the Group ID and the Artifact ID.

We build and run the solution by using the following command

```
java -jar geektrust.jar <path_to_input_file>

```

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
				<artifactId>maven-assembly-plugin</artifactId>
				<configuration>
					<finalName>geektrust</finalName> <!-- Please do not change this final artifact name-->					
					<descriptorRefs>
						<descriptorRef>jar-with-dependencies</descriptorRef>
					</descriptorRefs>
					<appendAssemblyId>false</appendAssemblyId>
					<archive>
						<manifest>
							<addClasspath>true</addClasspath>
							<!-- This is the main class of your program which will be executed-->
							<mainClass>com.example.Main</mainClass>
						</manifest>
					</archive>
				</configuration>

				<executions>
					<execution>
						<id>make-assembly</id>
						<phase>package</phase>
						<goals>
							<goal>single</goal>
						</goals>
					</execution>
				</executions>
			</plugin>

		</plugins>
	</build>
</project>
```

## Gradle build.gradle

In the Gradle `build.gradle` file we have provided a [Gradle Jar Task](https://docs.gradle.org/current/dsl/org.gradle.api.tasks.bundling.Jar.html) which is used to create a build jar file. Please do not edit the `archiveBaseName` (*geektrust* in this case) under its `jar` section, and add the fully qualified name of your Main class file in the `attributes` section under `manifest`. You can also edit the Group ID. You can also add your dependencies if any to the 'dependencies' section. 
The required gradle version is 5.1. This should generate an executable 'geektrust.jar' in the build/libs folder.

We build and run the solution by using the following command

```
java -jar geektrust.jar <path_to_input_file>

```

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
    version =  null               //Please do not change this final artifact version
    archiveBaseVersion = null     //Please do not change this final artifact version
    manifest {
        attributes 'Main-Class' : 'com.example.Main' //This is main class of your program which will be executed
    }

	// To create a single jar with all dependencies.
    from {
        configurations.runtimeClasspath.collect { it.isDirectory() ? it : zipTree(it) }
    } {
        exclude "META-INF/*.SF"
        exclude "META-INF/*.DSA"
        exclude "META-INF/*.RSA"
    }
}

repositories {
     mavenCentral()
}

//Add your dependencies here
dependencies {
}

```

### Compile and Execution

For `Maven` run the following commands to compile & execute

```
mvn clean install 
java -jar <path_to>/geektrust.jar <absolute_path_to_input_file>
```

For `Gradle` run the following commands to compile & execute

```
gradle clean build
java -jar <path_to/geektrust.jar <absolute_path_to_input_file>
```
