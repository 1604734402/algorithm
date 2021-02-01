package com.data_structure.graph;

/**
 * @auther liuyiming
 * @date 2021/2/1 16:16
 * @description
 */
public class GraphDemo {

    public static void main(String[] args) {
        //初始化矩阵大小
        int n = 5;
        Graph graph = new Graph(n);
        //初始化矩阵顶点
        String vertexValue[] = {"A","B","C","D","E"};
        for (String val : vertexValue) {
            graph.insertVertex(val);
        }
        //插入数据
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        //显示矩阵
        graph.showGraph();

        graph.dfs();
    }
}
