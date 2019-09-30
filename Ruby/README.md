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

# Solution with Build files

# Solution with Build files

For Python we support only 1 build system

* [Rake](https://github.com/ruby/rake)