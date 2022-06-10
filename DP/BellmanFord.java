package DATA_STRUCTURE.DP;

import java.util.Scanner;

public class BellmanFord {
    class Edge {
        int src;
        int des;
        int w;

        Edge() {
            src = des = w = 0;
        }
    }

    int v; // Vertex
    int e; // Edges
    Edge edge[];

    BellmanFord(int v, int e) {
        this.v = v;
        this.e = e;
        // Creating total edges in graph
        edge = new Edge[e];
        for (int i = 0; i < e; i++) {
            edge[i] = new Edge();
        }
    }

    void bellmanFord(BellmanFord graph, int src) {
        int V = graph.v;
        int E = graph.e;

        // Distance array which will store distance from source to each vertex
        int[] dist = new int[V];

        for (int i = 0; i < V; ++i) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = graph.edge[j].src;
                int v = graph.edge[j].des;
                int w = graph.edge[j].w;
                if (dist[u] != Integer.MAX_VALUE && (dist[u] + w) < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        // For negative cycle
        for (int i = 0; i < dist.length; ++i) {
            int u = graph.edge[i].src;
            int v = graph.edge[i].des;
            int w = graph.edge[i].w;
            if (dist[u] != Integer.MAX_VALUE && (dist[u] + w) < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }
        // Print each vertex distance from source
        printCost(dist, V);
    }

    static void printCost(int dist[], int n) {
        System.out.println("Vertex \t\t Distance from source");
        for (int i = 0; i < n; ++i) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter total no of vertex and edges");
        int vertex = s.nextInt();
        int edges = s.nextInt();
        BellmanFord graph = new BellmanFord(vertex, edges);

        for (int i = 0; i < edges; i++) {
            System.out.println("Enter source, destination and weight for " + i + " edge");
            int sc = s.nextInt();
            int de = s.nextInt();
            int we = s.nextInt();
            graph.edge[i].src = sc;
            graph.edge[i].des = de;
            graph.edge[i].w = we;
        }

        graph.bellmanFord(graph, 0);
        s.close();
    }
}
