package com.home.vkovalchuk.day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class First {
    static List<Folder> allFolders = new ArrayList<>();
    static Folder currentFolder;

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("7.txt"));
            long result;
            while (true) {
                String currentLine = br.readLine();
                if (currentLine == null) break;

                if (currentLine.startsWith("$ cd")) {
                    if (currentLine.startsWith("$ cd /")) {
                        currentFolder = new Folder("/", null);
                        allFolders.add(currentFolder);
                    }
                    if (currentLine.startsWith("$ cd ")
                            && !currentLine.equals("$ cd /")
                            && !currentLine.equals("$ cd ..")
                    ) {
                        currentFolder = currentFolder.getFolder(currentLine.split(" ")[2]);
                    }
                    if (currentLine.equals("$ cd ..")) {
                        currentFolder = currentFolder.parentFolder;
                    }
                } else {
                    if (currentLine.startsWith("dir ")) {
                        Folder newFolder = new Folder(currentLine.substring(4), currentFolder);
                        allFolders.add(newFolder);
                        currentFolder.innerFolders.add(newFolder);
                    } else if (!currentLine.equals("$ ls")) {
                        currentFolder.files.add(Long.parseLong(currentLine.split(" ")[0]));
                    }
                }
            }
            br.close();
            result = allFolders.stream()
                    .map(Folder::getFolderSize)
                    .filter(folderSize -> folderSize <= 100000)
                    .reduce(Long::sum).orElse(0L);
            System.out.println(result);
        } catch (IOException e) {
            System.out.println("Oooops, reading error (maybe file not found)!");
        }
    }
}