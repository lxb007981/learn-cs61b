package hw4.puzzle;

import edu.princeton.cs.algs4.MinPQ;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;


public class Solver {
    private ArrayList<WorldState> solution;
    int totalEnqueue;
    int totalMoves;
    private HashMap<WorldState, Integer> fd;
    private HashSet<WorldState> solutionSet;

    public int getTotalEnqueue() {
        return totalEnqueue;
    }

    /***
     * find estimatedDistanceToGoal() of a certain WorldState
     */

    private int getDist(WorldState o) {
        if (fd.containsKey(o)) {
            return fd.get(o);
        } else {
            int dist = o.estimatedDistanceToGoal();
            fd.put(o, dist);
            return dist;
        }
    }

    /**
     * Constructor which solves the puzzle, computing
     * everything necessary for moves() and solution() to
     * not have to solve the problem again. Solves the
     * puzzle using the A* algorithm. Assumes a solution exists.
     */
    public Solver(WorldState initial) {
        solutionSet = new HashSet<>();
        fd = new HashMap<>();
        totalEnqueue = 0;
        Node initialNode = new Node(initial, 0, null);
        Comparator<Node> cmp = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.moves + getDist(o1.w) < o2.moves + getDist(o2.w)) {
                    return -1;
                } else if (o1.moves + getDist(o1.w) == o2.moves + getDist(o2.w)) {
                    return 0;
                } else {
                    return 1;
                }
            }
        };

        MinPQ<Node> heap = new MinPQ<>(cmp);
        solution = new ArrayList<WorldState>(50);
        heap.insert(initialNode);
        while (!heap.isEmpty()) {
            Node best = heap.delMin();
            //solutionSet.add(best.w);
            if (best.w.isGoal()) {
                totalMoves = best.moves;
                Node working = best;
                while (working != null) {
                    solution.add(working.w);
                    working = working.prev;
                }
                return;
            }
            for (WorldState e : best.w.neighbors()) {
                Node n = new Node(e, best.moves + 1, best);
                if (best.prev != null && best.prev.w.equals(e)/*solutionSet.contains(e)*/) {
                    continue;
                } else {
                    heap.insert(n);
                    totalEnqueue += 1;
                }

            }
        }

    }

    /**
     * Returns the minimum number of moves to solve the puzzle starting
     * at the initial WorldState.
     */

    public int moves() {
        return totalMoves;
    }

    /**
     * Returns a sequence of WorldStates from the initial WorldState
     * to the solution.
     */
    public Iterable<WorldState> solution() {
        return solution;
    }
}
