package ets.util.functional;

/**
 * Classe permettant d'inverser l'ordre de tri de n'importe quel Comparator.
 * 
 * @author Martin Desharnais
 */
public class Greater<T extends Comparable<T>>
		implements java.util.Comparator<T> {

	@Override
	public int compare(T left, T right) {
		return right.compareTo(left);
	}
}
