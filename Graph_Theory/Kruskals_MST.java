package DATA_STRUCTURE.Graph_Theory;

import java.util.*;

//Name - Pavitra Behara
//Regd.No - 2041002041
//Section - CSE-D
//Title of the program - Kruskal's Minimum Spanning Tree

public class Kruskals_MST {
    //Kruskal's Algorithm 
    //Time -> O(E log V)
    //space O(E + V)

    int v; // no of vertices
    int e;// no of edges
    Edge edge[]; //Array of object of Edge class which contains source,destination and weight

    Kruskals_MST(int v, int e) {
        this.v = v;
        this.e = e;
        edge = new Edge[e];//initilizating edge array 
        for (int i = 0; i < e; ++i) {
            edge[i] = new Edge();//each element in the array is an object containing src,des, and weight
        }
    }

    //Edge class which contains source, destination and weight and also a compareTo method 
    //which compare the edges according to their weights
    class Edge implements Comparable<Edge> {
        int src, des, weight;

        @Override
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    //Class subset which contain a parent and rank 
    //this is like the parent array that we used previously to create
    //disjoint set
    class subset {
        int parent;
        int rank;
    }


    //Find funtion according to disjoint set
    int FIND(subset subs[], int i) {
        if (subs[i].parent != i) {
            subs[i].parent = FIND(subs, subs[i].parent);
            return subs[i].parent;
        } else {
            return subs[i].parent;
        }
    }

    //union funtion according to disjoint set
    void Union(subset sb[], int u, int v) {
        int x = FIND(sb, u);
        int y = FIND(sb, v);

        //if parent of both are equal
        if (x == y) {
            return;
        }


        if (sb[x].rank < sb[y].rank) {
            sb[x].parent = y;
        } else if (sb[x].rank > sb[y].rank) {
            sb[y].parent = x;
        } else {
            sb[y].parent = x;
            sb[x].rank++;
        }
    }

    //Kruskals minimum spanning tree function

    void kruskals(){
        //previous process of array of object 
        Edge ans[] = new Edge[v];
         
        int e = 0;

        for (int i = 0; i < v; ++i) {
            ans[i] = new Edge();
        }

        Arrays.sort(edge);//sorting according to the weight

        subset []subsets = new subset[v];

        for (int i = 0; i < ans.length; i++) {
            subsets[i] = new subset();
        }

        //MAKE SET function according to the disjoint set
        for (int i = 0; i < v; ++i) {
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        int i =0;
        //for each edge in g
        while(e<v-1){
            Edge nextedge = edge[i++];//this is a single edge object from the array of objects edge

            int x = FIND(subsets, nextedge.src);
            int y = FIND(subsets, nextedge.des);
            if(x!=y){
                ans[e++] = nextedge;
                Union(subsets, x, y);
            }
        }

        //printing the edges and weights according to ans array
        System.out.println("After applying Kruskals Algorithm...");
        int minimumCost = 0;
        for (i = 0; i < e; ++i){
            System.out.println(ans[i].src + " -- " + ans[i].des+ " == " + ans[i].weight);
            minimumCost += ans[i].weight;
        }
        System.out.println("Minimum Cost Spanning Tree "+ minimumCost);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of vertices : ");
        int v = s.nextInt();
        System.out.println("Enter the number of edges : ");
        int e = s.nextInt();

        Kruskals_MST graph = new Kruskals_MST(v, e);
        for (int i = 0; i < e; i++) {
            System.out.println("Enter source for edge " + i + " : ");
            int sr = s.nextInt();
            System.out.println("Enter destination for edge " + i + " : ");
            int d = s.nextInt();
            System.out.println("Enter weight for edge (" + sr + "," + d + ") : ");
            int w = s.nextInt();
            //for the ith edge giving the source, destination and weight
            
            graph.edge[i].src = sr;
            graph.edge[i].des = d;
            graph.edge[i].weight = w;
        }
        graph.kruskals();
        s.close();
    }
}
