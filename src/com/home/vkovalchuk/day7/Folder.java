package com.home.vkovalchuk.day7;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    String folderName;
    Folder parentFolder;
    List<Long> files = new ArrayList<>();
    List<Folder> innerFolders = new ArrayList<>();

    public Folder(String folderName, Folder parentFolder) {
        this.folderName = folderName;
        this.parentFolder = parentFolder;
    }

    public long getFolderSize() {
        long filesSize = files.stream()
                .reduce((Long::sum)).orElse(0L);
        long foldersSize = innerFolders.stream()
                .map(Folder::getFolderSize)
                .reduce((Long::sum)).orElse(0L);
        return filesSize + foldersSize;
    }


    public Folder getFolder(String name) {
        return innerFolders.stream()
                .filter(folder -> folder.folderName.equals(name))
                .findFirst().orElseThrow();
    }
}
