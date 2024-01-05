import java.util.Arrays;
import java.util.Scanner;
public class WordSearch {
	
	public static boolean  helper(char[][] board, int[][] visited,String word, String path, int x, int y){
        //'path' stores letters traversed so far. 
        //'x' and 'y' stores current position of traversal
        // visited stores positions which has been already traversed
        if(path.equals(word))
        {
            visited[x][y]=0;
            return true;
        }
            
        if(path == word){
            return false;
        }

        int n = board.length, m = board[0].length;
        boolean ans = false;
        char target = word.charAt(path.length());
        //down
        if(!ans && x+1<n && visited[x+1][y]!=1 && board[x+1][y]==target){
            visited[x+1][y]=1;
            ans = helper(board,visited,word,path+target,x+1,y);
        }
        //left
        if(!ans && y-1>=0 && visited[x][y-1]!=1 && board[x][y-1]==target){
            visited[x][y-1]=1;
            ans = helper(board,visited,word,path+target,x,y-1);
        }
        //right
        if(!ans && y+1<m && visited[x][y+1]!=1 && board[x][y+1]==target){
            visited[x][y+1]=1;
            ans = helper(board,visited,word,path+target,x,y+1);
        }
        //up
        if(!ans && x-1>=0 && visited[x-1][y]!=1 && board[x-1][y]==target){
            visited[x-1][y]=1;
            ans = helper(board,visited,word,path+target,x-1,y);
        }
        visited[x][y]=0;
        return ans;
    }
    public static boolean  exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        int[][] visited = new int[n][m];
        for(int i =0;i<n; i++){
            Arrays.fill(visited[i],0);
        }
        String path = ""+word.charAt(0);    

        char target = word.charAt(0);

        //finding starting position
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==target){
                    visited[i][j]=1;
                    boolean ans = helper(board,visited,word,path,i,j);
                    if(ans == true)
                        return ans;
                }
                    
            }
        }
        return false;
    }
    // to understand this solution completely, please see 'rat in the maze' video by LOVE BABBAR in backtracking

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		
		
//		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		char[][] board = new char[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0; j<m; j++) {
				board[i][j] = s.next().charAt(0);
			}
		}
		
		System.out.println(exist(board,"AAB"));

	}

}
