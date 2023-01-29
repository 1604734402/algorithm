package com.algorithm.topten;

import com.common.Util;
import sun.applet.Main;

import javax.swing.event.MenuDragMouseListener;
import java.lang.reflect.Array;
import java.util.Arrays;

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
//        kruskalCase.show();
        ;
        EData[] edges = kruskalCase.getEdges();
        kruskalCase.sortEdgs(edges);
        System.out.println(Arrays.toString(edges));
        kruskalCase.kruskal();

    }

    public KruskalCase(char[] vertexs, int[][] matrix) {
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
            for (int j = i + 1; j < vlen; j++) {
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }

    }

    /**
     * 打印矩阵
     */
    public void show() {
        for (int[] m : this.matrix) {
            for (int i : m) {
                System.out.printf("%-12d", i);
            }
            System.out.println();
        }
    }

    /**
     * 对边进行排序
     *
     * @param eData
     */
    private void sortEdgs(EData[] eData) {
        EData temp = new EData();
        for (int i = eData.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (eData[i].weight < eData[j].weight) {
                    temp = eData[i];
                    eData[i] = eData[j];
                    eData[j] = temp;
                }
            }
        }
    }

    /**
     * 通过顶点的值，返回对应下标，如果没有，则返回-1
     *
     * @param ch
     * @return
     */
    private int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++) {
            if (this.vertexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取图中边,放到EData[] 数组中
     * 通过matrix邻接矩阵来获取
     *
     * @return
     */
    private EData[] getEdges() {
        int index = 0;
        EData[] eDatas = new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF) {
                    eDatas[index++] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
                }
            }
        }
        return eDatas;
    }

    /**
     * 获取下标为i的顶点的终点,用于后面判断两个顶点的终点是否相同
     *
     * @param ends 此数组就是记录了各个顶点的终点是哪个 ends 实在遍历过程中珠宝形成
     * @param i    表示顶点对应的下标
     * @return 返回的就是下标为i的这个顶点对应的终点的下标
     */
    private int getEnd(int[] ends, int i) {
        //如果未找到最终点，则自己就是最终点
        while (ends[i] != 0) {
            i = ends[i];
        }

        return i;
    }

    public void kruskal() {
        int index = 0;//表示最后结果数组索引
        int[] ends = new int[edgeNum];//用于保存 已有最小生成树 中的每个顶点在最小生成树中的终点
        //创建结果数组,保存最后的最小生成树
        EData[] rets = new EData[edgeNum];

        //获取途中所有的边的集合
        EData[] edges = getEdges();

        //按照边的权值大小进行排序(从小到大)
        sortEdgs(edges);

        //遍历Edes数组 将边添加到最小生成树中，判断是否形成回路,如果没有，就加入rets，否则就不能加入
        for (int i = 0; i < edgeNum; i++) {
            //获取到第i条边的顶点
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);

            //获取p1这个顶点在已有最小生成树的终点
            int m = getEnd(ends,p1);
            //获取p2这顶点在已有最小生成树中的终点
            int n = getEnd(ends,p2);
            if (m!=n){ //如果不相同，则不构成回路
                ends[m] = n;//设置m在 已有最小生成树 中的终点
                rets[index++] = edges[i]; //有一条边加入到rets数组
            }
        }

        //统计并打印最小生成树 输入rets数组

        for (int i = 0;i<index;i++) {
            System.out.println(rets[i].toString());
        }


    }

}

//这个类表示一条边
class EData {
    char start;//起点
    char end;//边的终点
    int weight; //边的权值

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public EData() {
    }

    @Override
    public String toString() {
        return "<" + start + "=" + weight + "=" + end + ">";
    }
}
