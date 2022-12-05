package com.home.vkovalchuk.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class First {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("5.txt"));
            StringBuilder result = new StringBuilder();
            int numberOfCategories = 0;
            boolean haveNumberOfCategories = false;
            boolean haveCategories = false;
            List<ArrayDeque<Character>> stacks = new ArrayList<>();
            while (true) {
                String currentLine = br.readLine();
                if (currentLine == null) break;

                if (!haveNumberOfCategories) {
                    haveNumberOfCategories = true;
                    numberOfCategories = (currentLine.length() + 1) /4;
                    for (int i = 0; i < numberOfCategories; i++) {
                        stacks.add(new ArrayDeque<>());
                    }
                }

                if (currentLine.charAt(1) == '1') {
                    haveCategories = true;
                    currentLine = br.readLine();
                    currentLine = br.readLine();
                }

                if (!haveCategories) {
                    addLettersToStacks(numberOfCategories, stacks, currentLine);
                } else {
                    replaceLetters(stacks, currentLine);
                }
            }
            br.close();
            showResult(result, numberOfCategories, stacks);
        } catch (IOException e) {
            System.out.println("Oooops, reading error (maybe file not found)!");
        }
    }

    private static void showResult(StringBuilder result, int numberOfCategories, List<ArrayDeque<Character>> stacks) {
        for (int i = 0; i < numberOfCategories; i++) {
            result.append(stacks.get(i).peek());
        }
        System.out.println(result);
    }

    private static void replaceLetters(List<ArrayDeque<Character>> stacks, String currentLine) {
        currentLine = currentLine.replace("move ", "");
        currentLine = currentLine.replace(" from ", " ");
        currentLine = currentLine.replace(" to ", " ");
        String[] indicators = currentLine.split(" ");
        int numberOfCrates = Integer.parseInt(indicators[0]);
        int numberFromStack = Integer.parseInt(indicators[1]);
        int numberToStack = Integer.parseInt(indicators[2]);

        for (int i = 0; i < numberOfCrates; i++) {
            stacks.get(numberToStack - 1).push(stacks.get(numberFromStack - 1).pop());
        }
    }

    private static void addLettersToStacks(int numberOfCategories, List<ArrayDeque<Character>> stacks, String currentLine) {
        for (int i = 0; i < numberOfCategories; i++) {
            char currentChar = currentLine.charAt((i + 1) * 4 - 3);
            if (Character.isLetter(currentChar)) stacks.get(i).addLast(currentChar);
        }
    }
}