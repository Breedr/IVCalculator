import java.util.ArrayList;
import java.util.List;


public class IVCalculator {

	public static void calculate(ArrayList<Boolean> parentA, ArrayList<Boolean> parentB){

		printMap("Parent A", parentA);
		printMap("Parent B", parentB);

		//Calculate all possible combo - assuming 6IV hand down;
		
		List<List<Boolean>> results = new ArrayList<List<Boolean>>();
		recursivelyCombine(results, new ArrayList<Boolean>(), parentA, parentB, 0);
		
		for(List<Boolean> l : results){
			
			printMap(l);
			
		}
		
	}
	
	private static void recursivelyCombine(List<List<Boolean>> result, List<Boolean> current, List<Boolean> in1, List<Boolean> in2, int index) {
	    if (index == in1.size()) {
	        result.add(current);
	    } else {
	        if (in1.get(index).equals(in2.get(index))) {
	           current.add(in1.get(index));
	           recursivelyCombine(result, current, in1, in2, index+1);
	        } else {
	           List<Boolean> temp = new ArrayList<Boolean>(current);
	           temp.add(Boolean.TRUE);
	           recursivelyCombine(result, temp, in1, in2, index+1);

	           temp = new ArrayList<Boolean>(current);
	           temp.add(Boolean.FALSE);
	           recursivelyCombine(result, temp, in1, in2, index+1);
	        }
	    }
	}

	protected static void printMap(List<Boolean> map) {
		printMap(null, map);
	}

	//Print IV in readable format
	//Will need to add method to Pokemon class to get all IVs in map similar to this
	protected static void printMap(String id, List<Boolean> map) {

		//Should be impossible, but throw error if IV map size is not 6 
		if(map.size() != 6)
			throw new IllegalArgumentException("IV map must contain 6 IVs - "
					+ (id == null ? "map" : id) 
					+" contained " + map.size());

		StringBuilder sb = new StringBuilder();

		if(id != null)
			sb.append(id + ": ");

		int x = 0;
		for(boolean b : map){

			sb.append(b ? "31" : "XX");
			x++;
			if(x != map.size()){	
				sb.append("/");
			}

		}

		//Replace with LOG or return as String
		System.out.println(sb.toString());

	};

}
