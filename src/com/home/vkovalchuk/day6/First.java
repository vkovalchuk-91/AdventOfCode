package com.home.vkovalchuk.day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class First {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("6.txt"));
            int result = 0;
            while (true) {
                String currentLine = br.readLine();
                if (currentLine == null) break;

                char[] chars = currentLine.toCharArray();
                for (int i = 3; i < chars.length; i++) {
                    if (!(chars[i - 3] == chars[i - 2] || chars[i - 3] == chars[i - 1] || chars[i - 3] == chars[i]
                            || chars[i - 2] == chars[i - 1] || chars[i - 2] == chars[i]
                            || chars[i - 1] == chars[i])
                    ) {
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