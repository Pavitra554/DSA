package DATA_STRUCTURE.Graph_Theory;

import java.util.*;

class gr{
    int [][]am;
    int v;
    gr(int x){
        this.v = x;
        this.am = new int[v][v];
    }
    void addEdge(int u,int v,int w){
        this.am[u][v] = w;
        this.am[v][u] = w;
    }
    void printGraph(){
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(am[i][j]+" ");
            }
            System.out.println();
        }
    }
}



public class unionFindGraph {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the no of vertices : ");
        //number of vertices
        int v = s.nextInt();
        System.out.println("Enter the number edges : ");
        //number of edges
        int e = s.nextInt();
        gr g = new gr(v);

        for (int i = 0; i < e; i++) {
            System.out.println("Enter source and destination and weight: ");
            int src = s.nextInt();
            int des = s.nextInt();
            int w = s.nextInt();
            g.addEdge(src, des,w);
        }
        System.out.println();
        System.out.println("Adjacency Matrix ");
        System.out.println();
        g.printGraph();

        s.close();
    }
}
