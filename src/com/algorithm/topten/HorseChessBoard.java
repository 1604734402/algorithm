package com.algorithm.topten;

import com.common.Util;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 马踏棋盘
 * 骑士周游
 */
public class HorseChessBoard {

    private static int X;//列
    private static int Y;//行
    //一维数组表示二维数组，(0,0)表示1 (1,0)表示8
    private static boolean visited[];//标记各个顶点有没有被访问过
    private static boolean finished; // 最终结果

    public static void main(String[] args) {
        X = 8;
        Y = 8;
        int row = 1;//初始位置 行
        int column = 1;// 列
        visited = new boolean[X * Y];
        int[][] chessboard = new int[X][Y];//初始值都是false
        System.out.println(Util.curTime());
        traversalChessboard(chessboard, row - 1, column - 1, 1);
        System.out.println(Util.curTime());

        for (int[] rows : chessboard) {
            for (int step : rows) {
                System.out.printf("%-2d ",step);
            }
            System.out.println();
        }
    }


    /**
     * 马踏棋盘
     *
     * @param chessboard 棋盘
     * @param row        当前位置的行 从0开始
     * @param column     当前位置的列 从0开始
     * @param step       第几步，初始从1
     */
    public static void traversalChessboard(int[][] chessboard, int row, int column, int step) {
        chessboard[row][column] = step;
        visited[row * X + column] = true;//把当前标记为已访问
        //获取当前位置可以走的下一个位置的集合
        ArrayList<Point> ps = next(new Point(column, row));
        sort(ps);
        //遍历
        while (ps != null && ps.size()>0) {
            Point p = ps.remove(0);//取出下一个可以走的位置
            //判断该点是否已经访问过
            if (!visited[p.y * X + p.x]) {//说明未访问
                traversalChessboard(chessboard, p.y, p.x, step + 1);
            }
        }
        //
        if (step < X * Y && !finished) {//未完成
            chessboard[row][column] = 0;
            visited[row * X + column] = false;
        } else {
            finished = true;
        }

    }

    /**
     * 根据当前位置计算当前还能走那些位置
     *
     * @param curPoint
     * @return
     */
    public static ArrayList<Point> next(Point curPoint) {

        ArrayList<Point> ps = new ArrayList<>();

        //创建一个Point
        Point p1 = new Point();

        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {//左上上
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {//左上下
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >=0) {//右上上
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {//右上下
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {//左下上
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {//左下下
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {//右下上
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {//右下下
            ps.add(new Point(p1));
        }

        return ps;
    }

    /**
     *
     * @param ps
     */
    public static void sort(ArrayList<Point> ps){
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                //获取o1下一步的所有位置个数
                int n1 = next(o1).size();
                int n2 = next(o2).size();

                return n1-n2;
            }
        });

    }
}
