# Welcome To Chenyue's Fibonacci REST API

This is a coding assignment for an internal inteview

  - Author: Chenyue Gao
  - Date: June 8th 2018

# Features!

  - Get a Fibonacci Sequence at position n
  - Get a single Fibonacci Number at position n

# Deploy

### Prerequisites
Git 2.10.1 or above
Mavan 3.3.9 or above
JDK 1.8

### Get source code
```sh
$ mkdir inteview
$ cd inteview
$ git clone https://github.com/gaochenyue/fibonacci.git
```
### build
```sh
$ cd fibonacci
$ mvn clean package
```

### start the server
```sh
$ java -jar target/fibonacci-1.0.0.jar
```
# Usage

### Home page with REST API instruction and Examples
```sh
http://localhost:8080/
```
### REST API to get fibonacci sequence at position n
```sh
GET http://localhost:8080/fibonacci/sequence/{n}
```
#### n is the position of fibonacci number. It should be an positive integer
#### Sample Response
```sh
{
  "fibonacciSequence" : [ {
    "position" : 0,
    "value" : 0
  }, {
    "position" : 1,
    "value" : 1
  }, {
    "position" : 2,
    "value" : 1
  }, {
    "position" : 3,
    "value" : 2
  } ]
}
```

### REST API to get fibonacci number at position n
```sh
GET http://localhost:8080/fibonacci/number/{n}
```
#### n is the position of fibonacci number. It should be an positive integer
#### Sample Response
```sh
{
  "position" : 6,
  "value" : 8
}
```


