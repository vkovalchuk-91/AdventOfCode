package com.home.vkovalchuk.day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Day8 {
    public static void main(String[] args) {
        List<List<Tree>> trees = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("8.txt"));

            while (true) {
                String currentLine = br.readLine();
                if (currentLine == null) break;

                trees.add(currentLine.chars()
                        .map(Character::getNumericValue)
                        .boxed()
                        .map(Tree::new)
                        .toList());
            }
            br.close();

            int listWidth = trees.get(0).size();
            int listHeight = trees.size();

            for (int row = 0; row < listHeight; row++) {
                for (int col = 0; col < listWidth; col++) {
                    setNeighboringTrees(row, col, trees);
                }
            }

            System.out.println("Part 1 answer: " + trees.stream()
                    .flatMap(Collection::stream)
                    .filter(Tree::isVisibleTree)
                    .count());

            System.out.println("Part 2 answer: " + trees.stream()
                    .flatMap(Collection::stream)
                    .max(Comparator.comparing(Tree::getScenicScore)).orElseThrow().getScenicScore());
        } catch (IOException e) {
            System.out.println("Oooops, reading error (maybe file not found)!");
        }
    }

    static void setNeighboringTrees(int row, int col, List<List<Tree>> trees) {
        Tree currentTree = trees.get(row).get(col);
        currentTree.setLeftTree(getLeftTreeFromArrayList(row, col, trees));
        currentTree.setRightTree(getRightTreeFromArrayList(row, col, trees));
        currentTree.setTopTree(getTopTreeFromArrayList(row, col, trees));
        currentTree.setBottomTree(getBottomTreeFromArrayList(row, col, trees));
    }

    static Tree getLeftTreeFromArrayList(int row, int col, List<List<Tree>> trees) {
        if (col == 0) return null;
        return trees.get(row).get(col - 1);
    }

    static Tree getRightTreeFromArrayList(int row, int col, List<List<Tree>> trees) {
        if (col == trees.get(0).size() - 1) return null;
        return trees.get(row).get(col + 1);
    }

    static Tree getTopTreeFromArrayList(int row, int col, List<List<Tree>> trees) {
        if (row == 0) return null;
        return trees.get(row - 1).get(col);
    }

    static Tree getBottomTreeFromArrayList(int row, int col, List<List<Tree>> trees) {
        if (row == trees.size() - 1) return null;
        return trees.get(row + 1).get(col);
    }
}