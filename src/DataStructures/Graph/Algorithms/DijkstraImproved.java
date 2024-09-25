package DataStructures.Graph.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraImproved {

    static class Graph {
        int vertex;
        List<List<Edge>> adjList;

        Graph(int vertex) {
            this.vertex = vertex;
            adjList = new ArrayList<>();
            for (int i = 0; i < vertex; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(int src, int dst, int weight){
            adjList.get(src).add(new Edge(dst,weight));
        }

        List<Edge> getEdges(int u){
            return adjList.get(u);
        }
    }

    static class Edge{
        int destination;
        int weight;

        Edge(int destination, int weight){
            this.destination = destination;
            this.weight = weight;
        }
    }


    public static void main(String[] args){

        int[][] edges = {{1,2,5},{1,3,6},{3,4,1},{4,2,2}};

        Graph graph = new Graph(5);

        for(int[] edge: edges){
            graph.addEdge(edge[0],edge[1],edge[2]);
        }

        int source = 1;
        dijkstra(graph, source);
    }

    private static void dijkstra(Graph graph, int source) {
        int V = graph.vertex;
        int[] shortestDistance = new int[V];
        int[] previousVertex = new int[V];
        boolean[] visited = new boolean[V];

        /*Comparator.comparingInt(a -> a[1]): This specifies that the PriorityQueue should order its elements by
        the second element of the integer arrays. In other words,
        it orders the arrays based on their distance value (a[1]), with the smallest distances
        given the highest priority (i.e., they come first in the queue).*/
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));


        // adding default values
        Arrays.fill(shortestDistance,Integer.MAX_VALUE);
        Arrays.fill(previousVertex,-1);


        shortestDistance[source] = 0;
        queue.offer(new int[]{source,0});

        while(!queue.isEmpty()){
            int[] current = queue.poll();

            int currentVertex = current[0];

            if (visited[currentVertex]) continue;
            visited[currentVertex] = true;

            for(Edge e : graph.getEdges(currentVertex)){
                int nextVertix = e.destination;
                int distance = e.weight;

                // d[u] + course[u,v] < d[v]
                if (shortestDistance[currentVertex]+distance < shortestDistance[nextVertix]){
                    shortestDistance[nextVertix] = shortestDistance[currentVertex]+distance;
                    queue.offer(new int[]{nextVertix,shortestDistance[nextVertix]});
                    previousVertex[nextVertix] = currentVertex;
                }
            }
        }

        printPaths(source, shortestDistance, previousVertex);
    }

    private static void printPaths(int source, int[] shortestDistance, int[] previousVertex) {
        int V = shortestDistance.length;
        System.out.println("Shortest paths from vertex " + source + ":");
        for (int i = 0; i < V; i++) {
            if (shortestDistance[i] == Integer.MAX_VALUE) {
                System.out.println("Vertex " + i + " is unreachable");
            } else {
                System.out.print("Vertex " + i + ": Distance = " + shortestDistance[i] + ", Path = ");
                printPath(i, previousVertex);
                System.out.println();
            }
        }
    }

    private static void printPath(int vertex, int[] previousVertex) {
        if (vertex == -1) {
            return;
        }
        printPath(previousVertex[vertex], previousVertex);
        System.out.print(vertex + " ");
    }

}
