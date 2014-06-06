package pl.lodz.p.kis;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ForwardSelector {
	public static List<int[]> generate(int[] currentIndices, Set<Integer> unusedIndices) {
		List<int[]> result = new ArrayList<>();
		
		for (int i : unusedIndices) {
			int[] v = Arrays.copyOf(currentIndices, currentIndices.length + 1);
			v[currentIndices.length] = i;
			result.add(v);
		}
		
		return result;
	}
	
	public static void main(String[] params) {
		ForwardSelector tree = new ForwardSelector();
		int[] c = {};
		Set<Integer> s = new HashSet<>();
		s.add(3);
		s.add(4);
		
		for (int[] d : tree.generate(c, s)) {
			System.out.println(Arrays.toString(d));
		}
	}
}
