package com.algorithm.topten;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 迪特斯杰拉算法
 */
public class Dijkstra {

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

        Graph graph = new Graph(vertex, matrix);
//        graph.showGraph();
        graph.dsj(0);
        graph.show();
    }
}

class Graph {

    private char[] vertex;//顶点数组
    private int[][] matrix;//邻接矩阵
    private VisitedVertex vv;//已经访问顶点的集合

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    public void showGraph() {
        for (int[] link : matrix) {
            for (int i : link) {
                System.out.printf("%-7d", i);
            }
            System.out.println();
        }
    }

    /**
     * @param index 出发顶点对应的下标
     */
    public void dsj(int index) {
        vv = new VisitedVertex(vertex.length, index);
        update(index);//更新index顶点到周围顶点的距离和前驱

        for (int i = 1; i < vertex.length; i++) {
            index = vv.updateArr();//选择并返回新的访问顶点
            update(index);//更新index顶点到周围顶点的距离和前驱
        }
//        vv.show();
    }

    /**
     * 更新index下标顶点到周围顶点的距离和周围顶点的前驱顶点
     * <p>
     * 从哪个顶点出发，就遍历那个顶点相连接的顶点
     *
     * @param index
     */
    private void update(int index) {

        int len = 0;
        //根据遍历邻接矩阵
        for (int i = 0; i < matrix[index].length; i++) {
            //len 出发顶点到index顶点的距离 + 从index顶点到i顶点的距离的和
            len = vv.getDis(index) + matrix[index][i];
            //如果i顶点没有被访问过,并且len小于出发顶点到i顶点的距离，就需要更新
            if (!vv.in(i) && len < vv.getDis(i)) {
                //如果说有其他方案 比直达更小,那么就需要更新距离，也更新前驱
                vv.updatePre(i, index); //更新i顶点的前驱为index顶点
                vv.updateDis(i, len); //更新出发顶点到i的顶点距离
            }
        }
    }

    public void show(){
        vv.show(vertex);
    }

}

class VisitedVertex { //已访问顶点集合
    public int[] already_arr; //记录各个顶点是否访问过 1访问 0未访问,动态更新
    public int[] pre_visited;//每个下标对应的值为前一个顶点下标, 动态更新
    public int[] dis; //记录出发顶点到其他所有顶点的距离,最短的距离就会存放到dis

    /**
     * @param length 顶点个数
     * @param index  出发顶点对应的下标
     */
    public VisitedVertex(int length, int index) {
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];
        //设置出发顶点被访问过
        this.already_arr[index] = 1;
        //初始化dis数组
        Arrays.fill(dis, 65535);
        this.dis[index] = 0;//设置出发顶点的访问距离为0
    }

    /**
     * 判断Index是否被访问过
     *
     * @param index
     * @return
     */
    public boolean in(int index) {
        return already_arr[index] == 1;
    }

    /**
     * 更新出发顶点到index顶点的距离
     *
     * @param index
     * @param len
     */
    public void updateDis(int index, int len) {
        dis[index] = len;
    }

    /**
     * 更新pre顶点的前驱顶点为index顶点
     *
     * @param pre
     * @param index
     */
    public void updatePre(int pre, int index) {
        pre_visited[pre] = index;
    }

    /**
     * 返回出发顶点到index顶点的距离
     *
     * @param index
     */
    public int getDis(int index) {
        return dis[index];
    }

    /**
     * 继续选择并返回新的访问顶点 (并不是出发顶点)
     *
     * @return
     */
    public int updateArr() {
        int min = 65535, index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis[i] < min) {
                min = dis[i];
                index = i;
            }
        }
        already_arr[index] = 1;
        return index;
    }


    public void show(char[] v){
        System.out.println("===========already_arr===========");
        System.out.println(Arrays.toString(already_arr));
        System.out.println("===========pre_visited===========");
        System.out.println(Arrays.toString(pre_visited));
        System.out.println("===========dis===========");

        for (int i = 0; i < dis.length; i++) {
            System.out.printf("%c[%s]  ",v[i],dis[i] == 65535?"N":dis[i]+"");
        }
    }
}