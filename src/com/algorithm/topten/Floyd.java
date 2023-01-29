package com.algorithm.topten;

import java.util.Arrays;

/**
 * 弗洛伊德算法
 */
public class Floyd {
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        final int N = 65535;//不可连接
        int[][] matrix = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/{0, 5, 7, N, N, N, 2},
                /*B*/{5, 0, N, 9, N, N, 3},
                /*C*/{7, N, 0, N, 8, N, N},
                /*D*/{N, 9, N, 0, N, 4, N},
                /*E*/{N, N, 8, N, 0, 5, 4},
                /*F*/{N, N, N, 4, 5, 0, 6},
                /*G*/{2, 3, N, N, 4, 6, 0}};
        FGraph fGraph = new FGraph(vertex.length, matrix, vertex);
        fGraph.show();
        fGraph.floyd();
        System.out.println("=================================");
        fGraph.show();
    }


}

class FGraph {
    private char[] vertex; //存放顶点的数组
    private int[][] dis; // 保存从各个顶点出发到其他顶点的距离
    private int[][] pre; //保存到达目的顶点的前驱顶点

    /**
     * @param length 大小
     * @param matrix 邻接矩阵
     * @param vertex 顶点数组
     */
    public FGraph(int length, int[][] matrix, char[] vertex) {
        this.vertex = vertex;
        this.dis = matrix;
        this.pre = new int[length][length];

        //对pre数组初始化,存放的是前驱顶点的下标
        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    /**
     * 显示pre数组和dis数组
     */
    public void show() {
        System.out.println("==========dis===========");
        System.out.println("==========pre===========");
        for (int i = 0; i < dis.length; i++) {
            for (int j = i; j < dis[i].length; j++) {
                System.out.printf("%-9s",vertex[pre[i][j]]);

            }
            System.out.println();

            for (int j = i; j < dis[i].length; j++) {
                System.out.printf("(%s=%d=%s)",vertex[i],dis[i][j],vertex[j]);
            }
            System.out.println();
            System.out.println();


        }

        for (int i = 0; i < pre.length; i++) {

        }
    }

    public void floyd(){
        int len = 0;//变量保存距离
        //对中间顶点进行遍历 i 是终点顶点下标 {'A', 'B', 'C', 'D', 'E', 'F', 'G'}
        for (int k = 0; k < dis.length; k++) {
            //从i顶点开始出发 {'A', 'B', 'C', 'D', 'E', 'F', 'G'}
            for (int i = 0; i < dis.length; i++) {
                //从j开始出发 {'A', 'B', 'C', 'D', 'E', 'F', 'G'}
                for (int j = 0; j < dis.length; j++) {
                    len = dis[i][k] + dis[k][j];//求出从i顶点出发,经过K中间顶点，到达j顶点距离
                    //如果len 小于dis[i][j]
                    if (len<dis[i][j]){
                        //更新最短距离
                        dis[i][j] = len;
                        //更新前驱节点
                        pre[i][j] = pre[k][j];
                    }
                }
            }
        }
    }
}
