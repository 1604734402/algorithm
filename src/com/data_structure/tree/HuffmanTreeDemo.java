package com.data_structure.tree;

/**
 * @auther liuyiming
 * @date 2021/1/15 10:43
 * @description 哈夫曼树
 */
public class HuffmanTreeDemo {

    public static void main(String[] args) {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};
        TreeNode huffmanTree = HuffmanTree.createHuffmanTree(arr);
        HuffmanTree.preOrder(huffmanTree);


    }


}
