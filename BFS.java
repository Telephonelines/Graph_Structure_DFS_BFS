import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    Graph g;
    int root;

    public BFS(Graph g, int root) {
        this.g = g;
        this.root = root;
    }

    public ArrayList<Integer> search() {
        int N = g.size();
        ArrayList<Integer> reachable = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];
        visited[root] = true;
        queue.add(root);

        while (queue.size() != 0) {
            root = queue.poll();
            reachable.add(root);
            for (int i : g.neighbours(root)) {
                //a = i;
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        return reachable;
    }

    public static void main(String[] args) {
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

        BFS s = new BFS(g, 0);
        System.out.println(s.search());
    }
}