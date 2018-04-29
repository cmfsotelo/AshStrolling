package com.example.csotelo.ashstrolling.core;

public class AshStroll {
    public static void main(String[] args) {

        try {
            String path = "";
            if (args.length > 0) {
                path = args[0];
            }
            Ash ash = new Ash();
            int totalPokemon = ash.catchPokemonInPath(path.toLowerCase());
            System.out.println("Ash cought " + totalPokemon + " pokemon!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}