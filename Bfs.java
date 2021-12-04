import java.util.*;

class Bfs {

    public static ArrayList<Integer> bfsGraph(int n, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> bfs = new ArrayList<Integer>(n);
        boolean vis[] = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (vis[i] == false) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                vis[i] = true;
                while (!q.isEmpty()) {
                    Integer node = q.poll();
                    bfs.add(node);
                    for (int it : adj.get(node)) {
                        if (vis[it] == false) {
                            q.add(it);
                            vis[it] = true;
                        }
                    }
                }
            }
        }
        return bfs;
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 1; i < adj.size(); i++) {
            System.out.println("adjecncy list at vertex- " + i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + ",");
            }
            System.out.println();
        }

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n);
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            addEdge(adj, u, v);
        }

        printGraph(adj);

        System.out.println("Here is the traveresed graph ");
        ArrayList<Integer> arr = bfsGraph(n, adj);
        for (int k : arr) {
            System.out.print(k);
        }

    }

}