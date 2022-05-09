This document covers following aspects of code evaluation for Java.

* [Build](#build)
* [Correctness](#correctness)
* [Unit tests](#unit-tests)

# Supported Versions

* 1.8
* 1.11
* 1.15

# Build

For Java we support 2 build systems
* [Maven](http://maven.apache.org/) version 3.6.3
* [Gradle](https://gradle.org/) version 5.1

If you are new to build systems and have not used Maven or Gradle before, please read these articles to understand how to setup a Java project with:
* [Maven - How to create a Java Project with Maven](https://www.mkyong.com/maven/how-to-create-a-java-project-with-maven/)
* [Gradle - Building Java Application with Gradle](https://guides.gradle.org/building-java-applications/)

These articles are just guidelines to get you started. For Geektrust coding problems you have to use the `pom.xml` and `build.gradle` files we provide. You will have to use one of them in your Java project depending on what build file you select. Please download the files from here.
* [Maven -  pom.xml](https://raw.githubusercontent.com/geektrust/coding-problem-artefacts/master/Java/pom.xml)
* [Gradle - build.gradle](https://raw.githubusercontent.com/geektrust/coding-problem-artefacts/master/Java/build.gradle)


## Maven

In the Maven `pom.xml` file we have provided a [maven-assembly-plugin](https://maven.apache.org/plugins/maven-assembly-plugin/) which is used to create a single jar file, aggregated with its dependencies, modules, site documentation, and other files. Please do not edit the `finalName` (*geektrust* in this case) under its `configuration` section. Make sure the 'finalName' tag is inside the  maven-assembly-plugin configuration. This should generate an executable 'geektrust.jar' in the target folder.

Add the fully qualified name of your Main class file in the `mainClass` section under `manifest`. You can also edit the Group ID and the Artifact ID.

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


We build the solution by using the following command

```
mvn clean install -DskipTests -q assembly:single

```

## Gradle 

In the Gradle `build.gradle` file we have provided a [Gradle Jar Task](https://docs.gradle.org/current/dsl/org.gradle.api.tasks.bundling.Jar.html) which is used to create a build jar file. Please do not edit the `archiveBaseName` (*geektrust* in this case) under its `jar` section, and add the fully qualified name of your Main class file in the `attributes` section under `manifest`. You can also edit the Group ID. You can also add your dependencies if any to the 'dependencies' section. 
The required gradle version is 5.1. This should generate an executable 'geektrust.jar' in the build/libs folder.

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

We build the solution by using the following command

```
gradle clean build

```

# Correctness

We expect your program to take the location to the text file as parameter. Input needs to be read from a text file, and output should be printed to the console. The text file will contain only commands in the format prescribed by the respective problem.
## No build

If you are providing a solution without using the build file, we want you to name your `Main` class as `Geektrust.java`. This is the file that will contain your main method.

This file should receive in the command line argument and parse the file passed in. Once the file is parsed and the application processes the commands, it should only print the output. 

For e.g your `Geektrust.java` file will look like this

```java
public class Geektrust {

	public static void main(String[] args)  {
		String filePath = args[0];
		//Parse the file and call your code
		//Print the output
	}
....
....
}
```

We compile and run the solution by using the following commands. Make sure if your have any config files, it's in the classpath.

```
javac <path_of_package>/Geektrust.java
java -cp <code_path> <package>.Geektrust <absolute_path_to_input_file>
```

## Maven

Once the `maven` command to build the solution is executed, then we run the following command to execute the code.

```
java -jar <path_to>/geektrust.jar <absolute_path_to_input_file>
```

## Gradle

Once the `gradle` command to build the solution is executed, then we run the following command to execute the code.

```
java -jar <path_to>/geektrust.jar <absolute_path_to_input_file>
```


# Unit tests

We support only [JUnit](https://junit.org/junit5/) as the library to execute unit tests. JUnit should be added as a dependency to the build tool you are using, if you are writing unit tests for your solution.

For checking the unit test coverage we use [JaCoCo](https://www.eclemma.org/jacoco/trunk/index.html) as a plugin in Maven and Gradle.

## Maven

Please take a look at the `pom.xml` [file](https://raw.githubusercontent.com/geektrust/coding-problem-artefacts/master/Java/pom.xml) we have provided.

* JUnit

Please add `JUnit` as a dependency under the dependencies section. 

```
	<properties>
		<maven.compiler.source>1.8</maven.compiler.source>
		<maven.compiler.target>1.8</maven.compiler.target>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<java.version>1.8</java.version>
		<junit.jupiter.version>5.2.0</junit.jupiter.version>
		<junit.platform.version>1.2.0</junit.platform.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.junit.jupiter</groupId>
			<artifactId>junit-jupiter-engine</artifactId>
			<version>${junit.jupiter.version}</version>
			<scope>test</scope>
		</dependency>
	</dependencies>
```

* JaCoCo

JaCoCo need to be configured as a plugin for code coverage. A [jacoco-maven-plugin](https://www.eclemma.org/jacoco/trunk/doc/maven.html) is added under the `plugins` section.

```
	<!-- Code coverage plugin. Use only if you are adding unit tests. Do not change any of the values in the entries below -->
	<plugin>
		<groupId>org.jacoco</groupId>
		<artifactId>jacoco-maven-plugin</artifactId>
		<version>0.8.7</version>
		<executions>
			<execution>
				<goals>
					<goal>prepare-agent</goal>
				</goals>
			</execution>
			<execution>
				<id>report</id>
				<phase>test</phase>
				<goals>
					<goal>report</goal>
				</goals>
				<configuration>
					<formats><format>XML</format></formats>
					<outputDirectory>./</outputDirectory>
				</configuration>
			</execution>
		</executions>
	</plugin>
```

We execute the unit tests using the command 

```
mvn clean test
mvn jacoco:report 
```

## Gradle

Please take a look at the `build.gradle` [file](https://raw.githubusercontent.com/geektrust/coding-problem-artefacts/master/Java/build.gradle) we have provided.


* JUnit

Please add the JUnit dependency as given in the `build.gradle` file. Do not edit any sections of this as it helps us in capturing your unit tests and coverage.

```
test { ///Please do not change this
    useJUnitPlatform()
    testLogging {
        events "PASSED", "SKIPPED", "FAILED", "STANDARD_ERROR"
    }
    finalizedBy jacocoTestReport // report is always generated after tests run
    afterSuite { desc, result ->
        if (!desc.parent)
            println("${result.resultType} " +
                "(${result.testCount} tests, " +
                "${result.successfulTestCount} successes, " +
                "${result.failedTestCount} failures, " +
                "${result.skippedTestCount} skipped)")
        }
}
repositories {
     mavenCentral()
}

//Add your dependencies here
dependencies {
    testCompile group: 'org.junit.jupiter', name: 'junit-jupiter-engine', version:'5.2.0'
}
```

* JaCoCo

JaCoCo plugin should be added like given below.

```
plugins {
    id 'java'
    id 'jacoco'
}


jacoco { //Please do not change this
    toolVersion = "0.8.4"
    reportsDir = file("$buildDir/jacoco")
}

jacocoTestReport { //Please do not change this
    reports {
        xml.enabled true
        csv.enabled false
        html.enabled false
        xml.destination file("./jacoco.xml")
    }
}
```

We execute the unit tests using the command 

```
gradle clean test
```

## Starter Kits
* [Maven](https://geektrust.s3.ap-southeast-1.amazonaws.com/starter-kit/java-maven.zip)
* [Gradle](https://geektrust.s3.ap-southeast-1.amazonaws.com/starter-kit/java-gradle.zip)
