package code;


import java.util.LinkedList;
import java.util.Queue;

public class SnakesNLadders {

    static class Vertex {
        int cell;
        int moves;
    }

    public int findMinMoves(int[] board) {

        int size = board.length;
        boolean[] visited = new boolean[size];

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = new Vertex();
        vertex.cell = 0;
        vertex.moves = 0;
        queue.add(vertex);
        visited[0] = true;

        while (queue.isEmpty() == false) {
            //remove from front of queue
            vertex = queue.remove();
            int cellNum = vertex.cell;

            //check if reached to the end
            if (cellNum == size - 1)
                break;

            //if not reached to the end then add the reachable adjacent cells from the current cells
            //Since dice can be controlled and max value can be achieved 6
            //so from the current cell, you can reach to next 6 cells so add next 6 cells
            for (int i = cellNum + 1; i < (cellNum + 6) && i < size; i++) {
                //check if cell is already not visited
                if (visited[i] != true) {
                    //add it to the queue, update moves and mak visited
                    Vertex currentVertex = new Vertex();
                    currentVertex.moves = vertex.moves + 1; //can be reached by throwing dice one more time
                    visited[i] = true;
                    //now fill the cell can be reached (might be snake or ladder)
                    if (board[i] == -1) {
                        //means can be reached by throwing dice at that cell
                        currentVertex.cell = i;
                    } else {
                        //might be snake OR ladder at this cell 'i'
                        //then tail of the snake or top of the ladder will be achieved
                        // by reaching at cell 'i'
                        currentVertex.cell = board[i];
                    }
                    //add to queue
                    queue.add(currentVertex);
                }
            }
        }
        return vertex.moves;
    }

    public int snakesAndLadders(int[][] board) {
        int[] game = new int[board.length * board.length];
        int k = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                game[k] = board[i][j];
                k++;
            }
        }
        return  findMinMoves(game);
    }


    public static void main(String[] args) {
//        System.out.println(new SnakesNLadders().snakesAndLadders());
    }
}