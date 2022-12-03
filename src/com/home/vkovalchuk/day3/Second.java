package com.home.vkovalchuk.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Second {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("3.txt"));
            int result = 0;
            int count = 0;
            char[] firstLine = null, secondLine = null, thirdLine = null;

            while (true) {
                String currentLine = br.readLine();
                if (currentLine == null) break;

                if (count == 3) count = 0;
                count++;

                switch (count) {
                    case 1 -> firstLine = currentLine.toCharArray();
                    case 2 -> secondLine = currentLine.toCharArray();
                    case 3 -> thirdLine = currentLine.toCharArray();
                }

                if (count == 3) {
                    boolean isFound = false;
                    for (Character c1 : firstLine) {
                        for (Character c2 : secondLine) {
                            if (c1 == c2) {
                                for (Character c3 : thirdLine) {
                                    if (c2 == c3) {
                                        result += getPriority(c3);
                                        isFound = true;
                                    }
                                    if (isFound) break;
                                }
                            }
                            if (isFound) break;
                        }
                        if (isFound) break;
                    }
                }
            }
            br.close();
            System.out.println(result);
        } catch (IOException e) {
            System.out.println("Oooops, reading error (maybe file not found)!");
        }
    }

    private static int getPriority(Character c) {
        int cInt = (int) c;
        if (cInt > 96) cInt -= 96;
        else cInt -= 38;
        return cInt;
    }
}