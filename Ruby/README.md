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

This program can be executed with the command 
```ruby
ruby -W0 main.rb <absolute_path_to_input_file>
```

# Solution with Build files

For Ruby we support only 1 build system

* [Rake](https://github.com/ruby/rake)


Create a Rakefile with a `default` task like given in the [sample file](https://raw.githubusercontent.com/geektrust/coding-problem-artefacts/master/Ruby/Rakefile). The rake file should import the main ruby file, which is the starting point of your application and the call the `main` method within the `default` task. Also create a Gemfile to add your dependencies, if any. The main file should read the file path from the `ARGV` variable and then execute the program. 

For e.g your `main.rb` file will look like this

```ruby
def main
    input_file = ARGV[1]
    # parse the file and process the command
    # print the output
end
```

The command to build and execute will be 

```
bundle install
rake default <absolute_path_to_input_file>
```

