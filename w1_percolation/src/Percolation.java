public class Percolation {
    private final int N;
    private WeightedQuickUnionUF ufGrid;
    private boolean[] grid;

    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N should be larger!");
        }
        this.N = N;
        int len = N * N + 2;
        ufGrid = new WeightedQuickUnionUF(len);
        grid = new boolean[len];
        for (int i = 0; i < len; i++)
            grid[i] = false; //blocked
        grid[0] = true;
        grid[len - 1] = true;
    }

    //convert 2D indices to array index
    private int mapping(int i, int j) {
        if (i < 1 || j < 1 || i > N || j > N)
            throw new IndexOutOfBoundsException("indices out of bound!");
        return ((i - 1) * N + j);
    }

    // open a site and connected it to surrounding sites
    // need to check isOpen(i,j) first
    public void open(int i, int j) {
        int index = mapping(i, j);
        grid[index] = true;

        if (i == 1) ufGrid.union(index, 0);
        if (i == N) ufGrid.union(index, grid.length - 1);

        if (i != 1 && isOpen(i - 1, j)) ufGrid.union(index, mapping(i - 1, j));
        if (i != N && isOpen(i + 1, j)) ufGrid.union(index, mapping(i + 1, j));
        if (j != 1 && isOpen(i, j - 1)) ufGrid.union(index, mapping(i, j - 1));
        if (j != N && isOpen(i, j + 1)) ufGrid.union(index, mapping(i, j + 1));

    }

    public boolean isOpen(int i, int j) {
        return (grid[mapping(i, j)]);
    }

    public boolean isFull(int i, int j) {
        return ufGrid.connected(0, mapping(i, j));
    }

    public boolean percolates() {
//        for (int i = 1; i < this.N + 1; i++) {
//            if (ufGrid.connected(0, mapping(N, i)))
//                return true;
//        }
//        return false;
        return ufGrid.connected(0, grid.length - 1);
    }
}