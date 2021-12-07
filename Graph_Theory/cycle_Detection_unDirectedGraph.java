package DATA_STRUCTURE.Graph_Theory;

import java.util.*;
//Problem check this again

public class cycle_Detection_unDirectedGraph {
    
    static void AddEdge(ArrayList<ArrayList<Integer>> ll,int u,int v){
        ll.get(u).add(v);
        ll.get(v).add(u);
    }

    static void PrintGraph(ArrayList<ArrayList<Integer>> ll){
        //for outer list
        for (int i = 0; i < ll.size(); i++) {
            System.out.print("\nAdjacency list for "+i+" ");
            //for printing inner list
            //adjacency vertices
            for (int j = 0;j < ll.get(i).size() ; j++) {
                System.out.print("--> "+ll.get(i).get(j));
            }
            System.out.println();
            
        }
    }
    //function for finding a cycle in given graph
    static boolean isCycleConnected(ArrayList<ArrayList<Integer>> ll,int src,int vertex,boolean[]vis){
        int parent []= new int[vertex];
        Arrays.fill(parent, -1);
        //felling parent with -1 initialy

        //same BFS approach
        Queue<Integer> q  = new LinkedList<>();
        q.add(src);
        vis[src] =true;

        while(!q.isEmpty()){
            int curr = q.poll();

            for (int element : ll.get(curr)) {
                int v = element;
                if(!vis[v]){
                    vis[v] = true;
                    q.add(v);
                    parent[v] = curr;
                }
                else if (parent[curr] != v)
                    return true;
            }
        }
        return false;
    }
    //This is will work for a disconnected graph having cycle
    static boolean isCyclicDisconnected(ArrayList<ArrayList<Integer>> ll,int V){
        boolean [] vis = new boolean[V];
        Arrays.fill(vis, false);

        for (int i = 0; i < V; i++) {
            if(!vis[i] && isCycleConnected(ll,i,V,vis)) return true;
        }
        return false;
    }



    
    public static void main(String[] args) {
        Scanner s =  new Scanner(System.in);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        System.out.println("Enter no of vertices : ");
        int vertex = s.nextInt();

        for (int i = 0; i < vertex; i++) {
            graph.add(new ArrayList<Integer>());
        }

        System.out.println("Enter number of edges : ");
        int e = s.nextInt();

        //adding edges

        for (int i = 0; i < e; i++) {
            System.out.println("Enter source and destination : ");
            int u = s.nextInt();
            int v = s.nextInt();
            AddEdge(graph, u, v);
        }
        PrintGraph(graph);
        // System.out.println("Enter source for BFS traversal : ");
        // int source = s.nextInt();
    
        if(isCyclicDisconnected(graph,vertex)){
            System.out.println("Yes, There is exists a cycle in given graph.");
        }else{
            System.out.println("No, There is exists no cycle in given graph.");
            
        }


        s.close();

    }
}
