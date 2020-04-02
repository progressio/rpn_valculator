# RPN(reverse polish notation) calculator

This is command-line calculator which supports 4 basic arithmetic operations(+ - * /).
Implemented as part of Svitla Systems, Inc. interview "home work".

## Requirements

1. The calculator should use standard input and standard output
1. It should implement the four standard arithmretic operators
1. The calculator should handle errors and recover gracefully
1. The calculator should exit when it receives a q command or an end of input indicator (EOF / Ctrl+D)

## Technical decisions

I identified that project should be "interactive cli application" which means run once and make a dialog.
So I had to skip following libraries:
1. [commons-cli](http://zetcode.com/java/console/) - doesn't support interactive cli
1. [picocli](https://picocli.info/) - the same:
    1. [one tutorial](https://picocli.info/migrating-from-commons-cli.html)
    1. [another tutorial](https://www.baeldung.com/java-picocli-create-command-line-program)

Also there were applicable libs:
1. [Spring Shell](https://docs.spring.io/spring-shell/docs/current/reference/htmlsingle/) - requires deep investigation to customize for my needs
1. [picocli-shell-jline3](https://github.com/remkop/picocli/tree/master/picocli-shell-jline3) - looks complicated in code

A high-level description of your solution
Reasoning behind your technical choices, including architectural
Trade-offs you might have made, anything you left out, or what you might do differently if you were to spend additional time on the project
How to run your code, if applicable
Link to the hosted application, if applicable

STORY:
not used commons-cli(not interactive): http://zetcode.com/java/console/
not used picocli(same):
- https://picocli.info/migrating-from-commons-cli.html
- https://www.baeldung.com/java-picocli-create-command-line-program
alternative Spring Shell https://docs.spring.io/spring-shell/docs/current/reference/htmlsingle/
alternative picocli-shell-jline3 https://github.com/remkop/picocli/tree/master/picocli-shell-jline3

## Installation

Application requires *Java 8* to build.

Clone code from GitHub, make sure you have some JRE/JDK installed and build the project:

```sh
$ cd rpn_calculator
$ sh gradlew clean build jar
```

## Usage

Application requires *Java 8* to run.

```sh
$ cd rpn_calculator/build/libs
$ java -jar rpn_calculator-1.0-SNAPSHOT.jar
$ > 1 1 +
```
**Hints!**
1. use ```CTRL+D``` or ```q``` commands to exit application interactive mode
1. use ```-help``` for some help

## License

GNU GPL v3

## Links:
- task https://gist.github.com/joedean/078a62b9ec03b38dfc519b3a5f168b07
- RPN wiki https://en.wikipedia.org/wiki/Reverse_Polish_notation
- java colutions overview https://dzone.com/articles/interactive-console-applications-in-java
- code examples:
    - gradle runnable jar https://gist.github.com/TurekBot/4a3cd406cb52dfd8bfb8022b982f0f6c
    - cli reader https://stackoverflow.com/a/10412853
    - online tester https://www.dcode.fr/reverse-polish-notation
