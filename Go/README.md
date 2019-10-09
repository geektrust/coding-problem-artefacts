# Handling Dependencies

We only support the management of dependencies via [Go Modules](https://blog.golang.org/using-go-modules)

From the documentation:

```

The go command resolves imports by using the specific dependency module versions listed in go.mod. 
When it encounters an import of a package not provided by any module in go.mod, the go command automatically looks up the module containing that package and adds it to go.mod, using the latest version.

```

So you just need to provide the `go.mod` file if you are using it.

# Building Go applications

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


# Build & Execution

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

Alternatively you can also test/run your application by running `go run main.go` from the directory `$GOPATH/src/geektrust`


