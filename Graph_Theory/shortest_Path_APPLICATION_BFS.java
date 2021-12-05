package DATA_STRUCTURE.Graph_Theory;
import java.util.*;

public class shortest_Path_APPLICATION_BFS {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        //Funtion for adding edges in Undirected graph
    static void AddEdge(ArrayList<ArrayList<Integer>> ll,int u,int v){
        ll.get(u).add(v);
        ll.get(v).add(u);
    }
    //Function for Printing graph
    static void printGraph(ArrayList<ArrayList<Integer>> ll){
        //for outer list
        for (int i = 0; i < ll.size(); i++) {
            System.out.print("\nAdjacency list for "+i+" ");
            //for printing inner list
            //adjacency vertices
            for (int j = 0; j < ll.get(i).size(); j++) {
                System.out.print(" --> "+ll.get(i).get(j));
            }
            System.out.println();
        }
    }
    //Function for finding Shortest distance between source and destination
    static void BFS_ShortestPath(ArrayList<ArrayList<Integer>> ll,int src,int des){
        boolean [] vis = new boolean[ll.size()];
        int [] ans = new int[ll.size()];
        vis[src] = true;
        ans[src] = -1;

        Queue<Integer> q = new LinkedList<Integer>(); 
        q.add(src);
        while(!q.isEmpty()){
            int curr = q.poll();

            if(curr == des){
                break;
            }
            for (int i:ll.get(curr)) {
                if(!vis[i]){
                    vis[i] = true;
                    q.add(i);
                    ans[i] = curr;

                }
            }

        }
        int curr = des;
        int dis = 0;
        while(ans[curr]!=-1){
            System.out.print(curr+" --> ");
            curr = ans[curr];
            dis++;
        }
        System.out.println(src);
        System.out.println("\nShortest distance is "+dis);
    }



    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of vertices : ");
        int v = s.nextInt();
        System.out.println("Enter the number of edges : ");
        int e = s.nextInt();

        for (int i = 0; i < v; i++) {
            //creating empty list under a specific index of outer list
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < e; i++) {
            System.out.println("Enter source and destination : ");
            int src = s.nextInt();
            int des = s.nextInt();
            AddEdge(graph, src, des);
        }
        printGraph(graph);
        System.out.println("Enter source and destination for finding shortest path :");
        int source = s.nextInt();
        int destination = s.nextInt();
        BFS_ShortestPath(graph, source, destination);

        s.close();
        
    }
}
