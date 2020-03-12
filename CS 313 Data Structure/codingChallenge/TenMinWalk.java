package codingChallenge;

public class TenMinWalk {
	public static void main (String [] args) {
		System.out.println (isValid (new char[] {'n','s','n','s','n','s','n','s','n','s'}));
		System.out.println (isValid (new char[] {'w','e','w','e','w','e','w','e','w','e','w','e'}));
		System.out.println (isValid (new char[] {'w'}));
		System.out.println (isValid (new char[] {'n','n','n','s','n','s','n','s','n','s'}));
	}
	
	public static boolean isValid (char[] walk) {
		if( walk.length==10) {
			int count = 0;
			for (char direction: walk) {
				if (direction== 'n') count+=1;
				else if (direction== 's') count-=1;
				else if (direction== 'w') count+=3;
				else count-=3;
			}
			if (count==0) return true;
		}
		return false;
	}
}
