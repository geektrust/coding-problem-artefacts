This document covers following aspects of code evaluation for Python. 

* [Build](#build)
* [Correctness](#correctness)
* [Unit tests](#unit-tests)

# Supported Versions

* 1.14.14
* 1.15.7
# Depedency Management

We only support the management of dependencies via [Go Modules](https://blog.golang.org/using-go-modules)

# Build

Every Go application can be built using the [go tool](https://golang.org/cmd/go/). It is the standard way to fetch, build, and install Go packages and commands. So we would be leveraging `go tool` for the same. The go tool requires you to organize your code in a specific way. Please read this [document](https://golang.org/doc/code.html) carefully. It explains the simplest way to get up and running with your Go installation.

However we expect a few things from your package and directory structure

# Package & Directory structure of your Go application

All your code for one coding problem should reside inside a package named `geektrust` under your Go workspace, which is typically the `GOPATH`. The name of the package should be `geektrust` and **NOT** be anything else.

Create your `geektrust` package path with the command - `mkdir $GOPATH/src/geektrust` 

Your directory structure should then look like this.

```
bin/
    geektrust                          # command executable
src/
    geektrust                          # main package
        main.go                        # start program file
        file_1.go                      # another file required
        subpackage1                  # a sub package you may write
            subpackage1.go           # a file under that sub package
```

The tree above shows a workspace containing the code you write to solve any Geektrust coding challenge in Go. The start file is `main.go` which may use `file_1.go` and the sub package `subpackage1`. The sub package will be imported by the files `main.go` and `file_1.go` with the help of base path `geektrust`. The import statement in this case will be

```	
import geektrust/subpackage1
```

# Correctness

We expect your program to take the location to the text file as parameter. Input needs to be read from a text file, and output should be printed to the console. The text file will contain only commands in the format prescribed by the respective problem.

This main file, `main.go` should receive in the command line argument and parse the file passed in. Once the file is parsed and the application processes the commands, it should only print the output.

For e.g your `main.go` file will look like this

```go
func main() {
	args := os.Args[1:] // absolute path to the test file 
	// parse the file and process the command
	// print the output
}

```

Once you have created your solution trying executing it by these commands from the directory `$GOPATH/src/geektrust`.

```
go build .
```

This will build an executable by the name `geektrust` in the directory `$GOPATH/src/geektrust` besides the `main.go` file . 

Execute the file from the directory `$GOPATH/src/geektrust` using the command 
```go
./geektrust <absolute_path_to_input_file>
```

We recommend it this way, so that the executable can load any relative files that you may be loading inside the application. 


# Unit tests

The unit tests are ran and the coverage is calculated using the library [gotestsum](https://github.com/gotestyourself/gotestsum). This is independent of your solution and there is no need to add any dependency. However this will work only if you use Go Modules for dependency managment.

We execute the unit tests by running the following command from the directory `$GOPATH/src/geektrust` 

```
gotestsum --hide-summary=all ./...
``` 

We check for the coverage of unit tests by executing the following command. from the directory `$GOPATH/src/geektrust`

```
gotestsum --hide-summary=all -- -coverprofile=cover.out ./...
``` 

