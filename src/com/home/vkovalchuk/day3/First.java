package com.home.vkovalchuk.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class First {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("3.txt"));
            int result = 0;
            while (true) {
                String currentLine = br.readLine();
                if (currentLine == null) break;
                char[] firstHalf = currentLine.substring(0, currentLine.length() / 2).toCharArray();
                char[] secondHalf = currentLine.substring(currentLine.length() / 2).toCharArray();
                boolean isFound = false;
                for (Character c1 : firstHalf) {
                    for (Character c2 : secondHalf) {
                        if (c1 == c2) {
                            result += getPriority(c1);
                            isFound = true;
                        }
                        if (isFound) break;
                    }
                    if (isFound) break;
                }

            }
            br.close();
            System.out.println(result);
        } catch (IOException e) {
            System.out.println("Oooops, reading error (maybe file not found)!");
        }
    }

    private static int getPriority(Character c) {
        int cInt = (int)c;
        if (cInt > 96) cInt -= 96;
        else cInt -= 38;
        return cInt;
    }
}