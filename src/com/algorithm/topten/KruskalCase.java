package com.algorithm.topten;

import sun.applet.Main;

/**
 * 克鲁斯卡尔算法案例
 */
public class KruskalCase {

    private int edgeNum;//边的个数
    private char[] vertexs; //顶点数组
    private int[][] matrix; //邻接矩阵

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //克鲁斯卡尔算法的邻接矩阵
        int matrix[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {0, 12, INF, INF, INF, 16, 14},
                /*B*/ {12, 0, 10, INF, INF, 7, INF},
                /*C*/ {INF, 10, 0, 3, 5, 6, INF},
                /*D*/ {INF, INF, 3, 0, 4, INF, INF},
                /*E*/ {INF, INF, 5, 4, 0, 2, 8},
                /*F*/ {16, 7, 6, INF, 2, 0, 9},
                /*G*/ {14, INF, INF, INF, 8, 9, 0}};

        KruskalCase kruskalCase = new KruskalCase(vertexes, matrix);
        kruskalCase.show();

    }

    public KruskalCase(char[] vertexs,int[][] matrix){
        //初始化顶点个数和边的个数
        int vlen = vertexs.length;

        //初始化顶点,赋值拷贝的方式
        this.vertexs = new char[vlen];
        for (int i = 0; i < vertexs.length; i++) {
            this.vertexs[i] = vertexs[i];
        }
        //如果这样做，会改变传入的数组
//        this.vertexs = vertexs;

        //初始化边,赋值拷贝的方式
        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
        //统计边
        for (int i = 0; i < vlen; i++) {
            for (int j = i; j < vlen; j++) {
                if (this.matrix[i][j] != INF){
                    edgeNum++;
                }
            }
        }

    }

    public void show(){
        for (int[] m:this.matrix) {
            for (int i: m) {
                System.out.printf("%-12d",i);
            }
            System.out.println();
        }
    }
}
