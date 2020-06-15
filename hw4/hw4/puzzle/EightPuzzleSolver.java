package hw4.puzzle;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class EightPuzzleSolver {
    /***********************************************************************
     * Test routine for your Solver class. Uncomment and run to test
     * your basic functionality.
     **********************************************************************/
    public static void main(String[] args) {
        /*In in = new In("../../input/puzzle3x3-01.txt");
        int N = in.readInt();
        int[][] tiles = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tiles[i][j] = in.readInt();
            }
        }*/
        //int[][] tiles = {{12, 4, 7, 0}, {2, 10, 8, 3}, {1, 15, 11, 14}, {9, 6, 5, 13}};
        int[][] tiles = {{8, 6, 7}, {2, 0, 4}, {3, 5, 1}};
        Board initial = new Board(tiles);
        Solver solver = new Solver(initial);
        StdOut.println("Minimum number of moves = " + solver.moves());
        Stack<WorldState> st = new Stack<>();
        for (WorldState ws : solver.solution()) {
            st.push(ws);
        }
        for (WorldState ws : st) {
            StdOut.println(ws);
        }
    }
}
