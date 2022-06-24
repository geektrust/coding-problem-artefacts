# Coding Problem Artefacts

This is a repository which includes the instructions and artefacts required for solving the Backend [Geektrust coding problems](https://www.geektrust.in/coding-problem). Please only submit source files while submitting the solution.

This document covers following aspects of code evaluation. 

* Correctness
* Unit tests
* Build

## Languages we support

If you are solving the coding problem in any one of the languages given below, then follow the instructions from their respective ReadMe files by clicking on the link

* [Java](Java/README.md)
* [Python](Python/README.md)
* [C#](CSharp/README.md)
* [Ruby](Ruby/README.md)
* [Go](Go/README.md)
* [NodeJS/JavaScript/Typescript](NodeJS/README.md)
* [C++](C++/README.md)


## Correctness

We expect your program to take the location to the text file as parameter. Input needs to be read from a text file, and output should be printed to the console. The text file will contain only commands in the format prescribed by the respective problem. 

Please see the read me files of the language you have choosen for more details. 

## Unit tests

Unit tests are written to ensure that your public methods are working correctly. We recommend you to write unit tests. Please see the read me files of the language you have choosen for more details. 

You can also submit your solution without unit tests.

## Build

Build files help in automating the execution and testing for the solution. When you are writing your solution in a programming language that supports build & dependency management, we want you to add a build file to your solution, so that we can build, execute and test it.

You are also free to write code without any build file too, but that will affect your evaluation.

## Support for other languages

Apart from these we also support `Clojure`, `Erlang`, `Groovy`, `Kotlin`, `PHP` & `Scala` for our coding problems. However these do not have automated code correctness checks.  If you language of choice is one of these, please make sure:

* Your application is a command line application.
* Your main file to execute is named as `geektrust.<file ext>`
* It takes in a command line argument which is the location of the text file containing the commands that needs to be executed by your program.
* After processing, it should print only the output related to each command in the file.

For e.g, if you re solving in **PHP**, and your input file is `/tmp/input1.txt` then the command for executing your code should be:

```php geektrust.php /tmp/input1.txt```


For e.g , in case of family problem, if the input file passed in has these commands 

```
ADD_CHILD Chitra Aria Female 
GET_RELATIONSHIP Lavnya Maternal-Aunt 
GET_RELATIONSHIP Aria Siblings
```

then your solution should print.
```
CHILD_ADDITION_SUCCEEDED 
Aria 
Jnki Ahit
```