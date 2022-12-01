package com.home.vkovalchuk.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class First {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        int result = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("1.txt"));
            while (true) {
                String currentLine = br.readLine();
                if (currentLine == null) break;
                if (currentLine.length() == 0) {
                    data.add(result);
                    result = 0;
                } else {
                    result += Integer.parseInt(currentLine);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Oooops, reading error (maybe file not found)!");
        }

        System.out.println(Collections.max(data));
    }
}