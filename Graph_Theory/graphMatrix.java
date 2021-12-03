package DATA_STRUCTURE.Graph_Theory;

import java.util.Scanner;

class graph{
    //Creating Matrix v x v 
    int [][] adjacencyMatrix;
    int v;
    graph(int v){
        this.v = v;
        this.adjacencyMatrix = new int[v][v];
    }
    //Adding edge from u --> v and v --> u
    void addEdge(int source,int destination){
        this.adjacencyMatrix[source][destination] = 1;
        this.adjacencyMatrix[destination][source] = 1;
    }
    //Printing graph just printing the 2D Array
    void printGraph(){
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(adjacencyMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
public class graphMatrix {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the no of vertices : ");
        //number of vertices
        int v = s.nextInt();
        System.out.println("Enter the number edges : ");
        //number of edges
        int e = s.nextInt();
        graph g = new graph(v);

        for (int i = 0; i < e; i++) {
            System.out.println("Enter source and destination : ");
            int src = s.nextInt();
            int des = s.nextInt();
            g.addEdge(src, des);
        }
        System.out.println();
        System.out.println("Adjacency Matrix ");
        System.out.println();
        g.printGraph();

        s.close();
    }
}
