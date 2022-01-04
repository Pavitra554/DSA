package DATA_STRUCTURE;

import java.util.*;

public class unionFindDS {
    //Union Find DataStructure 
    //Disjoint set
    static int n = 6;
    static int [] parent = new int[n];
    static int [] rank = new int[n];

    static void makeSet(){
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i]=0;
        }
    }

    static int FIND(int x){
        if(parent[x]==x){
            return x;
        }
        else{
            return parent[x] = FIND(parent[x]);
        }
    }

    static void Union(int x,int y){
        x = FIND(x);
        y = FIND(y);
        if(x == y){
            return;
        }

        if(rank[x]<rank[y]){
            parent[x] = y;
        }
        else if(rank[y]<rank[x]){
            parent[y] = x;
        }else{
            parent[y] =x;
            rank[x]++;
            return;
        }
    }

    public static void main(String[] args) {
        makeSet();
        Union(0, 3);
        Union(3, 5);
        Union(1, 2);
        if (FIND(5) == FIND(0))
            System.out.println("Yes");
        else
            System.out.println("No");
  
        // Check if 1 is a friend of 0
        if (FIND(1) == FIND(0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
