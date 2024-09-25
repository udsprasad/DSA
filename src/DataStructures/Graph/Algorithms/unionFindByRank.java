package DataStructures.Graph.Algorithms;

import java.util.Arrays;

public class unionFindByRank {

    static class DisjointSet{

        int vertix;

        int[] parent;

        int[] rank;

        /*Path compression whenever you calling find(parent[i]) just assign it to parent[i]*/
        /*So next time, no need to traverse through the entire branch to find ultimate parent*/
        public int findUP(int i){
            if(parent[i] == i) return i;
            return parent[i] = findUP(parent[i]) ;
        }

        DisjointSet(int vertix){
            this.vertix = vertix;
            parent = new int[vertix];

            for(int i=0;i<vertix;i++){
                parent[i] = i;
            }
            rank = new int[vertix];

            Arrays.fill(rank, 0);
        }

        public void unionByRank(int u, int v) {
            int uParent = findUP(u);
            int vParent = findUP(v);

            if(uParent == vParent) return;

            int uParentRank = rank[uParent];
            int vParentRank = rank[vParent];

            if (uParentRank < vParentRank){
                parent[uParent] = vParent;
            } else if (vParentRank < uParentRank) {
                parent[vParent] = uParent;
            } else {
                parent[vParent] = uParent;
                rank[uParent]++;
            }
        }
    }



    public static void main(String[] args){
        int[][] edges ={{0,1},{2,3},{0,4}};

        DisjointSet disjointSet = new DisjointSet(5);

        disjointSet.unionByRank(0,1);

        disjointSet.unionByRank(2,3);

        disjointSet.unionByRank(0,4);

        // Check if 4 is a friend of 0
        if (disjointSet.findUP(4) == disjointSet.findUP(0))
            System.out.println("Yes");
        else
            System.out.println("No");

        // Check if 1 is a friend of 0
        if (disjointSet.findUP(1) == disjointSet.findUP(0))
            System.out.println("Yes");
        else
            System.out.println("No");

        System.out.println(Arrays.toString(disjointSet.rank));

        System.out.println(Arrays.toString(disjointSet.parent));
    }
}
