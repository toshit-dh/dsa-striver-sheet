package Recursion;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {

    public static List<String> solve(int[][] board){
        List<String> answer = new ArrayList<>();
        int[][] visited = new int[board.length][board[0].length];
        visited[0][0] = 1;
        recursiveSolve(0,0,"",board,visited,answer,board.length,board[0].length);
        return answer;
    }

    private static void recursiveSolve(int i,int j,String path,int[][] board,int[][] visited,List<String> answer,int n,int m){
        if (i == n-1 && j == m-1){
            answer.add(path);
            return;
        }
        if (i+1<n && board[i+1][j] != 0 && visited[i+1][j] != 1){
            visited[i][j] = 1;
            recursiveSolve(i+1,j,path+"D",board,visited,answer,n,m);
            visited[i][j] = 0;
        }
        if (j-1>=0 && board[i][j-1] != 0 && visited[i][j-1] != 1){
            visited[i][j] = 1;
            recursiveSolve(i,j-1,path+"L",board,visited,answer,n,m);
            visited[i][j] = 0;
        }
        if (j+1<m && board[i][j+1] != 0 && visited[i][j+1] != 1){
            visited[i][j] = 1;
            recursiveSolve(i,j+1,path+"R",board,visited,answer,n,m);
            visited[i][j] = 0;
        }
        if (i-1>=0 && board[i-1][j] != 0 && visited[i-1][j] != 1){
            visited[i][j] = 1;
            recursiveSolve(i-1,j,path+"U",board,visited,answer,n,m);
            visited[i][j] = 0;
        }
    }

}
