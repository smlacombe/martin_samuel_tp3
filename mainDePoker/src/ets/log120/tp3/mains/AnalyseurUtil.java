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

	public static Main retirerJoker(Main main) {
		main.remove(Carte.JOKER);
		return main;
	}
	
	public static Denomination trouverMeilleureDenominationQuinte(LinkedList<Denomination> quinte, Main main) {
		TreeMap<Denomination, Integer> map = AnalyseurUtil.compterDenominations(main);
		Integer nombreJoker = map.remove(Denomination.JOKER);
				
		for (int i=0; i< nombreJoker;i++) {
			quinte.remove(Denomination.JOKER);
		}

		Iterator<Denomination> it  = quinte.iterator();
		Denomination denominationPrecedente;
		Denomination denominationCourante;
		int valDenominationCourante=0;
		int valDenominationPrecedente=0;
		int ecartAvecPrecedent=0;
		int positionCourante=1;
		
		while (it.hasNext() && quinte.size() <= 5) {
			denominationCourante = it.next();
			valDenominationCourante = Denomination.DENOMINATIONS.indexOf(denominationCourante);
		
			if (!(valDenominationPrecedente==0)) {
				ecartAvecPrecedent = valDenominationPrecedente - valDenominationCourante;
				//insérer ecartAvecPrecedent element décroissant
				for (int i=1; i < ecartAvecPrecedent;i++) {
					//quinte.add(positionCourante-1, Denomination.DENOMINATIONS.get(valDenominationPrecedente-i));
					nombreJoker--;
				}
			}
			
			denominationPrecedente = denominationCourante;
			valDenominationPrecedente = valDenominationCourante;
			positionCourante++;
		}
		
		int valMeilleureCarte = Denomination.DENOMINATIONS.indexOf(quinte.getFirst()) + nombreJoker;
		
		return Denomination.DENOMINATIONS.get(valMeilleureCarte);
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
	
