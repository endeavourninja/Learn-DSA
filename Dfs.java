import java.util.*;

class Dfs {

    public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> storedfs) {
        storedfs.add(node);
        vis[node] = true;
        for (Integer it : adj.get(node)) {
            if (vis[it] == false) {
                dfs(it, vis, adj, storedfs);
            }
        }
    }

    public static ArrayList<Integer> dfs_graph(int n, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> storedfs = new ArrayList<Integer>();
        boolean vis[] = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (vis[i] == false) {
                dfs(i, vis, adj, storedfs);
            }
        }
        return storedfs;
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void printGraph(int n, ArrayList<ArrayList<Integer>> adj) {
        for (int i = 1; i <= n; i++) {
            System.out.println("Traveresed index- " + i);
            for (int it : adj.get(i)) {
                System.out.print(it + ",");
            }
            System.out.println();
        }

    }

    public static void main(String arg[]) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n);
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            addEdge(adj, u, v);
        }
        printGraph(n, adj);
        ArrayList<Integer> res = dfs_graph(n, adj);
        System.out.println("here is dfs");
        for (int it : res) {
            System.out.println(" " + it);
        }
    }
}