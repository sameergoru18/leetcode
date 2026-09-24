class Solution {
    public boolean dfs(int i,List<List<Integer>> adj,int[] visited,int[] cycleVisited){
        visited[i]=1;
        cycleVisited[i]=1;
        for(int x: adj.get(i)){
            if(visited[x]==0){
                if(!dfs(x,adj,visited,cycleVisited)) return false;
                
            }
            else if(cycleVisited[x]==1) return false;
        }
        cycleVisited[i]=0;
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        int[] cycleVisited = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        if(m==0) return  true;
        int n = prerequisites[0].length;
        for(int i=0;i<m;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(u).add(v);
        }
        Arrays.fill(visited,0);
        Arrays.fill(cycleVisited,0);
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                if(!dfs(i,adj,visited,cycleVisited)){
                    return false;
                }
            }
        }
        return true;
        
    }
}