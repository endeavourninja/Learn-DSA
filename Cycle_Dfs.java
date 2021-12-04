import java.util.*;

class Cycle_Dfs{
    
    public static boolean isCycle(int node,int par,ArrayList<ArrayList<Integer>>adj,boolean vis[]){

        vis[node]=true;
        for(Integer it:adj.get(node)){
            if(vis[it]==false){
                if(isCycle(it, node, adj, vis)==true){return true;} 
            }else if(it!=par){return true;} 
        }

        return false;

    }

    public static boolean check_cycle(int n,ArrayList<ArrayList<Integer>>adj){

        boolean vis[]= new boolean[n+1];
        Arrays.fill(vis,false);
        for(int i=1;i<=n;i++){
            if(vis[i]==false){
                if(isCycle(i,-1,adj,vis)==true){return true;} 
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
        //System.out.print(check_cycle(n, adj));
        if(check_cycle(n,adj)==true){
            System.out.println("Yes!!! there is the cycle...");
        }else{
            System.out.println("No!!!!");
        }
    }
}