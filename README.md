# Coding Problem Artefacts

This is a repository which includes the instructions and artefacts required for solving the Backend [Geektrust coding problems](https://www.geektrust.in/coding-problem). We expect your program to  take the location to the test file as parameter. Input needs to be read from a text file, and output should be printed to the
console. The test file will contain only commands in the format prescribed by the respective problem. 

## Why build files?

Build files help in automating the execution and testing for the solution. When you are writing your solution in a programming language that supports build & dependency management, we want you to add a build file to your solution, so that we can build, execute and test it.

You are also free to write code without any build file too, but that will affect your evaluation.

## Languages we support for Automated Code Correctness

If you are solving the coding problem in any one of the languages given below, then follow the instructions from their respective ReadMe files by clicking on the link

* [Java](Java/README.md)
* [Python](Python/README.md)
* [C#](CSharp/README.md)
* [Ruby](Ruby/README.md)
* [Go](Go/README.md)
* [NodeJS/JavaScript/Typescript](NodeJS/README.md)

## Support for other languages

Apart from these we also support `Clojure`, `C++`, `Erlang`, `Groovy`, `Kotlin`, `PHP` & `Scala` for our coding problems. However these do not have automated code correctness checks.  If you language of choice is one of these, please make sure:
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

## What and where to submit the solution?

You should only submit source files of your solution as an archive file. Submit your entire project so that it includes your source, test and build files. Do not include only jar, exe, dll or gem files in your archive file.

If your solution is based on the languages we support for automated code correctness, then you should first select the code on the [Geektrust page](https://www.geektrust.in/coding-problem/upload) by selecting the appropriate problem, language and build tool. Once the code is selected click on `Run Tests` button to check if your I/O is passing. If so click on `Submit Code` to submit the code.

If you solution is outside of the languages we support for automated code correctness (Clojure, C++, Erlang, Groovy, Kotlin, PHP & Scala), then just select the file and submit it.

### What if my Run Tests are not working properly?

1. Check if your I/O is correct on your local system.
2. If you are using any of the build files, please ensure that you are following our instructions given in this repo for the specific language.
3. Ensure that you are only submiting source files. 
4. If it is still not working, please submit the code anyways. We will review it.
