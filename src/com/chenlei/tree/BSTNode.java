package com.chenlei.tree;

/**
 * tool
 * @author chenlei
 * @since 2017 - 06 - 01 10:03
 */
class BSTNode {

    private BSTNode(int value) {
        this.value = value;
    }

    private void initLink(BSTNode leftChild, BSTNode rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    static BSTNode initTree() {
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

    int value;
    BSTNode leftChild;
    BSTNode rightChild;
    BSTNode pNext;
}
