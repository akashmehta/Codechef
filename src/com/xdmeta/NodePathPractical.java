package com.xdmeta;// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class NodePathPractical {
    public static void main(String[] args) {
        int[] output = solution(new int[] {9,1,4,9,0,4,8,9,0,1});
        System.out.println(Arrays.toString(output));
    }

    static HashMap<Integer, ArrayList<Integer>> map = new HashMap();
    static int rootNode = -1;
    static int[] pathsAr = new int[0];
    public static int[] solution(int[] T) {
        // write your code in Java SE 8
        pathsAr = new int[T.length];
        Arrays.fill(pathsAr, 0);

        for (int i = 0; i < T.length ; i ++) {
            if ( i == T[i]) { rootNode = i; }
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
                foundPaths.add(T[i]);
                position ++;
            } else {
                findPath(rootConnectedNodes, T[i], position, ++pathsAr[position]);
                foundPaths.add(T[i]);
                position++;
            }
        }
        return pathsAr;
    }

    private static boolean findPath(ArrayList<Integer> rootConnectedNodes, int dest, int stepIndex, int steps) {
        if (rootConnectedNodes.contains(dest)) {
            pathsAr[stepIndex] = steps;
            return true;
        } else {
            for (Integer node : rootConnectedNodes) {
                if (map.containsKey(node) && node != rootNode) {
                    ArrayList<Integer> connectedNodes = map.get(node);
                    if (findPath(connectedNodes, dest, stepIndex, ++steps)) break;
                }
            }
        }
        return false;
    }
}