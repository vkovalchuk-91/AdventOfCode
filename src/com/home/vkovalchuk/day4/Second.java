package com.home.vkovalchuk.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Second {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("4.txt"));
            int result = 0;
            while (true) {
                String currentLine = br.readLine();
                if (currentLine == null) break;
                String[] sections = currentLine.split(",");
                int startNumber1 = Integer.parseInt(sections[0].split("-")[0]);
                int endNumber1 = Integer.parseInt(sections[0].split("-")[1]);
                int startNumber2 = Integer.parseInt(sections[1].split("-")[0]);
                int endNumber2 = Integer.parseInt(sections[1].split("-")[1]);

                if ((startNumber2 <= endNumber1 && endNumber2 >= startNumber1)
                ) result++;
            }
            br.close();
            System.out.println(result);
        } catch (IOException e) {
            System.out.println("Oooops, reading error (maybe file not found)!");
        }
    }
}