import java.util.ArrayList;
import java.util.Stack;

public class DFS {
    Graph g;
    int root;

    public DFS(Graph g, int root) {
        this.g = g;
        this.root = root;
    }

    public ArrayList<Integer> search() {
        int N = g.size();
        ArrayList<Integer> reachable = new ArrayList<>();
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[N];
        visited[root] = true;
        stack.add(root);

        while (stack.size() != 0) {
            root = stack.pop();
            reachable.add(root);
            for (int i : g.neighbours(root)) {
                if(!visited[i]) {
                    visited[i] = true;
                    stack.push(i);
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

        DFS s = new DFS(g, 0);
        System.out.println(s.search());
    }
}
