package com.home.vkovalchuk.day8;

public class Tree {
    int height;
    Tree leftTree;
    Tree rightTree;
    Tree topTree;
    Tree bottomTree;


    public Tree(int height) {
        this.height = height;
    }

    public void setLeftTree(Tree leftTree) {
        this.leftTree = leftTree;
    }

    public void setRightTree(Tree rightTree) {
        this.rightTree = rightTree;
    }

    public void setTopTree(Tree topTree) {
        this.topTree = topTree;
    }

    public void setBottomTree(Tree bottomTree) {
        this.bottomTree = bottomTree;
    }

    public int getScenicScore() {
        return getLeftScenicScore() * getRightScenicScore() * getTopScenicScore() * getBottomScenicScore();
    }

    private int getBottomScenicScore() {
        Tree bottomTree = this.bottomTree;
        int counter = 0;
        if (bottomTree == null) return 0;
        while (bottomTree != null) {
            counter++;
            if (bottomTree.height >= this.height) break;
            bottomTree = bottomTree.bottomTree;
        }
        return counter;
    }

    private int getTopScenicScore() {
        Tree topTree = this.topTree;
        int counter = 0;
        if (topTree == null) return 0;
        while (topTree != null) {
            counter++;
            if (topTree.height >= this.height) break;
            topTree = topTree.topTree;
        }
        return counter;
    }

    private int getRightScenicScore() {
        Tree rightTree = this.rightTree;
        int counter = 0;
        if (rightTree == null) return 0;
        while (rightTree != null) {
            counter++;
            if (rightTree.height >= this.height) break;
            rightTree = rightTree.rightTree;
        }
        return counter;
    }

    private int getLeftScenicScore() {
        Tree leftTree = this.leftTree;
        int counter = 0;
        if (leftTree == null) return 0;
        while (leftTree != null) {
            counter++;
            if (leftTree.height >= this.height) break;
            leftTree = leftTree.leftTree;
        }
        return counter;
    }

    public boolean isVisibleTree() {
        return checkLeftTreeVisibility() || checkRightTreeVisibility()
                || checkTopTreeVisibility() || checkBottomTreeVisibility();
    }

    private boolean checkLeftTreeVisibility() {
        Tree leftTree = this.leftTree;
        while (leftTree != null) {
            if (leftTree.height >= this.height) return false;
            leftTree = leftTree.leftTree;
        }
        return true; // if visible
    }

    private boolean checkRightTreeVisibility() {
        Tree rightTree = this.rightTree;
        while (rightTree != null) {
            if (rightTree.height >= this.height) return false;
            rightTree = rightTree.rightTree;
        }
        return true; // if visible
    }

    private boolean checkTopTreeVisibility() {
        Tree topTree = this.topTree;
        while (topTree != null) {
            if (topTree.height >= this.height) return false;
            topTree = topTree.topTree;
        }
        return true; // if visible
    }

    private boolean checkBottomTreeVisibility() {
        Tree bottomTree = this.bottomTree;
        while (bottomTree != null) {
            if (bottomTree.height >= this.height) return false;
            bottomTree = bottomTree.bottomTree;
        }
        return true; // if visible
    }
}
