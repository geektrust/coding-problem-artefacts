This document explains how we compile and execute your solution in Ruby. __You **MUST** only submit source code and not the GEM file.__ 

# Solution without Build files

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

We build and run the solution by using the following command.

```ruby
ruby -W0 geektrust.rb <absolute_path_to_input_file>
```

# Solution with Dependency management and/or Build files

* [Bundler](https://bundler.io/v2.0/man/bundle-install.1.html)
* [Rake](https://github.com/ruby/rake)
* Bundler-Rake

# Bundler
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

We will install the dependencies and then build and run the solution by using the following commands.

```ruby
bundle install
ruby -W0 geektrust.rb <absolute_path_to_input_file>
```

### Adding unit tests

We use the following command to execute unit tests

```
bundle exec rspec
```

# Rake
Create a Rakefile with a `default` task like given in the [sample file](https://raw.githubusercontent.com/geektrust/coding-problem-artefacts/master/Ruby/Rakefile). The rake file should import the main ruby file, which is the starting point of your application and the call the `main` method within the `default` task.  The main file should read the file path from the `ARGV` variable and then execute the program. 

For e.g your `main.rb` file will look like this

```ruby
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

### Adding unit tests

We use the following command to execute unit tests

```
rake test
```



# Bundler-Rake
Create a Rakefile with a `default` task like given in the [sample file](https://raw.githubusercontent.com/geektrust/coding-problem-artefacts/master/Ruby/Rakefile). The rake file should import the main ruby file, which is the starting point of your application and the call the `main` method within the `default` task. Also create a Gemfile to add your dependencies, if any. The main file should read the file path from the `ARGV` variable and then execute the program. 

For e.g your `main.rb` file will look like this

```ruby
def main
    input_file = ARGV[1]
    # parse the file and process the command
    # print the output
end
```

We build and run the solution by using the following commands

```
bundle install
rake default <absolute_path_to_input_file>
```

### Adding unit tests

We use the following command to execute unit tests

```
bundle exec rpec
```

