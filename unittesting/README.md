# Unit Testing - Software Engineering in Practice

This is an assignment serving as a brief demonstration for Unit Testing for the needs of the lab tutorials of the Software Engineering in Practice course offered by the [Department of Management Science & Technology](https://www.dept.aueb.gr/el/dmst) of the Athens University of Economics and Business.
The goal of this assignment is to get familiar with unit testing and continuous integration.

## Build Project

In order to build the project execute the following Maven command:

```no-highlight
mvn clean install jacoco:report
```

This command will also generate a report of the code coverage produced by JaCoCo. The report will be located in the following path of the module:

```no-highlight
target/site/jacoco
```

## Test Project

To simply run the unit tests of the project, execute the following Maven command:

```no-highlight
mvn test
```

Important: Note that only classes with a `Test` suffix located in the `src/test` will be executed and reported as Tests.

## Generate Test-coverage report

To simply run the unit tests of the project, execute the following Maven command:

```no-highlight
mvn test jacoco:report
```

## Continuous Integration service

This module utilizes TravisCI services in other to test and build the application upon each `git-push` in the remote repository. You can check the `jdk` tag in the `.travis.yml` file for more info.

After each build, the badge is updated with the corresponding build status, `green` for passes and `red` for failures.
