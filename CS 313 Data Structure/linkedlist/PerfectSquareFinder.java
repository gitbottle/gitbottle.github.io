package linkedlist;

public class PerfectSquareFinder extends Process {
	
	private boolean isFinished;
	private int min;
	private int max;
	private int current;
	
	public PerfectSquareFinder (String name, int min, int max) {
		super (name);
		this.min= Math.max(min, 1);// 1 is also a perfect square
		this.max= max;
		current = this.min;
		isFinished= false;
	}
	
	public synchronized void run (int runDuration) {
		for (int i = 0; i< runDuration; i++) {
            
            double sr= Math.sqrt(current);
            
            if ((sr - Math.floor(sr)) == 0) System.out.println(this.getName() + " found a perfect square: " + current);
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
