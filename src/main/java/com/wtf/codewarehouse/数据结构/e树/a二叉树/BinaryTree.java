package com.wtf.codewarehouse.数据结构.e树.a二叉树;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    TreeNode root;

    public void frontShow(){
        root.frontShow();
    }

    private void midShow() {
        root.midShow();
    }

    private void afterShow() {
        root.afterShow();
    }

    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        TreeNode root=new TreeNode(1);
        binaryTree.setRoot(root);

        TreeNode rootL=new TreeNode(2);
        TreeNode rootR=new TreeNode(3);
        root.setLeftNode(rootL);
        root.setRightNode(rootR);

        rootL.setLeftNode(new TreeNode(4));
        rootL.setRightNode(new TreeNode(5));

        rootR.setLeftNode(new TreeNode(6));
        rootR.setRightNode(new TreeNode(7));

        binaryTree.frontShow();
        System.out.println();
        binaryTree.midShow();
        System.out.println();
        binaryTree.afterShow();
        System.out.println();

        TreeNode result= binaryTree.frontSearch(3);
        System.out.println(result);
        System.out.println(result==rootR);


    }

    private TreeNode frontSearch(int i) {
        return root.frontSearch(i);
    }



    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
}
