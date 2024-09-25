package DataStructures.Graph.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/?ref=lbp*/
public class TopologicalSorting {

    public static void main(String[] args){
//        int V = 4;
//
//        int[][] edges ={{0,1},{1,2},{3,1},{3,2}};

        // Number of nodes
        int V = 6;

        // Edges
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 },
                { 4, 5 }, { 5, 1 }, { 5, 2 } };

        List<List<Integer>> adjList = new ArrayList();

        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        var freq = new int[V];

        Arrays.fill(freq,0);

        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            freq[edge[1]]++;
        }
        System.out.println("Graph "+adjList+"\n freq "+ Arrays.toString(freq));

        tps(adjList, freq);
    }

    private static void tps(List<List<Integer>> adjList, int[] freq) {
        var tpList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i< freq.length; i++){
            if (freq[i] == 0){
                queue.offer(i);
            }
        }

        if(queue.isEmpty()) {
            System.out.println("It is an undirected graph");
            return;
        }

        while(!queue.isEmpty()){

            int value = queue.poll();
            tpList.add(value);

            for(int i: adjList.get(value)){
                freq[i]--;
                if(freq[i] == 0) queue.offer(i);
            }
        }


        // Topological short list should be equals to no .of vertices in the graph

        if(tpList.size()!=adjList.size()){
                System.out.println("cyclic graph");
                return;
        }
        System.out.println(tpList);
    }
}
