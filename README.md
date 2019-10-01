# Coding Problem Artefacts

This is a repository which includes the instructions and artefacts required for solving the Backend [Geektrust coding problems](https://www.geektrust.in/coding-problem). 

We provide these instructions so that the checking of correctness of your solution can be automated. Trust us, one day you will be able to check the correctness of your code while submitting itself :)

## Why build files?

Build files help in automating the execution and testing for the solution. When you are writing your solution in a programming language that supports build & dependency management, we want you to add a build file to your solution, so that we can build, execute and test it.

You are also free to write code without any build file too, but that will affect your evaluation.

## Languages we support for Automated Code Correctness

If you are solving the coding problem in any one of the languages given below, then follow the instructions from their respective ReadMe files by clicking on the link

* [Java](Java/README.md)
* [Python](Python/README.md)
* [C#](CSharp/README.md)
* [Ruby](Ruby/README.md)
* [NodeJS/JavaScript](NodeJS/README.md)


If you language of choice is not available in the list, please make sure:
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
