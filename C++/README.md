This document covers following aspects of code evaluation for C++. 

* [Build](#build)
* [Correctness](#correctness)

# Supported Versions

* 11
* 17

# Build

Every C++ application that doesn't use any Windows OS specific libabries can be built using the [g++ compiler](https://gcc.gnu.org/). It is one of the most popular way to build C++ projects. So we would be leveraging `g++ compiler` for the same. 

We require that you name your `Main` file as `main.cpp`. The folder containing the `main.cpp` will be considered as the root of your project and all the `g++` commands to build out the final executable will be fired from there.

# Correctness

We want you to name your `Main` file as `main.cpp`. This is the file that will contain your main method.

This file should receive in the command line argument and parse the file passed in. Once the file is parsed and the application processes the commands, it should only print the output.

For e.g your `main.cpp` file will look like this

```c++
int main(int argc, char *argv[]) {
    /*Sample code to read from file passed as command line argument*/
    string filename = argv[1];
    ifstream inputFile(filename);

    //Parse the file and call your code
    //Print the output

    inputFile.close();
    return 0;
}
```

We then build and execute the solution by the following commands.

```
cd path/to/main.cpp
g++ <file1>.cpp <file2>.cpp ... <filen>.cpp main.cpp -o geektrust
./geektrust <absolute_path_to_input_file>
```

## Note :-
1. Put all your unit-test files if any, under a folder named `test`.
2. Make your code OS agnostic, we will be building and running your code in Ubuntu Linux environment.

## Starter Kit
* [CSharp Dotnet](https://geektrust.s3.ap-southeast-1.amazonaws.com/starter-kit/csharp-dotnet.zip)
