import java.util.*;

class Node{
    int first;
    int second;
    public Node(int first,int second){
        this.first=first;
        this.second=second;
    }
}


class Cycle_Bfs {



    public static boolean checkCycle(int s,boolean vis[],ArrayList<ArrayList<Integer>>adj){

        Queue<Node> q= new LinkedList<>();
        q.add(new Node(s, -1));
        vis[s]=true;
        while(!q.isEmpty()){
            int node = q.peek().first;
            int pre= q.peek().second;
            q.remove();
            for(int it:adj.get(node)){
                if(vis[it]==false){
                    q.add(new Node(it, node));
                    vis[it]=true;

                }
                else if(it!=pre) return true;
            }
        }
        return false;
    }

    public static boolean isCycle(int n,ArrayList<ArrayList<Integer>>adj){
        boolean vis[]=new boolean[n+1];
        for(int i=1;i<=n;i++){
            if(vis[i]==false){
                if(checkCycle(i,vis,adj)){
                    return true;
                }

            }
        }
        return false;
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
        if(isCycle(n,adj)){

            System.out.println("Yes!!! the graph has cycle......");
        }
        else{
            System.out.println("No!!!!");
        }
        // ArrayList<Integer> res = dfs_graph(n, adj);
        // System.out.println("here is dfs");
        // for (int it : res) {
        // System.out.println(" " + it);
        // }
    }
}