# Biased Event Simulation

This project provides an example of simulating events with biased outcomes using Java.


## Usage

1. Make sure you have Java Development Kit (JDK) installed on your machine.

2. Clone this repository or download the source code files.

3. Open the project in your preferred Java development environment (e.g., Eclipse, IntelliJ, or Visual Studio Code).

4. In the `main` method of the `nutan1` class, you'll find example inputs for simulating biased dice rolls and biased coin flips. You can modify these examples or create your own biased event scenarios by following the format:

    ```java
    List<Pair<String, Integer>> biasedDice = List.of(
        new Pair<>("1", 10),
        new Pair<>("2", 30),
        new Pair<>("3", 15),
        new Pair<>("4", 15),
        new Pair<>("5", 30),
        new Pair<>("6", 0)
    );
    
    List<Pair<String, Integer>> biasedCoin = List.of(
        new Pair<>("Head", 35),
        new Pair<>("Tail", 65)
    );
    
    Map<String, Integer> diceResults = simulateEvent(biasedDice, 1000);
    Map<String, Integer> coinResults = simulateEvent(biasedCoin, 1000);
    ```

    Adjust the biases and occurrences according to your requirements.


## Getting Started

To run the program, you need to have Java installed on your machine. Follow these steps:

1. Clone the repository or download the source code files.

2. Open a terminal or command prompt and navigate to the directory where the `nutan1.java` file is located.

3. Compile the Java file using the `javac` command:

```shell..   to compile
javac nutan1.java
Run the compiled program using the java command:

shell...    to run
java nutan1

6. The simulation results will be printed to the console, showing the occurrences of each outcome. 

## Prerequisites

- Java Development Kit (JDK) installed on your machine.
- Java compiler and runtime environment.


