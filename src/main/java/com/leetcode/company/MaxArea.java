package com.leetcode.company;

import java.awt.*;


/**
 * @author yun zhi fei
 * @create 2019-12-29 1:55 下午
 **/
public class MaxArea {

    public static void main(String[] args) {

    }

    public int maxAreaOfIsland(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        Point[] points = new Point[]{new Point(0, 1), new Point(1, 0), new Point(-1, 0), new Point(0, -1)};
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                result = Math.max(dfs(grid, i, j, points), result);
            }
        }
        return result;
    }

    public int dfs(int[][] grid, int x, int y, Point[] point2DList) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) {
            return 0;
        }
        int area = 1;
        grid[x][y] = 0;
        for (Point point : point2DList) {
            area += dfs(grid, x + point.x, y + point.y, point2DList);
        }
        return area;
    }
}
