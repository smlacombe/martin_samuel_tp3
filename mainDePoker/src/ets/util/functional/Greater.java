package ets.util.functional;

public class Greater<T extends Comparable<T>>
	implements java.util.Comparator<T>{

	@Override
	public int compare(T left, T right) {
		return right.compareTo(left);
	}
}
