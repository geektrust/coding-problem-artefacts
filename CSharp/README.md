This document covers following aspects of code evaluation for C#. 

* [Build](#build)
* [Correctness](#correctness)
* [Unit tests](#unit-tests)

# Supported Versions

* 2.2
* 3.1
* 5.0

# Build

The only requirement here is you should add an `AssemblyName` entry with the value `geektrust` in your `.csproj` file. 

Given below is a sample 

```
<Project Sdk="Microsoft.NET.Sdk">
  <PropertyGroup>
    <OutputType>Exe</OutputType>
    <TargetFramework>netcoreapp3.1</TargetFramework>
    <RootNamespace>geektrust_family_demo</RootNamespace>
    <!-- Add a assembly name entry to your project and make sure it is geektrust-->
    <AssemblyName>geektrust</AssemblyName>
  </PropertyGroup>
</Project>
```
This will ensure that the `dll` file will be created by the name `geektrust.dll`. 

We then build the solution by the following commands.

```
dotnet build -o geektrust
```

# Correctness

We expect your program to take the location to the text file as parameter. Input needs to be read from a text file, and output should be printed to the console. The text file will contain only commands in the format prescribed by the respective problem.

We then build and execute the solution by the following commands.

```
dotnet build -o geektrust
dotnet geektrust/geektrust.dll <absolute_path_to_input_file>
```

# Unit tests

We expect you to create a separate project for Unit testing and assume that it will import the main project. 

We support `xUnit` and `NUnit` for unit testing and use [`Coverlet`](https://github.com/coverlet-coverage/coverlet) for checking the test coverage. Take a look at [this page](https://docs.microsoft.com/en-us/dotnet/core/testing/) for more info on unit testing in C#

Given below is a sample `.csproj` file for `xUnit` 

```
<Project Sdk="Microsoft.NET.Sdk">

  <PropertyGroup>
    <TargetFramework>netcoreapp3.1</TargetFramework>
    <IsPackable>false</IsPackable>
  </PropertyGroup>

  <ItemGroup>
    <PackageReference Include="Microsoft.NET.Test.Sdk" Version="16.7.1" />
    <PackageReference Include="xunit" Version="2.4.1" />
    <PackageReference Include="xunit.runner.visualstudio" Version="2.4.3">
      <IncludeAssets>runtime; build; native; contentfiles; analyzers; buildtransitive</IncludeAssets>
      <PrivateAssets>all</PrivateAssets>
    </PackageReference>
  </ItemGroup>

  <ItemGroup>
    <ProjectReference Include="..\SampleProject\SampleProject.csproj" />
  </ItemGroup>

</Project>

```

To execute the test cases we run the command 

```
dotnet test
```

For calculating the coverage we run the command

```
dotnet test --collect="XPlat Code Coverage"
```

_Note_: Please refer [this sample application](https://github.com/geektrust/geektrust-csharp-family-demo) to know how a `C#` application will be checked for build, correctness & unit tests.

## Starter Kit
* [CSharp](https://geektrust.s3.ap-southeast-1.amazonaws.com/starter-kit/csharp-dotnet.zip)
