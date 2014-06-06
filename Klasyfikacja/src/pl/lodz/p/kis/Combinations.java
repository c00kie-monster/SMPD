package pl.lodz.p.kis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Combinations {
	/**
	 * Zwraca listę wektorów z kombinacjami bez powtórzeń dla zbioru liczb całkowitych od 0..n;
	 * @param n 
	 * @param d ilość elementów z zbiorze.
	 * @return listę wektorów z kombinacjami bez powtórzeń. 
	 */
	public static List<int[]> combinationsWithoutRepetitions(int n, int d) {
		int level = d;
		int[] tmp = new int[d];
		List<int[]> resultList = new ArrayList<>();
		
		for (int i = 0; i < level; i++)
			tmp[i] = i;

		while (level >= 0) {
			resultList.add(Arrays.copyOf(tmp, tmp.length));
			if (tmp[d - 1] == n)
				level--;
			else
				level = d - 1;

			if (level >= 0)
				for (int i = d - 1; i >= level; i--)
					tmp[i] = tmp[level] + i - level + 1;
		}
		return resultList;
		
	}
}
