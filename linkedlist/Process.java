package linkedlist;

public abstract class Process {
    //to help identify the thread, similar to Java's Thread class
    private String name;

    //flag to let calling method know this thread has completed it's task
    public abstract boolean isFinished();

    /** a simulation of running a thread for a certain number of operations
     *intended to simulate running a thread for a given amount of time
     */
    public abstract void run(int runDuration);

    public Process(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
