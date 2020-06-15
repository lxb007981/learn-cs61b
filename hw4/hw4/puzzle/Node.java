package hw4.puzzle;

public class Node {
    WorldState w;
    int moves;
    Node prev;

    Node(WorldState w, int m, Node p) {
        this.w = w;
        moves = m;
        prev = p;
    }
}
