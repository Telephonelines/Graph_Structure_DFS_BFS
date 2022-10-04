import java.util.*;

public class Graph {
    /*static boolean connected(Vertex a, Vertex b, ArrayList<Edge> edges, ArrayList<Vertex> vertices) {
        for (Edge e : edges) {
            if ((e.getA()== a && e.getB() == b) || (e.getA() == b && e.getB() == a)) {
                return true;
            }
        }
        return false;
    }*/

    LinkedList<Integer>[] graph;
    boolean directed;

    public Graph(int N) {
        this(N, false);
    }

    public Graph(int N, boolean directed) {
        graph = new LinkedList[N];
        this.directed = directed;

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
    }

//    public ArrayList<Integer> bfs(int s) {
//        int N = size();
//        ArrayList<Integer> reachable = new ArrayList<>();
//        Queue<Integer> queue = new LinkedList<>();
//        boolean[] visited = new boolean[N];
//        visited[s] = true;
//        queue.add(s);
//
//        while (queue.size() != 0) {
//            s = queue.poll();
//            reachable.add(s);
//            for (int i : neighbours(s)) {
//                //a = i;
//                if(!visited[i]) {
//                    visited[i] = true;
//                    queue.add(i);
//                }
//            }
//        }
//        return reachable;
//    }
//
//    public ArrayList<Integer> dfs(int s) {
//        int N = size();
//        ArrayList<Integer> reachable = new ArrayList<>();
//        Stack<Integer> stack = new Stack<Integer>();
//        boolean[] visited = new boolean[N];
//        visited[s] = true;
//        stack.add(s);
//
//        while (stack.size() != 0) {
//            s = stack.pop();
//            reachable.add(s);
//            for (int i : neighbours(s)) {
//                //a = i;
//                if(!visited[i]) {
//                    visited[i] = true;
//                    stack.push(i);
//                }
//            }
//        }
//        return reachable;
//    }

    public boolean isDirected() {
        return directed;
    }

    public boolean hasEdge(int v, int u) {
        return graph[v].contains(u);
    }

    public LinkedList<Integer> neighbours(int v) {
        return graph[v];
    }

    public int degree(int v) {
        return graph[v].size();
    }

    public void removeEdge(int v, int u) {
        graph[v].remove((Integer) u);
        if(!isDirected()) {
            graph[u].remove((Integer) v);
        }
    }

    public void addEdge(int v, int u) {
        graph[v].add(u);
        if (!isDirected()) {
            graph[u].add(v);
        }
    }

    public int size() {
        return graph.length;
    }

    public boolean validVertex(int v) {
        return ((v >= 0) && (v < size()));
    }

    public String toString() {
        return "Graph = " + Arrays.toString(graph);
    }

    public static void main(String[] args) {
        /*ArrayList<Vertex> vertices = new ArrayList<>();
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            vertices.add(new Vertex(i + 1));
        }
        edges.add(new Edge(vertices.get(0), vertices.get(1), 12));
        edges.add(new Edge(vertices.get(1), vertices.get(2), 9));
        edges.add(new Edge(vertices.get(2), vertices.get(3), 11));
        edges.add(new Edge(vertices.get(3), vertices.get(4), 27));
        edges.add(new Edge(vertices.get(4), vertices.get(2), 10));
        edges.add(new Edge(vertices.get(5), vertices.get(2), 27));

        System.out.println(connected(vertices.get(0), vertices.get(1), edges, vertices));
        System.out.println(connected(vertices.get(1), vertices.get(0), edges, vertices));
        System.out.println(connected(vertices.get(0), vertices.get(2), edges, vertices));*/

        Graph g = new Graph(20);
        System.out.println(g);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(2, 3);
        System.out.println(g);
        System.out.println(g.hasEdge(1,0));
        System.out.println(g.hasEdge(0,2));
        System.out.println(g.neighbours(0));
        System.out.println(g.neighbours(1));
        g.removeEdge(0, 1);
        System.out.println(g.neighbours(0));
        System.out.println(g.neighbours(1));

//        System.out.println(g.bfs(0));
//        System.out.println(g.dfs(0));
    }
}
