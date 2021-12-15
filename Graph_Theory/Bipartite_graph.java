package DATA_STRUCTURE.Graph_Theory;
import java.util.*;
public class Bipartite_graph {
    
    //for checking graph is bipartite or not 
   static boolean isBipartite(int G[][],int src,int V)
    {
        //array for vertex coloring 
        int colorArr[] = new int[V];
        //felling with -1 initially 

        for (int i=0; i<V; ++i)
            colorArr[i] = -1;
 
        
        colorArr[src] = 1;

        Queue<Integer>q = new LinkedList<Integer>();
        q.add(src);
 
        while (!q.isEmpty())
        {
            int u = q.poll();
            //if there is any self loop then this will return false
            if (G[u][u] == 1)
                return false;
 

            for (int v=0; v<V; ++v)
            {
                if (G[u][v]==1 && colorArr[v]==-1)
                {
                    colorArr[v] = 1-colorArr[u];//giving second
                    q.add(v);
                }
 
                //if we got same color then this will return false
                else if (G[u][v]==1 && colorArr[v]==colorArr[u])
                    return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {

        Scanner s =  new Scanner(System.in);
        System.out.println("Enter number of vertices : ");
        int v = s.nextInt();
        System.out.println("Enter number of edges : ");
        int e = s.nextInt();

        int graph[][] = new  int[v][v];

        for (int i = 0; i <e ; i++) {
            System.out.println("Enter source and destination : ");
            int src = s.nextInt();
            int des = s.nextInt();
            graph[src][des] = 1;
            graph[des][src] = 1;
        }
        System.out.println("Enter source for traversal : ");
        int source = s.nextInt();
        String str = isBipartite(graph, source,v)? "The given graph is bipartite." : "The given graph is not bipartite.";
        System.out.println(str);
        

        s.close();
    }
}
