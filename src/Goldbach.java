//public final class dwite200611p5 extends DwiteSolution {
//
//    public static void main(String[] args) {
//        new dwite200611p5().run("DATA51.txt", "OUT51.txt");
//    }
//
//
//    private static boolean[] isPrime;
//
//    static {
//        isPrime = DwiteAlgorithm.sievePrimes(999999);
//        isPrime[2] = false;  // For the purposes of this problem
//    }
//
//
//    protected void runOnce() {
//        int n = io.readIntLine();
//        io.printf("%d=%s%n", n, solve(n));
//    }
//
//
//    private static String solve(int n) {
//        if (n % 2 == 0)
//            throw new IllegalArgumentException("Not applicable to even numbers");
//        if (n <= 7)
//            throw new IllegalArgumentException("Not applicable for numbers 7 or less");
//        return solve(n, 3, Integer.MAX_VALUE);
//    }
//
//
//    private static String solve(int n, int terms, int max) {
//        if (n > max)
//            return null;
//        else if (terms == 1) {
//            if (isPrime[n])
//                return Integer.toString(n);
//            else
//                return null;
//        } else {
//            for (int i = Math.min(n, max), end = (n + terms - 1) / terms; i >= end; i--) {
//                if (!isPrime[i])
//                    continue;
//                String temp = solve(n - i, terms - 1, i);
//                if (temp != null)
//                    return String.format("%d+%s", i, temp);
//            }
//            return null;
//        }
//    }
//
//}
//abstract class DwiteSolution {
//
//    // The I/O object, presented as a field for convenience.
//    protected DwiteIo io;
//
//
//
//    // The constructor with nothing to initalize.
//    public DwiteSolution() {}
//
//
//
//    // Entry point
//    public void run(String inFilename, String outFilename) {
//        run(new DwiteIo(inFilename, outFilename));
//    }
//
//    // Entry point
//    public void run(DwiteIo io) {
//        this.io = io;
//        run();
//    }
//
//
//	/*
//	 * For each DWITE solution, at least one of run() or runOnce() needs to be overridden.
//	 * By default, run() calls runOnce() 5 times. But if run() is overridden,
//	 * then runOnce() does not necessarily need to be overridden or even used.
//	 */
//
//    protected void run() {
//        for (int i = 0; i < 5; i++)
//            runOnce();
//    }
//
//
//    protected void runOnce() {}
//
//}