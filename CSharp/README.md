We only support **.NET Core 2.2** for C# applications.

The only requirement here is you should add an `AssemblyName` entry with the value `geektrust` in your `.csproj` file. 

Given below is a sample 

```
<Project Sdk="Microsoft.NET.Sdk">
  <PropertyGroup>
    <OutputType>Exe</OutputType>
    <TargetFramework>netcoreapp2.2</TargetFramework>
    <RootNamespace>geektrust_family_demo</RootNamespace>
    <!-- Add a assembly name entry to your project and name it geektrust-->
    <AssemblyName>geektrust</AssemblyName> 
  </PropertyGroup>
</Project>
```

This will ensure that the `dll` file will be created by the name `geektrust.dll`. 

We then build and execute the solution by the following commands.

```
dotnet build -o geektrust
dotnet geektrust/geektrust.dll <absolute_path_to_input_file>
```

Please refer [this sample application](https://github.com/geektrust/geektrust-csharp-family-demo) to know how a `C#` application will be checked for correctness.

**For FamilyTree**

You need to initialise the family tree on program start. The command line argument file should only contain statements for modifying and verifying the family tree. Once this file is parsed and the application processes the commands, it should only print the output.
