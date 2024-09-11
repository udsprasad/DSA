package DataStructures.Graph.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//undirected
public class DFS {

    static void addEdge(List<List<Integer>> graph, int src, int dst){
        graph.get(src).add(dst);
        graph.get(dst).add(src);
    }

    static void dfs(List<List<Integer>> graph, int s) throws InterruptedException {
        boolean[] visited = new boolean[graph.size()];

        System.out.println("visited "+ Arrays.toString(visited));

        dfsRec(graph, visited, s);
    }

    static void dfsRec(List<List<Integer>> graph, boolean[] visited, int s) throws InterruptedException {
        visited[s] = true;

        System.out.print("  "+ s);
        System.out.println("\n visited "+ Arrays.toString(visited));
        Thread.sleep(1000);
        for(int i: graph.get(s)){
            if(!visited[i]){
                dfsRec(graph, visited, i);
            }
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

        System.out.println("Graph is "+ graph);

        dfs(graph, source);
    }
}
