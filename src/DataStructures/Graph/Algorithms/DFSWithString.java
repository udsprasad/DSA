package DataStructures.Graph.Algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Set;

public class DFSWithString {

    static void addEdge(HashMap<String, LinkedList<String>> graph, String src, String dst){
        graph.get(src).add(dst);
        graph.get(dst).add(src);
    }
    public static void main(String[] args) throws InterruptedException {
        HashMap<String, LinkedList<String>> graph = new HashMap<>();

        String source = "D";
        String[][] edges ={{"A","B"},{"A","D"},{"B","C"},{"B","D"}};

        graph.put("A", new LinkedList<>());
        graph.put("B", new LinkedList<>());
        graph.put("C", new LinkedList<>());
        graph.put("D", new LinkedList<>());

        for(String[] edge: edges){
            addEdge(graph, edge[0],edge[1]);
        }

        System.out.println(graph);

        dfs(graph, source);

    }

    static void dfs(HashMap<String, LinkedList<String>> graph, String source) throws InterruptedException {
        Set<String> visited = new HashSet<>();
        dfsRec(graph, visited, source);
    }

    static void dfsRec(HashMap<String, LinkedList<String>> graph, Set<String> visited, String source) throws InterruptedException {
        visited.add(source);

        Thread.sleep(1000);
        System.out.print("  "+ source);
        System.out.println(" \n visited "+visited);

        for(String s:graph.get(source)){
            if(!visited.contains(s)){
                dfsRec(graph,visited,s);
            }
        }

    }
}
