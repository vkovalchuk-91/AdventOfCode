package com.home.vkovalchuk.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Second {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("2.txt"));
            int result = 0;
            while (true) {
                String currentLine = br.readLine();
                if (currentLine == null) break;
                switch (currentLine) {
                    case ("A X") -> result += 3;
                    case ("A Y") -> result += 4;
                    case ("A Z") -> result += 8;
                    case ("B X") -> result += 1;
                    case ("B Y") -> result += 5;
                    case ("B Z") -> result += 9;
                    case ("C X") -> result += 2;
                    case ("C Y") -> result += 6;
                    case ("C Z") -> result += 7;
                }

            }
            br.close();
            System.out.println(result);
        } catch (IOException e) {
            System.out.println("Oooops, reading error (maybe file not found)!");
        }
    }
}