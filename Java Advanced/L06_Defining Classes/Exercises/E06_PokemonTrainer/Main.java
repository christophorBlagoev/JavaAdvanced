package Exercises.E06_PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map< String, Trainer > trainerInfo = new LinkedHashMap<>();
        String input = "";

        while (!"Tournament".equals(input = scanner.nextLine())) {
            String[] inputData = input.split("\\s+");
            String trainerName = inputData[0];
            String pokemonName = inputData[1];
            String pokemonElement = inputData[2];
            int pokemonHealth = Integer.parseInt(inputData[3].trim());

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            trainerInfo.putIfAbsent(trainerName, new Trainer(trainerName, new ArrayList<>(), 0));
            trainerInfo.get(trainerName).getPokemonList().add(pokemon);
        }

        while (!"End".equals(input = scanner.nextLine())) {
            for (Trainer value : trainerInfo.values()) {
                String finalInput = input;
                boolean isFound = value.getPokemonList().stream()
                        .anyMatch(e -> e.getElement().equals(finalInput));

                if (isFound) {
                    value.setCountBadges(value.getCountBadges() + 1);
                } else {
                    value.getPokemonList().forEach(pokemon -> pokemon.setHealth(pokemon.getHealth() - 10));
                    value.setPokemonList(value.getPokemonList().stream().filter(e -> e.getHealth() > 0)
                            .collect(Collectors.toList()));
                }
            }
        }

        trainerInfo.entrySet()
                .stream()
                .sorted(Map.Entry.< String, Trainer >comparingByValue(Comparator.comparing(Trainer::getCountBadges)).reversed())
                .forEach(e -> System.out.printf("%s %d %d%n"
                        , e.getValue().getName()
                        , e.getValue().getCountBadges()
                        , e.getValue().getPokemonList().size()));
    }
}
