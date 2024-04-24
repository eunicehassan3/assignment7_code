import java.util.*;
public class everyPath {
    private static List<List<Integer>> findAllPaths(int[][] graph, int u, int w, int length, List<Integer> path) {
        List<List<Integer>> paths = new ArrayList<>();
        if (length == 0) {
            if (u == w) {
                paths.add(new ArrayList<>(path));
            }
            return paths;
        }
        for (int i = 0; i < graph.length; i++) {
            if (graph[u][i] != 0 && !path.contains(i)) {
                path.add(i);
                paths.addAll(findAllPaths(graph, i, w, length - 1, path));
                path.remove(path.size() - 1);
            }
        }
        return paths;
    }
    public static void main(String[] args) {
        // test graph
        int[][] graph = new int[][] {
                {0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}
        };
        int n = graph.length;

        int u = 0; // start vertex
        int w = 3; // end vertex

        List<Integer> path = new ArrayList<>();
        path.add(u);

        findAllPaths(graph, u, w, 5, path);
        //System.out.println(findAllPaths(graph, u, w, 5, path));
//        System.out.println("hello world");

        if (path.isEmpty()) {
            System.out.println("No simple paths found from " + u + " to " + w + " with length 5.");
        }
        System.out.println(path);
    }

}

