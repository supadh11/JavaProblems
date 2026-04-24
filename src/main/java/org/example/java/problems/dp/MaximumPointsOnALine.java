package org.example.java.problems.dp;

import java.util.HashMap;
import java.util.Map;
/*

149. Max Points on a Line
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane,
return the maximum number of points that lie on the same straight line.

Solution :

 */
public class MaximumPointsOnALine {

    public static void main(String args[]){


    }


    public int maxPoints(int[][] points) {

        if (points.length <= 2) return points.length;

        int max = 0;

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            int duplicates = 1; // count the point itself

            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                // Handle duplicate points
                if (dx == 0 && dy == 0) {
                    duplicates++;
                    continue;
                }

                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;

                String slope = dy + "/" + dx;
                map.put(slope, map.getOrDefault(slope, 0) + 1);
            }

            int currentMax = 0;
            for (int count : map.values()) {
                currentMax = Math.max(currentMax, count);
            }

            max = Math.max(max, currentMax + duplicates);
        }

        return max;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    }


