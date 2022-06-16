This document covers following aspects of code evaluation for C++. 

* [Correctness](#correctness)

# Supported Versions

* 11
* 17

# Correctness

We want you to name your `Main` file as `main.cpp`. This is the file that will contain your main method.

This file should receive in the command line argument and parse the file passed in. Once the file is parsed and the application processes the commands, it should only print the output.

For e.g your main.cpp file will look like this

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

## Starter Kit
* [CSharp Dotnet](https://geektrust.s3.ap-southeast-1.amazonaws.com/starter-kit/csharp-dotnet.zip)
