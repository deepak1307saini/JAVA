package Graphs;

import java.util.ArrayList;

public class CycleDetectionInDirectedGraph {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }


        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
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

    public static void main(String[] args) {
        int V = 4;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        boolean vis[] = new boolean[V];
        boolean rec[] = new boolean[V];
        boolean isCycle = false;

        for (int i = 0; i < V; i++) {

            if (!vis[i] && isCycleDirected(graph, vis, i, rec)) {
                System.out.println("True");
                isCycle = true;
                break;
            }
        }

        if (!isCycle) {
            System.out.println("False");
        }
    }
}
