import java.util.*;
class Bipartite_Bfs{
    public static boolean bfsCheck(int node,int color[], ArrayList<ArrayList<Integer>>adj){
        Queue<Integer> q= new LinkedList<>();
        color[node]=1;
        q.add(node);
        while(!q.isEmpty()){
            int n=q.poll();
            for(Integer it:adj.get(n)){
                if(color[it]==-1){
                    color[it]=1-color[n];
                    q.add(it);
                }
                else if(color[it]==color[n]) return false;
            }
        }
        return true;

    }
    public static boolean checkBipartite(int n,ArrayList<ArrayList<Integer>>adj){
        int color[]=new int[n+1];
        Arrays.fill(color,-1);
        for(int i=1;i<=n;i++){
            if(color[i]==-1){
                if(!bfsCheck(i,color,adj)) return false;
            }
        }
        return true;

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
        if(checkBipartite(n,adj)){

            System.out.println("Yes!!!......");
        }
        else{
            System.out.println("No!!!!");
       }   
    }
}