
public class Percolation {
    private int n;
    private boolean[][] grid;
    private int openSites;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than 0");
        }

        this.n = n;
        this.grid = new boolean[n][n];
        this.openSites = 0;
    }

    private void validate_within_grid(int row, int col) {
        if ((row < 0 || row >= this.n) || (col < 0 || col >= this.n)) {
            throw new IllegalArgumentException("row and col must be between 0 and n");
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        this.validate_within_grid(row, col);

        this.grid[row+1][col+1] = true;
        this.openSites++;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        this.validate_within_grid(row, col);

        return this.grid[row][col];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        return this.grid[row][col];
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return this.openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return false;
    }

    // test client (optional)
    public static void main(String[] args) {
        int size = 5;

        Percolation p = new Percolation(size);

        for (int i = 0; i < size; i++) {
            p.open(0, i);
        }

        // Check that the system percolates
        if (p.percolates() != true) {
            throw new RuntimeException("Does not percolate");
        };
    }
}
