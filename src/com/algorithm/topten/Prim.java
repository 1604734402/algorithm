package com.algorithm.topten;

import com.common.Util;

/**
 * 普里姆算法
 */
public class Prim {

    public static void main(String[] args) {

        //创建图
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        int[][] weight = {  // 邻接矩阵，约定 10000 代表不连通
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/{10000, 5, 7, 10000, 10000, 10000, 2},
                /*B*/{5, 10000, 10000, 9, 10000, 10000, 3},
                /*C*/{7, 10000, 10000, 10000, 8, 10000, 10000},
                /*D*/{10000, 9, 10000, 10000, 10000, 4, 10000},
                /*E*/{10000, 10000, 8, 10000, 10000, 5, 4},
                /*F*/{10000, 10000, 10000, 4, 5, 10000, 6},
                /*G*/{2, 3, 10000, 10000, 4, 6, 10000}
        };

        //初始化图
        MGraph mGraph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(mGraph,verxs,data,weight);

        minTree.prim(mGraph,1);
        minTree.showGraph(mGraph);

        
        
    }
}

/**
 * 创建最小生成树
 */
class MinTree {

    /**
     * 初始化图
     * 创建图的邻接矩阵
     * @param graph  图对象
     * @param verxs  图对应的顶点个数
     * @param data   图的各个顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createGraph(MGraph graph, int verxs, char data[], int[][] weight) {
        int i, j;
        //初始化图
        for (i = 0; i < verxs; i++) {
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }

    }

    /**
     * 遍历图
     * @param graph
     */
    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            Util.printArray(link);
        }
    }

    /**
     * prim算法，得到最小生成树
     * @param graph 图
     * @param v 表示从图的第几个顶点开始生成
     */
    public void prim(MGraph graph,int v){
        //标记节点是否被访问过
        int[] visited = new int[graph.verxs];
        //默认元素都是0,否则需要初始化
        for (int i = 0; i < visited.length; i++) {
            visited[i] = 0;
        }
        //1为已访问过
        visited[v] = 1;
        //h1 和 h2 记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;//将miWeight 初始成一个大数,后面遍历过程中，会替换  初始变量记录最小权值
        for (int k = 0; k < graph.verxs-1; k++) {//因为有graph.verxs顶点,普利姆算法结束后,有 graph.verxs-1条边
            //每一次生成的子图,和那个节点的距离最近
            for (int i = 0; i < graph.verxs; i++) {
                for (int j = 0; j < graph.verxs; j++) {
                    //寻找已经访问过,且相邻未访问,且权值最小
                    if (visited[i] == 1
                            && visited[j] == 0
                            && graph.weight[i][j]<minWeight){
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //找到最小的哪条边
            System.out.println("边<"+graph.data[h1]+","+graph.data[h2]+">权值:"+minWeight);
            //将节点标记为已访问
            visited[h2]=1;
            //重新初始化，找下条边
            minWeight = 10000;
        }
    }
}

class MGraph {
    int verxs;//表示图的节点个数
    char[] data; //存放节点的数据
    int[][] weight; //存放边,邻接矩阵

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }

}
