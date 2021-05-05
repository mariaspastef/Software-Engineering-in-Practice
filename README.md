# Build Automation Tools - Software Engineering in Practice

[![Build Status](https://travis-ci.com/mariaspastef/Software-Engineering-in-Practice.svg?token=7myoYu74yz4JRcU6eKXw&branch=main)](https://travis-ci.com/mariaspastef/Software-Engineering-in-Practice)

This repository serves as a basic demonstration of the build automation tools (i.e., Maven) for the needs of the Software Eningineering in Practice course offered by the [Department of Management Science & Technology](https://www.dept.aueb.gr/el/dmst) of the Athens University of Economics and Business.
The goal of this repository is to present the structure of a multi-module Maven project.

## Project Structure

This repository consists of a parent Maven project and one sub-project (module).

[Grades Histogram Generator](https://github.com/mariaspastef/Software-Engineering-in-Practice/tree/development/gradeshistogram) - creates a Histogram from a given file of Grades

Execute the following command in the repository root directory in order to build all modules, in this case the module Grades Histogram Generator.

```no-highlight
mvn package
```

This command generates a seperate jar file in each module's corresponding target (`module/target`) directory, in this Grades Histogram Generator module/target directory.

### Grades Histogram Generator

This module requires one runtime dependency which is packaged in the main jar (fat-jar). To create a fat-jar you need to use the `maven-assembly-plugin` plugin and also define the class that is the main entry point of the system (the class that contains the main method).

```no-highlight
<plugin>
	<artifactId>maven-assembly-plugin</artifactId>
	<configuration>
		<archive>
			<manifest>
			<!-- replace this with the class that contains the main method. It requires also the package name if exists. -->
				<mainClass>gradeshistogram.HistogramGenerator</mainClass> 
			</manifest>
		</archive>
		<descriptorRefs>
			<descriptorRef>jar-with-dependencies</descriptorRef>
		</descriptorRefs>
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
```

The produced jar is located in the target directory. The grades file should be given at runtime as a command-line argument and can be executed as following:

```no-highlight
java -jar gradeshistogram/target/gradeshistogram-0.0.1-SNAPSHOT-jar-with-dependencies.jar grades.txt
```

Note that the gradeshistogram-0.0.1-SNAPSHOT.jar is not executable.

## How to

1. Setup Maven in Linux. Execute `sudo apt update && sudo apt install maven` in a terminal.
2. Setup Maven in [Windows](https://mkyong.com/maven/how-to-install-maven-in-windows/).

## Third Lab Assignment

For the third Lab Assignment this is the [individual README file](https://github.com/mariaspastef/Software-Engineering-in-Practice/blob/development/unittesting/README.md).