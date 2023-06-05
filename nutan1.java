import java.util.*;

public class nutan1 {
    public static Map<String, Integer> simulateEvent(List<Pair<String, Integer>> outcomes, int occurrences) {
        // Create a map to store simulation results
        Map<String, Integer> simulationResults = new HashMap<>();

        // Initialize simulation results with 0 occurrences for each outcome
        for (Pair<String, Integer> outcome : outcomes) {
            simulationResults.put(outcome.first, 0);
        }

        // Generate outcomes based on bias
        Random rand = new Random();

        // Extract probabilities from outcomes
        List<Integer> probabilities = new ArrayList<>();
        for (Pair<String, Integer> outcome : outcomes) {
            probabilities.add(outcome.second);
        }

        // Convert probabilities list to an array
        int[] probabilitiesArray = new int[probabilities.size()];
        for (int i = 0; i < probabilities.size(); i++) {
            probabilitiesArray[i] = probabilities.get(i);
        }

        // Perform the simulation for the specified number of occurrences
        for (int i = 0; i < occurrences; i++) {
            // Select an outcome based on weighted random selection
            String selectedOutcome = outcomes.get(weightedRandom(probabilitiesArray, rand)).first;
            // Update the occurrence count for the selected outcome
            simulationResults.put(selectedOutcome, simulationResults.get(selectedOutcome) + 1);
        }

        return simulationResults;
    }

    public static int weightedRandom(int[] weights, Random rand) {
        // Calculate the total weight
        int totalWeight = Arrays.stream(weights).sum();
        // Generate a random number between 1 and the total weight
        int randomNum = rand.nextInt(totalWeight) + 1;

        int sum = 0;
        // Iterate through the weights and determine the selected index
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if (randomNum <= sum) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // Example inputs
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

        // Simulate biased dice
        Map<String, Integer> diceResults = simulateEvent(biasedDice, 1000);
        System.out.println("Dice simulation results:");
        for (Map.Entry<String, Integer> result : diceResults.entrySet()) {
            System.out.println(result.getKey() + ": " + result.getValue());
        }

        // Simulate biased coin
        Map<String, Integer> coinResults = simulateEvent(biasedCoin, 1000);
        System.out.println("Coin simulation results:");
        for (Map.Entry<String, Integer> result : coinResults.entrySet()) {
            System.out.println(result.getKey() + ": " + result.getValue());
        }
    }

    // Pair class to store two values
    static class Pair<T, U> {
        T first;
        U second;

        Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }
}
