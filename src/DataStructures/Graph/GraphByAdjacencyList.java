package DataStructures.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphByAdjacencyList {

    private List<LinkedList<String>> graph;

    GraphByAdjacencyList(){
        this.graph = new ArrayList<>();
    }

    public boolean addVertex(String value){
        LinkedList<String> vertex = new LinkedList<>();
        vertex.add(value);
        if (!graph.contains(vertex)) {
            graph.add(vertex);
            return true;
        }
        return false;
    }

    public boolean addEdge(int src, int dst){
        if (src < graph.size() && dst < graph.size()){
            String dstname = graph.get(dst).getFirst();
            graph.get(src).add(dstname);
            return true;
        }
        return false;
    }

    public void print(){
        System.out.println(graph);
    }

}

class RunGraphByAdjacencyList{
    public static void main(String[] args){
        GraphByAdjacencyList gp = new GraphByAdjacencyList();

        gp.addVertex("Bob");
        gp.addVertex("Alica");
        gp.addVertex("Mark");
        gp.addVertex("Rob");
        gp.addVertex("Maria");

        gp.addEdge(0,1);
        gp.addEdge(1,0);
        gp.addEdge(1,2);
        gp.addEdge(2,3);
        gp.addEdge(3,4);
        gp.addEdge(2,1);
        gp.addEdge(3,2);
        gp.addEdge(4,3);
        gp.addEdge(0,3);
        gp.addEdge(1,4);
        gp.addEdge(3,0);
        gp.addEdge(4,1);

        gp.print();
    }
}
