package com.xdmeta;// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class NodePathPractical {
    public static void main(String[] args) {
        int[] output = solution(new int[] {2, 1, 1});
        System.out.println(Arrays.toString(output));
    }

    static HashMap<Integer, ArrayList<Integer>> map = new HashMap();
    static int[] pathsAr = new int[0];
    public static int[] solution(int[] T) {
        // write your code in Java SE 8
        int rootNode = -1;
        int[] pathsAr = new int[T.length];
        Arrays.fill(pathsAr, 0);

        for (int i = 0; i < T.length ; i ++) {
            if ( i == T[i]) {
                rootNode = i;
            }
        }
        for (int i = 0; i < T.length; i++) {
            if (map.get(T[i]) == null) {
                ArrayList<Integer> valueAr = new ArrayList();
                valueAr.add(i);
                map.put(T[i], valueAr);
            } else {
                ArrayList<Integer> values = map.get(T[i]);
                values.add(i);
                map.put(T[i], values);
            }
        }
        ArrayList<Integer> rootConnectedNodes = map.get(rootNode);
        int position = 0;

        ArrayList<Integer> foundPaths = new ArrayList();
        foundPaths.add(rootNode);
        for ( int i = 0; i < T.length ; i++ ) {
            if (foundPaths.contains(T[i])) {
                continue;
            }
            if (rootConnectedNodes.contains(T[i])) {
                pathsAr[position] = pathsAr[position] + 1;
                position ++;
            } else {
                findPath(rootConnectedNodes, T[i], position, pathsAr[position]++);
                position++;
            }
        }
        return pathsAr;
    }

    private static void findPath(ArrayList<Integer> rootConnectedNodes, int dest, int stepIndex, int steps) {
        if (rootConnectedNodes.contains(dest)) {
            pathsAr[stepIndex] = pathsAr[stepIndex] + steps;
        } else {
            for (Integer node : rootConnectedNodes) {
                if (map.containsKey(node)) {
                    ArrayList<Integer> connectedNodes = map.get(node);
                    findPath(connectedNodes, dest, stepIndex, steps++);
                }
            }
        }
    }
}