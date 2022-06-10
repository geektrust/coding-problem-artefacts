This document covers following aspects of code evaluation for C++. 

* [Correctness](#correctness)

# Supported Versions

* 11
* 17

# Correctness

We expect your program to take the location to the text file as parameter. Input needs to be read from a text file, and output should be printed to the console. The text file will contain only commands in the format prescribed by the respective problem.

We then build and execute the solution by the following commands.

```
cd path/to/main.cpp
g++ <file1>.cpp <file2>.cpp ... <filen>.cpp main.cpp -o geektrust
./geektrust <absolute_path_to_input_file>
```

## Note :-
1. Put all your unit-test files if any, under a folder named `test`, `tests` or `UnitTest`.

## Starter Kit
* [CSharp Dotnet](https://geektrust.s3.ap-southeast-1.amazonaws.com/starter-kit/csharp-dotnet.zip)
