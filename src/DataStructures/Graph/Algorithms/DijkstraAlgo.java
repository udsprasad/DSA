package DataStructures.Graph.Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class DijkstraAlgo {

    class Node{
        String name;
        int weight;
        Node(String name, int weight){
            this.name =name;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    ", weight=" + weight +
                    '}';
        }

        public String getName() {
            return name;
        }

        public int getWeight() {
            return weight;
        }
    }

    public static void main(String[] args){
        String[][] edges ={{"A","B","2"},{"A","D","8"},{"B","E","6"},{"B","D","5"},{"D","E","3"},{"D","F","2"},{"E","F","1"},
                {"E","C","1"},{"F","C","3"}};

        Map<String, List<Node>> graph = new HashMap<>();
        addVertix(graph,"A");
        addVertix(graph,"B");
        addVertix(graph,"C");
        addVertix(graph,"D");
        addVertix(graph,"E");
        addVertix(graph,"F");

        for(String[] edge: edges) {
            addEdge(graph,edge[0],edge[1],Integer.parseInt(edge[2]));
        }

        System.out.println(graph);

        Set<String> visited = new HashSet<>();

        System.out.println();
        System.out.println();

        String source = "A";

        String destination = "F";

        shortestDistance(graph, visited, source, destination);
    }

    private static void shortestDistance(Map<String, List<Node>> graph, Set<String> visited,
                                         String source, String destination) {
        int length =0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(source);

        while(!queue.isEmpty()) {

            source = queue.poll();

            System.out.println("  " + source);
            if (destination == source) {
                break;
            }

            int min = Integer.MAX_VALUE;
            String vertix = "";
            if (!visited.contains(source) && !graph.get(source).isEmpty()) {
                for (Node edge : graph.get(source)) {
                    if (edge.getWeight() < min) {
                        min = edge.getWeight();
                        vertix = edge.getName();
                    }
                }
                queue.offer(vertix);
                length += min;
            }
        }

        System.out.println("distance "+ length);
    }

    private static void addEdge(Map<String, List<Node>> graph, String src, String dst, int weight) {
        graph.get(src).add(new DijkstraAlgo().new Node(dst, weight));
    }

    private static void addVertix(Map<String, List<Node>> graph, String a) {
        graph.put(a,new ArrayList<>());
    }


}
