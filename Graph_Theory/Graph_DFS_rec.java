package DATA_STRUCTURE.Graph_Theory;

import java.util.*;

//Name - Pavitra Behara
//Regd.No - 2041002041
//Section - CSE-D
//Title of the program - Depth First Search

public class Graph_DFS_rec {
    //Global nested ArrayList
    static ArrayList< ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

     //Funtion for adding edges in Undirected graph

    static void AddEdge(ArrayList<ArrayList<Integer>> ll,int u,int v){
        ll.get(u).add(v);
        ll.get(v).add(u);
    }

    //Function for Printing graph
    static void printGraph(ArrayList<ArrayList<Integer>> gr){
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
    //Function for Depth First Search using Recursion  
    static void DFS(int src,boolean [] vis){
        vis[src] = true;
        System.out.print(src+" --> ");
        for(int n:graph.get(src)){
            if(!vis[n]){
                 DFS(n,vis); //Recursive Call
            }
        }        
    }

    //DFS For Disconnected graph !!!

    static void DFS_Disconnected(boolean []vis){
        for (int i = 0; i < graph.size(); ++i){
            if (vis[i] == false)
                DFS(i, vis);
        }
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of vertices : ");
        int vertex = s.nextInt();
        //Creating list of list for Adjacency List
        // ArrayList< ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < vertex; i++) {
            //creating empty list under a specific index of outer list
            graph.add(new ArrayList<Integer>());
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

        System.out.println("Enter source for traversal : ");
        int source = s.nextInt();

        boolean []vis = new boolean[graph.size()];
        DFS(source, vis);
        // DFS_Disconnected(vis);
        
        s.close();
    }
}
