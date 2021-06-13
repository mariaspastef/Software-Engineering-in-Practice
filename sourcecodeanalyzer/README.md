# Source Code Analyzer  - Software Engineering in Practice

This is an assignment serving as a brief demonstration for Design Patterns for the needs of the lab tutorials of the Software Engineering in Practice course offered by the [Department of Management Science & Technology](https://www.dept.aueb.gr/el/dmst) of the Athens University of Economics and Business.
The goal of this assignment is to get familiar with design principles by refactoring code and applying design patterns on a given code base.

## Build Project

Build the executable Java application with:

```no-highlight
mvn package jacoco:report
```

## Run Project

Run the executable by executing:

```no-highlight
java –jar “jar-with-dependencies” arg0 arg1 arg2 arg3 arg4
```

were args translate to:
```no-highlight
arg0 = “JavaSourceCodeInputFile” (e.g., src/test/resources/TestClass.java)
arg1 = “sourceCodeAnalyzerType” [regex|strcomp]
arg2 = “SourceCodeLocationType” [local|web]
arg3 = “OutputFilePath” (e.g., ../output_metrics_file)
arg4 = “OutputFileType” [csv|json]
```

This is an example:
```no-highlight
java –jar ./target/sourcecodeanalyzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar ./src/test/resources/TestClass.java regex local metrics_results csv
```

## Design Patterns

The Design Patterns I would select for this project are the following:
* Facade Pattern
* Bridge Pattern
* Factory Pattern
* Strategy Pattern
* Null Object Pattern

## Facade Pattern

A facade is a class that provides a simple interface to a complex subsystem which contains lots of moving parts. A facade might provide limited functionality in comparison to working with the subsystem directly, but it includes only those features that clients really care about. Thus, a facade is an object that serves as a front-facing interface masking more complex underlying or structural code. 

I believe that a new class should be arranged, so that instead of the project working with all classes directly, the new facade class will encapsulate that functionality and hide it from the rest of the code.

In that way a simple interface will be provided to a complex system. The subsystem will be layered and de-coupled for clients and other subsystems, thereby promoting subsystem independence and portability and simplifying the dependencies between them by making them communicate with each other solely through their facades. This structure also helps minimize the effort of upgrading to future versions of the framework or replacing it with another one, which is also a big plus.
Although the Facade Pattern minimizes the complexity of sub-systems, it has the trade-off that the implementation is somewhat complex and especially with existing code.

## Bridge Pattern

Bridge Pattern splits a large class or a set of closely related classes into two separate hierarchies (abstraction and implementation) which can be developed independently of each other. It is useful when both the class and what it does vary often.

I believe that for the classes SourceCodeAnalyzer and MetricsExporter the Bridge Design Pattern should be used.

In that way the dimensions (types of output files and types of metrics calculated) can vary independently, minimizing changes in other dimensions. What is more, adding new types of output files and metrics calculated requires minimal changes in the hierarchy. Also, it follows the Single Responsibility Principle (You can focus on high-level logic in the abstraction and on platform details in the implementation) and Open/Closed Principle (You can introduce new abstractions and implementations independently from each other).
The disatvantage of using the Bridge Pattern is that the code might be made more complicated by applying the pattern to a highly cohesive class.

## Factory Pattern

Factory Pattern provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.
It is recommended when creating objects without exposing the instantiation logic to the clients and when providing a common interface to refer to all objects.

I would recommend using Factory Pattern to the class SourceFileReader, that handles the files given(because it's used extensively in the code of SourceCodeAnalyzer, whereas the methods of the preexisting class MetricsExporter is not used inside any other class except from main).

The benefits are that the logic to instantiate classes is separated, there is more flexibility and it follows the Single Responsibility Principle (You can move the product creation code into one place in the program, making the code easier to support) and Open/Closed Principle (You can introduce new types of files into the program without breaking existing code, or changing other dimensions).
The trade-off is that the code may become more complicated since new subclasses need to be introduced to implement the pattern. The best case scenario is when introducing the pattern into an existing hierarchy of creator classes.

## Strategy Pattern

Strategy Pattern helps define a family of algorithms, put each of them into a separate class, and make their objects interchangeable. The Strategy pattern suggests that a class that does something specific in a lot of different ways should be selected and all of these algorithms should be extracted into separate classes called strategies. It is recommended to use the Strategy Pattern when you want to use different variants of an algorithm within an object and be able to switch from one algorithm to another during runtime and when you have a lot of similar classes that only differ in the way they execute some behavior.

And thus in this Project I would reccomend that Strategy Pattern be implemented in class SourceFileReader (because it's used extensively in the code of SourceCodeAnalyzer, whereas the methods of the pre-existing class MetricsExporter is not used inside any other class except from main. That's why I think it's best to use Strategy Pattern instead of Bridge Pattern, since the Strategy Pattern is meant for behavior and the Bridge Pattern is meant for structure.).

The benefits are that there is much more freedom to choose algorithms and that the extensibility is easier. Also, You can swap algorithms used inside an object at runtime and isolate the implementation details of an algorithm from the code that uses it. It also follows the Open/Closed Principle (You can introduce new strategies without having to change the context).
The trade-off is that if you only have a couple of algorithms and they rarely change, there’s no real reason to overcomplicate the program with new classes and interfaces that come along with the pattern, but in this case the algorithms change very very often so I think it's a good idea to use the Strategy Pattern in this case.

## Null Object Pattern

The intent of a Null Object is to encapsulate the absence of an object by providing a substitutable alternative that offers suitable default do nothing behavior.

I would recommend using the Null Object Pattern in the pre-existing class that handles the files given to the project, since there are many checks for null in that code (and nowhere else in the project).

The benefits are that it simplifies the code, because it avoids having to write testing code which handles the null collaborator specially and it also removes the responsibility of Clients handling null cases.
What should be taken seriously is that by hiding errors and complicating testing, it can cause harm.