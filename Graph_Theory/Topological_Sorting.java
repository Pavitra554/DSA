package DATA_STRUCTURE.Graph_Theory;

import java.util.*;
//Name - Pavitra Behara
//Regd.No - 2041002041
//Section - CSE-D
//Title of the program - Topological Ordering using DFS

public class Topological_Sorting {
    //Topological Sorting 
    //Time -> O(V+E)
    //Space -> O(V)


    //Global nested ArrayList (Adjecency List).

    static ArrayList< ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    //Stack for storing topological order.
    static Stack<Integer> stack = new Stack<>();

    //Funtion for adding edge for a directed graph hence there is only one edge from u to v.
    static void addEdge(int u,int v){
        graph.get(u).add(v);
    }

    //Funtion for printing adjecencey List.
    static void printGraph(){
        for (int i = 0; i < graph.size(); i++) {
            System.out.print("\nAdjacency list for "+i+" ");

            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print("-->"+graph.get(i).get(j));
            }
            System.out.println();
        }
    }

    //Function for topological sorting nothing but modified DFS.
    static void topologicalSort_Init(int i,boolean [] visited){
        //visiting nodes.
        visited[i] = true;

        //loop for each edge adjecent to i.
        for(int n:graph.get(i)){
            if(!visited[n]){
                topologicalSort_Init(n, visited);
            }
        }
        //pushing the vertex into the stack.
        stack.push(i);
    }

    //Function for calling topologicalSort_Init this will call the function for each and 
    //every vertex.
    static void topologicalSorting(){
        //visited array of size v, Where v is the number of vertices.
        boolean [] visited = new boolean[graph.size()];

        //Initially filling the array with false.
        Arrays.fill(visited, false);

        //loop for every vertex.
        for (int i = 0; i < graph.size(); ++i) {
            if(visited[i] == false){
                topologicalSort_Init(i,visited);
            }
        }
    }


    //Printing the topological sort order.
    //Basically we are printing stack.
    static void printTopologicalOrder(){
        System.out.println();
        while(stack.empty() == false){
            System.out.print(stack.pop()+" ");
        }
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //Taking the number of vertices and edges as user input.
        System.out.println("Enter the number of vertices : ");
        int vertex = s.nextInt();
        System.out.println("Enter the number of edges : ");
        int edge  = s.nextInt();

        //Creating empty list in each vertex
        for (int i = 0; i < vertex; i++) {
            graph.add(new ArrayList<Integer>());
        }

        //Taking the source and destination for every edge
        for (int i = 0; i < edge; i++) {
            System.out.println("Enter source and destination : ");
            int u = s.nextInt();
            int v = s.nextInt();
            addEdge(u, v);
        }
        //this function is for printing adjecencey list
        printGraph();

        //Calling topologicalSortint().
        topologicalSorting();

        //Printing Stack
        printTopologicalOrder();


        s.close();

    }
}
