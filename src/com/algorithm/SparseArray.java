package com.algorithm;

/**
 * 稀疏数组
 * <p>
 * 在二维数组中，很多数据为0，记录了很多没有意义的数据，
 * 所以可以用稀疏数组来保存该数组
 * 思路：
 * 1、记录一共有几行几列，有多少个不同的值
 * 2、把具有不同值的元素的行列及值记录在一个小规模数组中
 * <p>
 * 二维数组->稀疏数组
 * 1、遍历原始二维数组，得到有效
 * 2、根据sum就可以创建稀疏数组
 * 3、将二维数组的有效数据存入到稀疏数组
 * <p>
 * 稀疏数组->二维数组
 * 1、先读取稀疏数组的第一行，根据第一行的数据，创建原始数组
 * 2、再读取稀疏数组后几行的数据，并赋值给原始的二维数组即可
 */
public class SparseArray {


    public static void main(String[] args) {
        // 创建一个原始的二维数组
        int[][] chaessArr1 = new int[11][11];
        // 初始化数据
        chaessArr1[1][2] = 1;
        chaessArr1[2][3] = 2;
        chaessArr1[4][5] = 2;

        printArray(chaessArr1, "二维数组");

        int[][] sparseArray = chaessArrayToSparseArray(chaessArr1);

        printArray(sparseArray, "稀疏数组");

        int[][] chaessArr2 = sparseArrayToChaessArray(sparseArray);

        printArray(chaessArr2, "还原数组");

    }


    /**
     * 二维数组转稀疏数组
     *
     * @param chaessArray
     * @return
     */
    private static int[][] chaessArrayToSparseArray(int[][] chaessArray) {

        //1、获取一共有多少个有效数据，进而来创建稀疏数组
        int sum = 0;
        for (int i = 0; i < chaessArray.length; i++) {
            for (int j = 0; j < chaessArray[i].length; j++) {
                if (chaessArray[i][j] != 0) {
                    sum++;
                }
            }
        }

        //2、创建稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = chaessArray.length;
        sparseArray[0][1] = chaessArray.length;
        sparseArray[0][2] = sum;

        //3、遍历二维数组来给稀疏数组赋值
        int count = 0;
        for (int i = 0; i < chaessArray.length; i++) {
            for (int j = 0; j < chaessArray[i].length; j++) {
                if (chaessArray[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chaessArray[i][j];
                }
            }
        }

        //返回
        return sparseArray;
    }


    /**
     * 根据稀疏数组还原二维数组
     *
     * @param sparseArray
     * @return
     */
    private static int[][] sparseArrayToChaessArray(int[][] sparseArray) {

        //1、根据稀疏数组[0]创建二维数组
        int[][] chaessArray = new int[sparseArray[0][0]][sparseArray[0][1]];

        //2、根据稀疏数组数据给二维数组赋值
        for (int i = 1; i <= sparseArray[0][2]; i++) {
            chaessArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        //返回
        return chaessArray;

    }

    /**
     * 遍历数组
     *
     * @param array
     */
    private static void printArray(int[][] array, String remark) {
        System.out.println("===================" + remark + "===================");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("=============================================");
    }
}
