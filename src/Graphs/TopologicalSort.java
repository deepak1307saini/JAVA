package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s ;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }


        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));

    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (vis[e.dest] == false) {
                dfs(graph, e.dest, vis);
            }
        }

    }

    public static boolean isCycleDirected(ArrayList<Edge> graph[], boolean vis[], int curr, boolean rec[]) {
        vis[curr] = true;
        rec[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (rec[e.dest] == true)
                return true;

            if (vis[e.dest] == false) {
                if (isCycleDirected(graph, vis, e.dest, rec)) {
                    return true;
                }
            }
        }

        rec[curr] = false;

        return false;
    }

    public static void topSortUtil(ArrayList<Edge> graph[], boolean vis[], int curr, Stack<Integer> st) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                topSortUtil(graph, vis, e.dest, st);
            }
        }

        st.push(curr);
    }

    public static void topSort(ArrayList<Edge> graph[], int V) {
        Stack<Integer> st = new Stack<>();
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topSortUtil(graph, visited, i, st);
            }
        }

        while (!st.isEmpty()) {
            System.out.print(st.peek() + " ");
            st.pop();
        }
    }

    public static void main(String[] args) {
        int V = 6;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        boolean vis[] = new boolean[V];
        boolean rec[] = new boolean[V];
        boolean isCycle = false;

        for (int i = 0; i < V; i++) {

            if (!vis[i] && isCycleDirected(graph, vis, i, rec)) {
                System.out.println("Cycle present");
                isCycle = true;
                break;
            }
        }


        if (!isCycle) {
            topSort(graph, V);
        }


    }
}
