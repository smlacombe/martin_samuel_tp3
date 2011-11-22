package ets.log120.tp3.mains;

import java.util.Collection;
import java.util.TreeMap;
import java.util.TreeSet;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.CouleurCarte;
import ets.log120.tp3.cartes.Denomination;

public class AnalyseurUtil {

	/**
	 * Retourne une map, trié par ordre décroissant, de dénominations et du nombre d'occurences de
	 * celles-ci dans la main reçue en paramètre.
	 */
	public static TreeMap<Denomination, Integer> compterDenominations(Main main) {
		TreeMap<Denomination, Integer> map = new TreeMap<Denomination, Integer>(
				new ets.util.functional.Greater<Denomination>());

		for (Carte carte : main) {
			Integer n = map.get(carte.getDenomination());
			map.put(carte.getDenomination(), (n == null) ? 1 : n + 1);
		}

		return map;
	}

	/**
	 * Retourne une map, trié par ordre décroissant, de couleurs et de collections de dénominations
	 * de cette couleur.
	 */
	public static TreeMap<CouleurCarte, ? extends Collection<Denomination>> compterCouleurs(Main main) {
		TreeMap<CouleurCarte, TreeSet<Denomination>> map = new TreeMap<CouleurCarte, TreeSet<Denomination>>();

		for (Carte carte : main) {
			TreeSet<Denomination> denominations = map.get(carte.getCouleur());

			if (denominations == null)
				denominations = new TreeSet<Denomination>(new ets.util.functional.Greater<Denomination>());

			denominations.add(carte.getDenomination());
			map.put(carte.getCouleur(), denominations);
		}

		return map;
	}
}
