import java.util.ArrayList;


public class Main {

	private static ArrayList<Boolean> parentA;
	private static ArrayList<Boolean> parentB;
	
	public static void main(String[] args) {
		
		parentA = new ArrayList<Boolean>();
		parentB = new ArrayList<Boolean>();
		
		generateParentA();
		generateParentB();
		
		IVCalculator.calculate(parentA, parentB);

	}

	private static void generateParentB() {
		parentB.add(true);
		parentB.add(false);
		parentB.add(false);
		parentB.add(true);
		parentB.add(true);
		parentB.add(true);
	}

	private static void generateParentA() {
		parentA.add(true);
		parentA.add(true);
		parentA.add(false);
		parentA.add(true);
		parentA.add(false);
		parentA.add(false);
		
	}

}
