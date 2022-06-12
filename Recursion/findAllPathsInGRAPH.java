package DATA_STRUCTURE.Recursion;

import java.util.*;

class Graph {
    ArrayList<Integer>[] gr;
    int v;

    Graph(int v) {
        this.v = v;
        gr = new ArrayList[this.v];
        for (int i = 0; i < v; i++) {
            gr[i] = new ArrayList<>();
        }
    }

    void addEdge(int src, int des) {
        gr[src].add(des);
    }

    void printGraph() {
        for (int i = 0; i < gr.length; i++) {
            System.out.print(i + " --> ");
            for (int j = 0; j < gr[i].size(); j++) {
                System.out.print(gr[i].get(j) + " ");
            }
            System.out.println();
        }
    }

    void printAllPath(int src, int des) {
        boolean[] visited = new boolean[this.v];
        ArrayList<Integer> path = new ArrayList<>();

        path.add(src);
        dfs(src, des, visited, path);
    }

    void dfs(Integer src, Integer des, boolean[] visited, ArrayList<Integer> path) {
        visited[src] = true;
        if (src.equals(des)) {
            System.out.println(path);
            visited[src] = false;
            return;
        }

        for (Integer i : gr[src]) {
            if (!visited[i]) {
                path.add(i);
                dfs(i, des, visited, path);
                path.remove(i);
            }
        }
        visited[src] = false;

    }
}

public class findAllPathsInGRAPH {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter no. of vertices : ");
        int v = s.nextInt();

        Graph g = new Graph(v);

        System.out.println("Enter no. of edges : ");
        int e = s.nextInt();

        for (int i = 0; i < e; i++) {
            System.out.println("Enter source and destination..");
            int src = s.nextInt();
            int des = s.nextInt();
            g.addEdge(src, des);
        }
        System.out.println("Enter source and destination for printing all paths..");
        int src = s.nextInt();
        int des = s.nextInt();
        System.out.println("All possible paths..");
        g.printAllPath(src, des);
        // g.printGraph();
        s.close();

    }
}
