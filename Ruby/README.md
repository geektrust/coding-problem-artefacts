This document covers following aspects of code evaluation for Ruby.

* [Build](#build)
* [Correctness](#correctness)
* [Unit tests](#unit-tests)

# Supported Versions

* 2.7.4
* 3.0.2
# Build

We support the use of these build tools for Ruby

* [Bundler](https://bundler.io/v2.0/man/bundle-install.1.html)
* [Rake] (https://github.com/ruby/rake)
* Bundler-Rake

## Bundler
Create a Gemfile to add your dependencies, if any. Name your `Main` file as `geektrust.rb`. This is the file that will contain your main method.

The `geektrust.rb` file should read the file path from the `ARGV` variable and then execute the program. This file should receive in the command line argument and parse the file passed in. Once the file is parsed and the application processes the commands, it should only print the output.

For e.g your `geektrust.rb` file will look like this

```ruby
def main
    input_file = ARGV[0]
    # parse the file and process the command
    # print the output
end

main
```

We will install the dependencies and then build the solution by using the following command.

```ruby
bundle install
```

## Rake

Create a Rakefile with a default task like given in the sample file. The rake file should import the main ruby file, which is the starting point of your application and the call the main method within the default task. The main file should read the file path from the ARGV variable and then execute the program.

For e.g your main.rb file will look like this
```
def main
    input_file = ARGV[1]
    # parse the file and process the command
    # print the output
end
```
We build and run the solution by using the following command
```
rake default <absolute_path_to_input_file>
```
## Bundler-Rake

This is the case where both `Gemfile` and `Rakefile` are used to manage the dependencies and build the solution.

Create a Rakefile with a `default` task like given in the [sample file](https://raw.githubusercontent.com/geektrust/coding-problem-artefacts/master/Ruby/Rakefile). The rake file should import the main ruby file, which is the starting point of your application and the call the `main` method within the `default` task. Also create a Gemfile to add your dependencies, if any. The main file should read the file path from the `ARGV` variable and then execute the program. 

For e.g your `main.rb` file will look like this

```ruby
def main
    input_file = ARGV[1]
    # parse the file and process the command
    # print the output
end
```

We build the solution by using the following command.

```
bundle install
```

# Correctness

We expect your program to take the location to the text file as parameter. Input needs to be read from a text file, and output should be printed to the console. The text file will contain only commands in the format prescribed by the respective problem.

## Execution
### No build

If you are providing a solution without using the build file, we want you to name your `Main` file as `geektrust.rb`. This is the file that will contain your main method.

This file should receive in the command line argument and parse the file passed in. Once the file is parsed and the application processes the commands, it should only print the output.

For e.g your `geektrust.rb` file will look like this

```ruby
def main
    input_file = ARGV[0]
    # parse the file and process the command
    # print the output
end

main
```

We run the solution by using the following command.

```ruby
ruby -W0 geektrust.rb <absolute_path_to_input_file>
```

### Bundler

Once the `bundle install` command from the previous build process is complete, we will execute the program using the command

```ruby
ruby -W0 geektrust.rb <absolute_path_to_input_file>
```

### Rake

Once the `bundle install` command from the previous build process is complete, we will execute the program using the command

```ruby
rake default <absolute_path_to_input_file>
```
### Bundler-Rake

We will execute the program using the command

```ruby
rake default <absolute_path_to_input_file>
```

# Unit tests

We support only [RSpec](https://rspec.info/) library for unit testing your Ruby code. We also use the code coverage tool [simple-cov](https://github.com/simplecov-ruby/simplecov) to calculate the unit test coverage. You are not expected to add the `simple-cov` library to your Gemfile, as it will be taken care by us. 

We expect the unit tests to be in either of these four folders:
* spec
* specs
* test
* tests

## Bundler

We run the unit tests and calculate the coverage executing the command 

```ruby
rspec
```

## Rake

In your `Rakefile` add the `RSpec` task. 

```
RSpec::Core::RakeTask.new(:spec)
```

Please see the [sample file](https://raw.githubusercontent.com/geektrust/coding-problem-artefacts/master/Ruby/Rakefile) provided.


We run the unit tests and calculate the coverage executing the command 

```ruby
rspec
```

## Bundler-Rake

We run the unit tests and calculate the coverage executing the command 

```ruby
rspec
```
