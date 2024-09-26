package DataStructures.Graph.LeetCodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*https://leetcode.com/problems/course-schedule/?envType=problem-list-v2&envId=topological-sort&difficulty=MEDIUM*/
public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] freq = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ouput = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] course : prerequisites){
            freq[course[1]]++;
            graph.get(course[0]).add(course[1]);
        }

        for(int i=0; i<numCourses;i++){
            if(freq[i] == 0 ) {
                queue.offer(i);
            }
        }

        if (queue.isEmpty()) return false;

        while(!queue.isEmpty()){
            int current = queue.poll();
            ouput.add(current);
            for(int i : graph.get(current)){
                freq[i]--;
                if(freq[i] == 0) queue.offer(i);
            }
        }

        return ouput.size() == numCourses;
    }

    public static void main(String[] args){
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        System.out.println(canFinish(numCourses,prerequisites));
    }
}
