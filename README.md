# JsonToPojoGenerator

Tool written in Java to generate Java POJO's.

## Getting Started
1. Clone project
2. Build Project.
3. Run application

### Prerequisites

  - Java 1.8 or higher 
  - [JsonToJava](https://github.com/Sharelison/JsonToJava) dependency

### Usage

Print Java output to command line:

```
java -jar jsontopojogenerator.jar  -C Person -P com.example -J "{ "name": "eddy", "age": 12 }"

OUTPUT:

Java class result for: Person

package com.example;

public class Person{

    private String name;
    private Integer age;

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getAge(){
        return this.age;
    }

    public void setAge(Integer age){
        this.age = age;
    }

}
```

Save to .java file:

```
java -jar jsontopojogenerator.jar  -C Person -P com.example -J "{ "name": "eddy", "age": 12 }" -O output

OUTPUT:

A new file will be created: output/Person.java
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


## Authors

* **Sharelison** - [Sharelison](https://github.com/Sharelison)

