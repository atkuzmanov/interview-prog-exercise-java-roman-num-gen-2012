# ReadMe

RomanNumeralGeneratorTDD

I. Introduction – the Problem, Assumptions and Caveats

1. The Problem
We need to write a Java class that implements the following interface:
public interface RomanNumeralGenerator {
public String generate(int number);
}
For example, see the following sample inputs and outputs:

```text
1 = “I”
5 = “V”
10 = “X”
20 = “XX”
3999 = “MMMCMXCIX”
```

Please complete as soon as possible and return to my email address (zip files are ok but do not include executable or RAR files within them).

2. Caveats
Only support numbers between 1 and 3999

3. Assumptions
    a. Zero (0) does not exist.
    b. General assumptions about Roman Numerals, please see: http://en.wikipedia.org/wiki/Roman_numerals 

II. General Instructions

1. The folder “RomanNumeralGeneratorTDD” contains an Eclipse Indigo 32bit Java project which contains the solution.

2. The source files can be found in th “src” folder.

3. The test cases can be found in the “src.com.romannumgen.test” package/folder.

4. Since there was the requirement not to include any executable files to run the program import the project in Eclipse Indigo 32bit and run the RomView class as it contains a “public static void main(String[] args)” method.

III. Solution

To achieve a unique, non-trivial solution to this problem I have used the following approaches and techniques:

1. Test-Driven Development (TDD) – I have coded this solution by repeating the following cycle:

    a. Coding a test case which fails at first.

    b. Writing enough production code to make the test case pass.

    c. Write a new test case or refactor an existing test case which will compile but fail upon execution.

    d. Write or refactor enough production code to make the test case pass without breaking the previous test cases.


2. Object-Oriented Design (OOD) – I have modelled “RomanNumber” as an object and have used appropriate encapsulation.

3. I have implemented the Abstract Factory Creatioinal Design Pattern in order to achieve scalability and allow easy future extension and maintenance of the application. Please see the UML diagram in “Figure 1.” in “Solution Architecture” section or the enclosed picture file “Figure 1.jpg” in the “.\RomanNumeralGeneratorTDD\” directory.
    a. RomanNumeralGenerator interface is the abstract factory for creating a family of RomanNumeralGenerators. It declares an interface for operations that create abstract products.
    b. RomanNumeralGeneratorImpl (concrete factory) implements the RomanNumeralgenerator interface. It implements operations to create concrete products.
    c. RomanNum interface is an abstract product. It declares an interface for a type of product objects.
    d. RomanNumber is a product. It implements the AbstractProduct interface (RomanNumb) and defines a product to be created by the corresponding ConcreteFactory (RomanNumeralGeneratorImpl).
    e. RomClient uses the interfaces declared by the AbstractFactory and AbstractProduct classes.

4. I have also implemented the Model-View-Controller (MVC) Architectural Pattern for scalability and future extendibility and maintenance of the application and in this case for my Presentation tier which only includes a console-based user interface which seperates the information from the user’s direct interaction with it. Please see the UML diagram in “Figure 1.” in “Solution Architecture” section or the enclosed picture file “Figure 1.jpg” in the “.\RomanNumeralGeneratorTDD\” directory.
    
    a. RomanNumber represents the Model from MVC. It is similar to a JavaBean, except it does not have setter methods, as it is not required by the functionality at the current stage.
    
    b. RomView represents the View from MVC. It performs the responsibility of a View by showing relevant data to the user.
    
    c. RomClient represents the Controller from MVC. It performs the responsibility of a Controller by invoking the relevant functionality.

5. To ensure a thread-safe operation in a multi-threaded environment I have used Coarse Grained Locking via synchronized methods and Fine Grained Locking techniques via synchronized blocks locking on an objects internal monitor. I have been careful with using synchronization and taken into account the relevant performance impact.

6. I have used Exception Handling and thrown exceptions where appropriate to make sure the application fails in an non-obtrusive elegant manner giving useful debugging output such as a stacktrace which can be uncommented if required for debugging.

7. I believe I write code which is generally clean enough to be self-explanatory but I have added comments as part of good programming practices.

8. The algorithm used for transforming an Arabic numeral into a Roman numeral is explained in the comments in the code in RomanNumeralGeneratorImpl. I use a constant array which represents the table for transforming an Arabic number into a Roman number. When I get the input I traverse the table starting from the largest number and compare it to the imput number. If it’s value is larger or equal to the value in the RomanNumber, I subtract from it’s value the value of the RomanNumber and append it’s Roman representation equivalent to the result StringBuffer. At the end I return the resulting string.

IV. Solution Architecture

![1](Figure%201.jpg)

Figure 1.

----
