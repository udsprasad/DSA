package DataStructures.Graph;

import java.util.Set;
import java.util.HashSet;


public class ProblemFromAppu{

    static void addEdge(int[][] matrix, String src, String dst,String[] vertex){
        matrix[getIndex(vertex, src)][getIndex(vertex,dst)] = 1;
        matrix[getIndex(vertex, dst)][getIndex(vertex,src)] = 1;
    }

    static int getIndex(String[] vertex, String src){
        for(int j=0; j< vertex.length;j++ ){
            if (src.equals(vertex[j])){
                return j;
            }
        }
        return 0;
    }


    static void dfs(int[][] matrix, String source, String[] vertex) throws InterruptedException {
        Set<String> visited = new HashSet<>();
        dfsRec(matrix, source, vertex, visited);
    }

    static void dfsRec(int[][] matrix, String source, String[] vertex, Set<String> visited) throws InterruptedException {
        if(!visited.contains(source)){
            visited.add(source);
        }

        System.out.println("   "+ source);
        System.out.println("visited "+ visited);
        Thread.sleep(1000);

        for(int j=0;j< matrix[getIndex(vertex,source)].length; j++) {
            if(matrix[getIndex(vertex,source)][j] == 1){
                String nextValue = vertex[j];
                if(!visited.contains(nextValue)){
                    dfsRec(matrix, nextValue, vertex, visited);
                }
            }
        }
    }

    public static void main(String[] arg) throws InterruptedException {
        String[] vertex = {"A", "B", "C", "D", "E"};
        String[][] edges = {{"A", "B"}, {"A", "D"}, {"A", "C"}, {"B", "C"}, {"C", "D"}, {"C", "E"}};
        String source = "C";

        int[][] matrix = new int[vertex.length][vertex.length];
        for(String[] edge : edges){
            addEdge(matrix,edge[0],edge[1], vertex);
        }

        for(int i=0; i< matrix.length; i++){
            for(int j=0; j< matrix.length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

       dfs(matrix, source, vertex);
    }
}

