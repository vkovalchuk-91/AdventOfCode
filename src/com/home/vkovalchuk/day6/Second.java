package com.home.vkovalchuk.day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Second {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("6.txt"));
            int result = 0;
            while (true) {
                String currentLine = br.readLine();
                if (currentLine == null) break;

                char[] chars = currentLine.toCharArray();
                for (int i = 13; i < chars.length; i++) {
                    HashSet<Character> uniqueChars = new HashSet<>();
                    for (int j = 0; j < 14; j++) {
                        uniqueChars.add(chars[i - j]);
                    }
                    if (uniqueChars.size() == 14) {
                        result = i + 1;
                        break;
                    }
                }
            }
            br.close();
            System.out.println(result);
        } catch (IOException e) {
            System.out.println("Oooops, reading error (maybe file not found)!");
        }
    }
}