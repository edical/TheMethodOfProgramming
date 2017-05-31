package com.chenlei.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 *  2. 把二叉查找树转变成有序的双向链表
 * @author chenlei
 * @since 2017 - 05 - 31 11:38
 */
public class RevertBSTtoDouLink {

    //中序遍历添加到list
    private static void inOrder(BSTNode tree, List<BSTNode> list) {
        if(tree != null) {
            inOrder(tree.leftChild, list);
            list.add(tree);
            inOrder(tree.rightChild, list);
        }
    }

    public static void main(String[] args) {
        BSTNode bst = initTree();
        List<BSTNode> list = new ArrayList<>();
        inOrder(bst, list);
        for(int i = 0; i < list.size(); i++) {
            list.get(i).leftChild = (i == 0 ? null : list.get(i -1));
            list.get(i).rightChild = (i == list.size() - 1 ? null : list.get(i+1));
        }
        for(BSTNode node : list) {
            System.out.println(node.value);
        }
    }

    private static BSTNode initTree() {
        BSTNode node1 = new BSTNode(10);
        BSTNode node2 = new BSTNode(6);
        BSTNode node3 = new BSTNode(14);
        BSTNode node4 = new BSTNode(4);
        BSTNode node5 = new BSTNode(8);
        BSTNode node6 = new BSTNode(12);
        BSTNode node7 = new BSTNode(16);
        node1.initLink(node2, node3);
        node2.initLink(node4, node5);
        node3.initLink(node6, node7);
        node4.initLink(null, null);
        node5.initLink(null, null);
        node6.initLink(null, null);
        node7.initLink(null, null);
        return node1;
    }


    private static class BSTNode {
        BSTNode(int value) {
            this.value = value;
        }
        void initLink(BSTNode leftChild, BSTNode rightChild) {
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
        int value;
        BSTNode leftChild;
        BSTNode rightChild;
    }
}
