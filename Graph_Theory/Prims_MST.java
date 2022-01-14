package DATA_STRUCTURE.Graph_Theory;

import java.util.*;

//Name - Pavitra Behara
//Regd.No - 2041002041
//Section - CSE-D
//Title of the program - Prims's Minimum Spanning Tree

public class Prims_MST {
    //Prim's Algorithm 
    //Time ->O(V^2)
    //space O( V + E )

    //Matrix representation of graph
    static int [][]graph;
    //Array for storing MST 
    static int [] parent;

    //Function for adding edges
    static void addEdge(int source,int destination,int weight){
        graph[source][destination] = weight;
        graph[destination][source] = weight;
    }

    //Function for finding minimum key 
    static int MinimumKey(int key[],boolean included[]){
    
        int min  = Integer.MAX_VALUE;
        int minINDEX = -1;
        for (int i = 0; i < graph.length; i++) {
            if(included[i] == false && key[i]<min){
                min = key[i];
                minINDEX = i;
            }
        }
        return minINDEX;
    }

    //Function for applying Prim's algorithm
    static void Prims(){
        //initilizing parent array
        parent  = new int[graph.length];

        //Array for storing keys
        int [] key = new int[graph.length];

        //Array for checking that edge is included in MST or not
        boolean [] included = new boolean[graph.length];

        //Initializing keys with infinite(max int value) and included with false
        for (int i = 0; i < graph.length; i++) {
            key[i] = Integer.MAX_VALUE;
            included[i] = false;
        }

        //for the first vertex key value is 0 and parent is -1
        key[0] = 0;
        parent[0] = -1;


        for (int i = 0; i < graph.length; i++) {
            //finding vertex with minimum key value
            int u = MinimumKey(key, included);

            //visiting the vertex
            included[u] = true;


            for (int j = 0; j < graph.length; j++) {
                if(graph[u][j] != 0 && included[j] ==false && graph[u][j]<key[j]){
                    
                    parent[j] = u;
                    key[j] = graph[u][j];
                }
            }
        }
        // System.out.println(Arrays.toString(key));
    }

    //Printing the minimum spanning tree
   static void printMST(){
       
        int totalWeigth = 0;
        System.out.println("Edge \tWeight");
        for (int i = 1; i < graph.length; i++){
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
            totalWeigth += graph[i][parent[i]];
        }
        //printing totale weight of minimum spanning tree 
        System.out.println("Total weight : "+totalWeigth);

        // System.out.println(Arrays.toString(parent));
    }

    //Printing matrix of graph
    static void PrintAdjecencyMatrix(){
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of vertices : ");
        int vertex = s.nextInt();
        System.out.println("Enter the number of edges : ");
        int edge = s.nextInt();

        //Creating v * v size of graph
        graph = new int[vertex][vertex];

        for (int i = 0; i < edge; i++) {
            System.out.println("Enter source, destination and weight : ");
            int src = s.nextInt();
            int des = s.nextInt();
            int wgt = s.nextInt();
            
            addEdge(src, des, wgt);
        }
        //Funtion for printing adjecency matrix
        PrintAdjecencyMatrix();
        //Function for prims algorithm
        Prims();
        //Printing minimum spanning tree
        printMST();

        s.close();

    }
}
