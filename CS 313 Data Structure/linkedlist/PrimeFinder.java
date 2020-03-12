package linkedlist;

public class PrimeFinder extends Process {

    private int min;
    private int max;
    private int current;
    private boolean isFinished;

    /**
     * Creates a PrimeFinder object to look for primes between the min and max, inclusive
     * @param name a String to help identify the Process
     * @param min the lower bound
     * @param max the upper bound
     */
    public PrimeFinder(String name, int min, int max) {
        super(name);
        this.min = Math.max(min, 2);
        this.max = max;
        current = this.min;
        isFinished = false;
    }

    /**
     * Creates a PrimeFinder object to look for primes between 0 and max, inclusive.
     * @param name a String to help identify the Process
     * @param max the upper bound
     */
    public PrimeFinder(String name, int max) {
        super(name);
        min = 2; //smallest prime
        this.max = max;
        current = this.min;
        isFinished = false;
    }

    /** Searches for primes in the interval between current and runDuration.
     * @param runDuration how many numbers to search
     */
    public synchronized void run(int runDuration) {
        for (int i = 0; i< runDuration; i++) {
            boolean isPrime = true;
            for (int k = 2; k*k <= current; k++) {
                if (current % k == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) System.out.println(this.getName() + " found a prime: " + current);
            current++;
            if(current>max)
            {
                System.out.println(this.getName() + " has finished!");
                isFinished = true;
                break;
            }
        }
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

}