package DataStructures.Graph;

import java.util.ArrayList;

public class GraphByAdjacencyMatrix {

    ArrayList<Node> nodes;
    private int[][] matrix;

    GraphByAdjacencyMatrix(int size){
        this.matrix = new int[size][size];
        this.nodes = new ArrayList<>();
    }

    public boolean addVertex(String value){
        Node node = new Node(value);
        if(!nodes.contains(node)){
           nodes.add(node);
           return true;
        }
        return false;
    }

    public boolean addEdge(int src, int dst){
        if (src < matrix.length && dst < matrix.length ) {
            matrix[src][dst] = 1;
        }
        return false;
    }

    public void print(){
        System.out.print("    ");
        for(int i = 0; i< matrix.length; i++){
            System.out.print(nodes.get(i).value+" ");
        }
        System.out.println();
        for(int i = 0; i< matrix.length; i++){
            System.out.print(nodes.get(i).value+" ");
            for(int j=0; j< matrix.length; j++){
                System.out.print(matrix[i][j]+"   ");
            }
            System.out.println();
        }
    }

    class Node {
        String value;
        Node(String value){
            this.value = value;
        }
    }

    public boolean checkEdge(int src, int dst){
        if (src < matrix.length && dst < matrix.length){
            if (matrix[src][dst] == 1) {
                return true;
            }
        }
        return false;
    }
}

class RunGraphByAdjacencyMatrix{
    public static void main(String[] args){
        GraphByAdjacencyMatrix gp = new GraphByAdjacencyMatrix(5);

        gp.addVertex("Bob");
        gp.addVertex("Ali");
        gp.addVertex("Mar");
        gp.addVertex("Rob");
        gp.addVertex("Mat");

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