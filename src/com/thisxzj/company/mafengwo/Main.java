package com.thisxzj.company.mafengwo;

/**
 * date    2019-09-24
 * time    19:00
 *
 * @author thisxzj - 中建
 */


public class Main {
    public static void main(String[] args) {
        Node root = new Node(0);
        Node node = root;
        for (int i = 0; i < 9; i++) {
            node.left = new Node(i);
            node = node.left;
        }
//        node = root;
//        for (int i = 0; i < 13; i++) {
//            node.right = new Node(i);
//            node = node.right;
//        }
        System.out.println(depth(root));
        System.out.println(func(root));
    }

    public static int func(Node node) {
        if (node == null) {
            return 0;
        }
        int max = depth(node.right) + depth(node.left);
        int maxSon = Math.max(func(node.left), func(node.right));
        return Math.max(max, maxSon);
    }

    public static int depth(Node node) {
        if (node == null) {
            return 0;
        } else {
            return Math.max(depth(node.left), depth(node.right)) + 1;
        }
    }
}


class Node {
    Node left;
    Node right;
    int val;

    public Node(int val) {
        this.val = val;
    }
}