import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class IVCalculator {

	public static void calculate(ArrayList<Boolean> parentA, ArrayList<Boolean> parentB){

		printMap("Parent A", parentA);
		printMap("Parent B", parentB);

		//Calculate all possible combo - assuming 6IV hand down;

		ArrayList<List<Boolean>> initialResults = new ArrayList<List<Boolean>>();
		recursivelyCombine(initialResults, new ArrayList<Boolean>(), parentA, parentB, 0);

		ArrayList<List<Boolean>> finalResults = new ArrayList<List<Boolean>>();



				for(List<Boolean> list : initialResults){
		
					ArrayList<List<Boolean>> resultRandomAdded = new ArrayList<List<Boolean>>();
					
					//LIST OF TRUE IS INCORRECT
					//Require to add lists with each false changed to true (only one change per list)
					recursivelyCombine(resultRandomAdded,  new ArrayList<Boolean>(), list, listOfTrue(list), 0);
		
					finalResults.addAll(resultRandomAdded);
		
				}
		
				removeDulpicates(finalResults);
		
				printResults(finalResults);


	}

	private static List<Boolean> listOfTrue(List<Boolean> list) {
		ArrayList<Boolean> trueList = new ArrayList<Boolean>();
		for(int x = 0; x < list.size(); x++){
			trueList.add(true);
		}
		return trueList;
	}

	private static void printResults(ArrayList<List<Boolean>> results) {
		for(List<Boolean> list : results){
			printMap(list);
		}
	}



	private static ArrayList<List<Boolean>> removeDulpicates(ArrayList<List<Boolean>> input){
		return new ArrayList<List<Boolean>>(new LinkedHashSet<List<Boolean>>(input));
	}

	private static void recursivelyCombine(ArrayList<List<Boolean>> resultSet, List<Boolean> current, List<Boolean> listOne, List<Boolean> listTwo, int index) {
		if (index == listOne.size()) {
			resultSet.add(current);
		} else {
			if (listOne.get(index).equals(listTwo.get(index))) {
				current.add(listOne.get(index));
				recursivelyCombine(resultSet, current, listOne, listTwo, index+1);
			} else {
				List<Boolean> temp = new ArrayList<Boolean>(current);
				temp.add(Boolean.TRUE);
				recursivelyCombine(resultSet, temp, listOne, listTwo, index+1);

				temp = new ArrayList<Boolean>(current);
				temp.add(Boolean.FALSE);
				recursivelyCombine(resultSet, temp, listOne, listTwo, index+1);
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
