package DATA_STRUCTURE.Graph_Theory;

import java.util.*;

public class Kruskals {

    private ArrayList<Edge> edges = new ArrayList<>();

    private ArrayList<Vertex> vertices = new ArrayList<>();
    private ArrayList<HashSet<Vertex>> subsets = new ArrayList<>();
    

    public static void main(String args[]) {
        Kruskals kruskal = new Kruskals();

        kruskal.init();

    }

    private void init() {

        vertices.add(new Vertex(0));
        vertices.add(new Vertex(1));
        vertices.add(new Vertex(2));
        vertices.add(new Vertex(3));
        vertices.add(new Vertex(4));
        vertices.add(new Vertex(5));
        vertices.add(new Vertex(6));
        vertices.add(new Vertex(7));
        vertices.add(new Vertex(8));
        vertices.add(new Vertex(9));

        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 3, 3));
        edges.add(new Edge(0, 6, 6));
        edges.add(new Edge(1, 2, 1));
        edges.add(new Edge(1, 6, 4));
        edges.add(new Edge(3, 5, 9));
        edges.add(new Edge(3, 9, 16));
        edges.add(new Edge(2, 4, 11));
        edges.add(new Edge(2, 8, 17));
        edges.add(new Edge(4, 7, 7));
        edges.add(new Edge(4, 8, 8));
        edges.add(new Edge(4, 6, 12));
        edges.add(new Edge(5, 7, 5));
        edges.add(new Edge(5, 9, 10));
        edges.add(new Edge(5, 6, 13));
        edges.add(new Edge(6, 8, 18));
        edges.add(new Edge(6, 9, 19));
        edges.add(new Edge(7, 9, 14));
        edges.add(new Edge(7, 8, 15));
        edges.add(new Edge(5, 4, 20));


        // make subset of each vertex
        for (int i = 0; i < vertices.size(); i++) {
            HashSet<Vertex> set = new HashSet<>();
            set.add(vertices.get(i));
            subsets.add(set);
        }

        // sorting the edges based on the weight
        System.out.println("The input Graph with 10 vertex and following edges");
        System.out.println(edges);
        Collections.sort(edges, new weightComparator());
        System.out.println("The MST after running Kruskals Algorithm");
        System.out.println("Src --> Dst == Wt");
        // Union and Find algorithm to detect a cycle
        for (int i = 0; i < edges.size(); i++) {
            Edge edg = edges.get(i);
            Vertex srcNode = vertices.get(edg.src);
            Vertex destNode = vertices.get(edg.dest);

            if (find(srcNode) != find(destNode)) {
                System.out.println(edg.src + " --> " + edg.dest + " == " + edg.weight);
                union(find(srcNode), find(destNode));
            }
        }
    }

    private void union(int aSubset, int bSubset) {
        HashSet<Vertex> aSet = subsets.get(aSubset);
        HashSet<Vertex> bSet = subsets.get(bSubset);
        //adding all elements of subsetB in subsetA and deleting subsetB
        Iterator<Vertex> iter = bSet.iterator();
        while (iter.hasNext()) {
            Vertex b = iter.next();
            aSet.add(b);
        }
        subsets.remove(bSubset);

    }





    private int find(Vertex node) {
        int number = -1;

        for (int i = 0; i < subsets.size(); i++) {
            HashSet<Vertex> set = subsets.get(i);
            Iterator<Vertex> iterator = set.iterator();
            while (iterator.hasNext()) {
                Vertex setnode = iterator.next();
                if (setnode.number == node.number) {
                    number = i;
                    return number;
                }

            }
        }
        return number;
    }
}

class weightComparator implements Comparator<Edge> {

    
    public int compare(Edge e1, Edge e2) {
        return e1.weight - e2.weight;
    }
}

class Edge {
    int src;
    int dest;
    int weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "\n" + src + " --> " + dest + " == " + weight
                + "]";
    }
}

class Vertex {
    int number = 0;

    Vertex(int number) {
        this.number = number;
    }
}