package question1;

import java.util.ArrayList;
import java.util.Arrays;

public class RatInAMaze {
	
	public static ArrayList<String> helper(int[][] m, int[][] visited, ArrayList<String> pathArr, String path,  int x,int y){
        int n = m.length;
        if(x==n-1 && y == n-1){
        	if(path!="")
        		pathArr.add(path);
            visited[x][y] = 0;
            return pathArr;
        }
        //Down
        if(x+1<n && visited[x+1][y]!=1 && m[x+1][y]==1){
            visited[x+1][y]=1;
            
            pathArr = helper(m,visited,pathArr,path+"D",x+1,y);
        }
        //Left
        if(y-1>=0 && visited[x][y-1]!=1 && m[x][y-1]==1){
            visited[x][y-1]=1;
            
            pathArr = helper(m,visited,pathArr,path+"L",x,y-1);
        }
        //Right
        if(y+1<n && visited[x][y+1]!=1 && m[x][y+1]==1){
            visited[x][y+1]=1;
            
            pathArr = helper(m,visited,pathArr,path+"R",x,y+1);
        }
        //Up
        if(x-1>=0 && visited[x-1][y]!=1 && m[x-1][y]==1){
            visited[x-1][y]=1;
            
            pathArr = helper(m,visited,pathArr,path+"U",x+1,y);
        }
        visited[x][y] = 0;
        return pathArr;
    }
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> pathArr = new ArrayList<>();
        if(m[0][0]==0)
        	return pathArr;
        int[][] visited = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(visited[i],0);
        }
        visited[0][0]=1;
        String path = "";
        pathArr = helper(m, visited, pathArr, path, 0, 0);
        return pathArr;
        
    }
    public static void main(String[] args){
        int[][] m = {{1, 0, 0, 0},
        {1, 1, 0, 1}, 
        {1, 1, 0, 0},
        {0, 1, 1, 1}};

        ArrayList<String> ans = findPath(m, 4);
        System.out.println(ans);
    }

	

}
