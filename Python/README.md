This document covers following aspects of code evaluation for Python. 

* [Correctness](#correctness)
* [Build](#build)
* [Unit tests](#unit-tests)

# Supported Versions

* 3.8
* 3.9

# Correctness

We expect your program to take the location to the text file as parameter. Input needs to be read from a text file, and output should be printed to the console. The text file will contain only commands in the format prescribed by the respective problem.

The main file should be named `geektrust.py`. To check your solution we the execute the command 
```
python -m geektrust <absolute_path_to_input_file>
```

# Build
## No Build

If you are providing a solution without using the build file, we want you to name your `Main` file as `geektrust.py`. This is the file that will contain your main method.

This file should receive in the command line argument and parse the file passed in. Once the file is parsed and the application processes the commands, it should only print the output.

For e.g your `geektrust.py` file will look like this

```python
def main():
    input_file = sys.argv[1]
    # sys.argv[1] should give the absolute path to the input file
    # parse the file and process the command
    # print the output

if __name__ == "__main__":
    main()

```

We build and run the solution by using the following command.

```
python -m geektrust <absolute_path_to_input_file>
```

## Pip

For Python we support only one build tool [Pip](https://pip.pypa.io/en/stable/user_guide/)

Pip is package manager for Python. That means it’s a tool that allows you to install and manage additional libraries and dependencies that are not distributed as part of the standard library. 

The `pip install` command always installs the latest published version of a package, but sometimes, you may want to install a specific version that you know works with your code. You want to create a specification of the dependencies and versions you used to develop and test your application, so there are no surprises when you use the application in production.

Requirement files allow you to specify exactly which packages and versions should be installed. 

A sample `requirements.txt` file can be downloaded from [here](https://raw.githubusercontent.com/geektrust/coding-problem-artefacts/master/Python/requirements.txt)


### Building and running the solution

The `Main` file should be named as `geektrust.py`. This is the file that will contain your main method.

This file should receive in the command line argument and parse the file passed in. Once the file is parsed and the application processes the commands, it should only print the output.

For e.g your `geektrust.py` file will look like this

```python
def main():
    input_file = sys.argv[1]
    # parse the file and process the command
    # print the output

if __name__ == "__main__":
    main()

```

We build and run the solution by using the following commands

```
pip install -r requirements.txt
python -m geektrust <absolute_path_to_input_file>
```


# Unit tests

For Python we currently support only the inbuilt [unittest](https://docs.python.org/3/library/unittest.html) framework. For test coverage we use [Coverage](https://coverage.readthedocs.io/en/coverage-5.5/) framework. 

The unit tests are checked by the command -

```
python -m unittest discover
```

The unit test coverage is found by the command -

```
coverage run -m unittest discover
```

## Starter Kit
* [Python Pip](https://geektrust.s3.ap-southeast-1.amazonaws.com/starter-kit/python-pip.zip)
