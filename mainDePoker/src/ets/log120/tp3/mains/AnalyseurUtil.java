package ets.log120.tp3.mains;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;

import ets.log120.tp3.cartes.Carte;
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
	
	public static Iterator<Carte> trouverMeilleureQuinte(Iterator<Carte> begin1, Iterator<Carte> begin2) {
		
		LinkedList<Denomination> quinte = new LinkedList<Denomination>();
		boolean asPresent = false;
	
		Iterator<Carte> it = begin2;
		Iterator<Carte> itPrecedant = begin1;
		
		while (it.hasNext() && quinte.size() < 5) {
											
			Carte carte = it.next();
			
			if (carte.getDenomination().equals(Denomination.AS))
				asPresent = true;
	
			if (quinte.size() == 0) {
				quinte.addLast(carte.getDenomination());
			} else {
				int precedant = Denomination.DENOMINATIONS.indexOf(quinte.getLast());
				int courant = Denomination.DENOMINATIONS.indexOf(carte.getDenomination());
				if (precedant == courant + 1) {
					quinte.addLast(carte.getDenomination());
				} else {
					quinte.clear();
					begin1 = itPrecedant;
					quinte.addLast(carte.getDenomination());
				}
			}
		}
	
		if (quinte.size() == 5
				|| (quinte.size() == 4 && quinte.getLast().equals(Denomination.DEUX) && asPresent))
			return begin2;
		else			
			return null;
	}
}
	
