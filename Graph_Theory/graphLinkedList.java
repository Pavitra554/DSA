package DATA_STRUCTURE.Graph_Theory;

import java.util.*;

public class graphLinkedList {
    //Funtion for adding edges in Undirected graph
    static void AddEdge(LinkedList<LinkedList<Integer>> ll,int u,int v){
        ll.get(u).add(v);
        ll.get(v).add(u);
    }
    
    //Function for Printing graph
    static void printGraph(LinkedList<LinkedList<Integer>> gr){
        //for outer list
        for (int i = 0; i < gr.size(); i++) {
            System.out.print("\nAdjacency list for "+i+" ");
            //for printing inner list
            //adjacency vertices
            for (int j = 0;j < gr.get(i).size() ; j++) {
                System.out.print("--> "+gr.get(i).get(j));
            }
            System.out.println();
            
        }
    }
   
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of vertices : ");
        int vertex = s.nextInt();
        //Creating list of list for Adjacency List
        LinkedList< LinkedList<Integer>> graph = new LinkedList<LinkedList<Integer>>();

        for (int i = 0; i < vertex; i++) {
            //creating empty list under a specific index of outer list
            graph.add(new LinkedList<Integer>());
        }

        //user input number of edges
        System.out.println("Enter number of edges : ");
        int e = s.nextInt();
       
        //adding edges

        for (int i = 0; i < e; i++) {
            System.out.println("Enter source and destination : ");
            int u = s.nextInt();
            int v = s.nextInt();
            AddEdge(graph, u, v);
        }
        //Printing Graph

        printGraph(graph);

        s.close();
    }
}
