package DATA_STRUCTURE;

import java.util.*;

public class unionFindDS {
    static int n = 8;
    static int [] parent = new int[n];
    static int [] rank = new int[n];
    static int [] size = new int[n];

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

    static boolean Union(int x,int y){
        x = FIND(x);
        y = FIND(y);
        if(rank[x]<rank[y]){
            parent[x] = y;
        }
        else if(rank[y]<rank[x]){
            parent[y] = x;
        }else{
            parent[y] =x;
            rank[x]++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        makeSet();
        if(Union(6,7)){
            System.out.println("same set");
        }
        else{
            System.out.println("no");
        }
    }
}
