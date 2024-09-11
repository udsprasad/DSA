package DataStructures.Graph.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//undirected
public class BFS {

    static void addEdge(List<List<Integer>> graph, int src, int dst){
        graph.get(src).add(dst);
        graph.get(dst).add(src);
    }

    static void dfs(List<List<Integer>> graph, boolean[] visited, int s) throws InterruptedException {

        visited[s] = true;

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(s);

        System.out.print("  "+ s);
        System.out.println("\n visited "+ Arrays.toString(visited));
        System.out.println("\n queue "+ queue);

        while(!queue.isEmpty()){

            int current = queue.poll();

            for (int i: graph.get(current)){
                if(!visited[i]){

                    visited[i] = true;
                    queue.offer(i);
                }
            }
            System.out.println(Arrays.toString(visited));
            System.out.println(queue);
            Thread.sleep(1000);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        List<List<Integer>> graph = new ArrayList<>();
        int NoOfVertrics = 5, source = 1;
        int[][] edges = {{1, 2}, {1, 0}, {0, 2}, {2, 3}, {2, 4}};

        for(int i =0; i<NoOfVertrics; i++){
            graph.add(new ArrayList<>());
        }
        System.out.println(graph);

        for (int[] edge :edges){
            addEdge(graph,edge[0],edge[1]);
        }

        boolean[] visited = new boolean[graph.size()];

        System.out.println("Graph is "+ graph);

        dfs(graph, visited, source);
    }
}
