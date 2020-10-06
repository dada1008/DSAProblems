package com.opensource.dada.problems.pattern.topKElements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Problem:
 * Given an array of points in the a 2D2D plane, find ‘K’ closest points to the origin.
 *
 * Example 1:
 *
 * Input: points = [[1,2],[1,3]], K = 1
 * Output: [[1,2]]
 * Explanation: The Euclidean distance between (1, 2) and the origin is sqrt(5).
 * The Euclidean distance between (1, 3) and the origin is sqrt(10).
 * Since sqrt(5) < sqrt(10), therefore (1, 2) is closer to the origin.
 * Example 2:
 *
 * Input: point = [[1, 3], [3, 4], [2, -1]], K = 2
 * Output: [[1, 3], [2, -1]]
 */
public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        Point[] points = new Point[] { new Point(1, 2), new Point(1, 3)};
        List<Point> result = findClosestPoints(points, 1);
        System.out.print("Here are the k points closest the origin: ");
        for (Point p : result) {
            System.out.print("[" + p.x + " , " + p.y + "] ");
        }
        System.out.println();
    }

    public static void test2() {
        Point[] points = new Point[] { new Point(1, 3), new Point(3, 4)
                , new Point(2, -1)};
        List<Point> result = findClosestPoints(points, 2);
        System.out.print("Here are the k points closest the origin: ");
        for (Point p : result) {
            System.out.print("[" + p.x + " , " + p.y + "] ");
        }
    }

    public static List<Point> findClosestPoints(Point[] points, int k) {
        List<Point> result = new ArrayList<>();
        // create a min heap
        PriorityQueue<Point> heap
                = new PriorityQueue<>((p1, p2) -> p2.distFromOrigin() - p1.distFromOrigin());

        //maintain a heap of size k.
        for (Point entry : points) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }
        return result;
    }
}

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int distFromOrigin() {
        // ignoring sqrt
        return (x * x) + (y * y);
    }
}