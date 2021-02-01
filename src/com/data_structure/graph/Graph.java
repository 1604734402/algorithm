package com.data_structure.graph;

import java.util.ArrayList;

/**
 * @auther liuyiming
 * @date 2021/2/1 15:39
 * @description 图
 */
public class Graph {

    private ArrayList<String> vertexList; //存储顶点集合
    private int[][] edges; //存储对应的邻接矩阵
    private int numOfEdges; //表示多少条边
    private boolean[] isVisited;//记录某个节点是否被访问

    /**
     * 初始化矩阵
     * @param n 矩阵大小，二维数组
     */
    public Graph(int n){
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    /**
     * 得到结点个数
     * @return
     */
    public int getNumOfVertex(){
        return vertexList.size();
    }

    /**
     * 得到边的数目
     * @return
     */
    public int getNumOfEdges(){
        return numOfEdges;
    }
    
    public void showGraph(){
        for (int[] link : edges) {
            for (int i : link) {
                System.out.printf("%d,",i);
            }
            System.out.println();
        }
    }

    /**
     * 返回节点i对应的数据
     * 0→"A" 1→"B" 2→"C"
     * @param i
     * @return
     */
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    /**
     * 返回v1 到 v2 的权值
     * @param v1
     * @param v2
     * @return
     */
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }


    /**
     * 插入顶点
     * @param vertex
     */
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    /**
     *  插入时需要将双方都进行连接
     * @param v1 表示点的下标即第几个顶点 如顶点A连接顶点B "A(0)"→"B(1)"  edges[0][1]
     * @param v2 第二个顶点对应的下标 顶点A连接顶点B，顶点B也需要连接顶点A "A(0)"←"B(1)"  edges[1][0]
     * @param weigth
     */
    public void insertEdge(int v1,int v2, int weigth){
        edges[v1][v2] = weigth;
        edges[v2][v1] = weigth;
        numOfEdges++;
    }

    /**
     * 得到第一个邻接结点w
     * @return 如果UC你在，就返回对应的下标，否则返回-1
     */
    public int getFirstNeighbor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i]>0){
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接结点的下标来获取去下一个邻接结点
     * @param v1
     * @param v2
     * @return
     */
    public int getNextNeighbor(int v1,int v2){
        for (int i = v2+1; i < vertexList.size(); i++) {
            if (edges[v1][i]>0){
                return i;
            }
        }
        return -1;
    }

    /**
     * 深度优先遍历
     * i 第一次 就是0
     */
    private void dfs(boolean[] isVisited,int i){
        //访问该节点，输出
        System.out.printf("%s->",getValueByIndex(i));
        //将结点设置为已访问
        isVisited[i] = true;

        //查找节点i的第一个邻接结点w
        int w = getFirstNeighbor(i);
        while (w != -1){
            if (!isVisited[w]){
                dfs(isVisited, w);
            }
            w = getNextNeighbor(i,w);
        }
    }

    /**
     * 对dfs进行重载，遍历所有的节点，进行dfs
     */
    public void dfs(){
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

}
