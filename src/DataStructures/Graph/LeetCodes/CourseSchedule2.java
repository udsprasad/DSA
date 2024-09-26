package DataStructures.Graph.LeetCodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*https://leetcode.com/problems/course-schedule-ii/description/?envType=problem-list-v2&envId=topological-sort&difficulty=MEDIUM*/
public class CourseSchedule2 {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] order = new int[numCourses];
        int[] indeg = new int[numCourses];
        int p = prerequisites.length;
        for (int i=0;i< numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] course: prerequisites){
            indeg[course[0]]++;
            graph.get(course[1]).add(course[0]);
        }
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0) {
                queue.offer(i);
            }
        }
        int count =0;
        while(!queue.isEmpty()){
            int current = queue.poll();
            order[count++] =current;
            for(int i : graph.get(current)){
                    indeg[i]--;
                    if(indeg[i]==0) queue.offer(i);

                }
        }
        return count == numCourses ? order : new int[]{};
    }

    public static void main(String[] args){
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        System.out.println(Arrays.toString(findOrder(numCourses,prerequisites)));
    }
}
