package com.data_structure.graph;

import java.util.ArrayList;
import java.util.LinkedList;

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
     *
     * @param n 矩阵大小，二维数组
     */
    public Graph(int n) {
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    /**
     * 得到结点个数
     *
     * @return
     */
    public int getNumOfVertex() {
        return vertexList.size();
    }

    /**
     * 得到边的数目
     *
     * @return
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    public void showGraph() {
        for (int[] link : edges) {
            for (int i : link) {
                System.out.printf("%d,", i);
            }
            System.out.println();
        }
    }

    /**
     * 返回节点i对应的数据
     * 0→"A" 1→"B" 2→"C"
     *
     * @param i
     * @return
     */
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    /**
     * 返回v1 到 v2 的权值
     *
     * @param v1
     * @param v2
     * @return
     */
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }


    /**
     * 插入顶点
     *
     * @param vertex
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 插入时需要将双方都进行连接
     *
     * @param v1     表示点的下标即第几个顶点 如顶点A连接顶点B "A(0)"→"B(1)"  edges[0][1]
     * @param v2     第二个顶点对应的下标 顶点A连接顶点B，顶点B也需要连接顶点A "A(0)"←"B(1)"  edges[1][0]
     * @param weigth
     */
    public void insertEdge(int v1, int v2, int weigth) {
        edges[v1][v2] = weigth;
        edges[v2][v1] = weigth;
        numOfEdges++;
    }

    /**
     * 得到第一个邻接结点w
     *
     * @return 如果UC你在，就返回对应的下标，否则返回-1
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接结点的下标来获取去下一个邻接结点
     *
     * @param v1
     * @param v2
     * @return
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 深度优先遍历
     * i 第一次 就是0
     */
    private void dfs(boolean[] isVisited, int i) {
        //访问该节点，输出
        System.out.printf("%s->", getValueByIndex(i));
        //将结点设置为已访问
        isVisited[i] = true;

        //查找节点i的第一个邻接结点w
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            w = getNextNeighbor(i, w);
        }
    }

    /**
     * 对dfs进行重载，遍历所有的节点，进行dfs
     * 这里体现了回溯
     */
    public void dfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    /**
     * 广度优先遍历
     * 对一个节点进行广度优先遍历
     *
     * @param isVisited
     * @param i
     */
    public void bfs(boolean[] isVisited, int i) {
        int u; //表示队列的头结点对应下标
        int w; //邻接节点w

        LinkedList queue = new LinkedList();//队列，记录节点访问的顺序
        //访问节点
        System.out.printf("%s->", getValueByIndex(i));
        //标记已访问
        isVisited[i] = true;
        //将节点加入队列
        queue.addLast(i);

        while (!queue.isEmpty()) {
            //取出队列的头结点下标
            u = (Integer) queue.removeFirst();
            //得到第一个邻接点的下标
            w = getFirstNeighbor(u);

            while (w != -1) { // 找到
                //是否访问过
                if (!isVisited[w]) {
                    System.out.printf("%s->", getValueByIndex(w));
                    //标记已经访问
                    isVisited[w] = true;
                    //入队
                    queue.addLast(w);
                }
                //以u为前驱点，找w后面的下一个邻接点
                w = getNextNeighbor(u, w);//体现出广度
            }
        }
    }

    /**
     * 遍历所有的节点，都进行广度优先搜搜
     */
    public void bsf() {
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

}
