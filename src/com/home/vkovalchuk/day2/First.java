package com.home.vkovalchuk.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class First {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("2.txt"));
            int result = 0;
            while (true) {
                String currentLine = br.readLine();
                if (currentLine == null) break;

                switch (currentLine) {
                    case ("A X") -> result += 4;
                    case ("A Y") -> result += 8;
                    case ("A Z") -> result += 3;
                    case ("B X") -> result += 1;
                    case ("B Y") -> result += 5;
                    case ("B Z") -> result += 9;
                    case ("C X") -> result += 7;
                    case ("C Y") -> result += 2;
                    case ("C Z") -> result += 6;
                }
            }
            br.close();
            System.out.println(result);
        } catch (IOException e) {
            System.out.println("Oooops, reading error (maybe file not found)!");
        }
    }
}