public class PercolationStats {
    private double[] thresholdEst;

    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0)
            throw new IllegalArgumentException();
        thresholdEst = new double[T];
        int openNum;

        for (int i = 0; i < T; i++) {
            Percolation perc = new Percolation(N);
            openNum = 0;
            while (!perc.percolates()) {
                while (true) {
                    int a = StdRandom.uniform(1, N + 1);
                    int b = StdRandom.uniform(1, N + 1);
                    if (!perc.isOpen(a, b)) {
                        openNum++;
                        perc.open(a, b);
                        break;
                    }
                }
            }
            thresholdEst[i] = (double) openNum / (N * N);
        }
    }

    public double mean() {
        return StdStats.mean(thresholdEst);
    }

    public double stddev() {
        return StdStats.stddev(thresholdEst);
    }

    public double confidenceLo() {
        return mean() - 1.96 * stddev() / Math.sqrt(thresholdEst.length);
    }

    public double confidenceHi() {
        return mean() + 1.96 * stddev() / Math.sqrt(thresholdEst.length);
    }

    public static void main(String[] args) {
        PercolationStats percStats = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.printf("mean                     = %f\n", percStats.mean());
        System.out.printf("stddev                   = %f\n", percStats.stddev());
        System.out.printf("95%% confidence Interval  = %f, %f\n",
                percStats.confidenceLo(), percStats.confidenceHi());
    }
}
