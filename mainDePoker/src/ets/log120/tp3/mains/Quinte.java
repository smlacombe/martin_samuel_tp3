package ets.log120.tp3.mains;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.Denomination;

/**
 * Classe chargée de reconnaître une quinte.
 * 
 * Une quinte est une séquence de cinq cartes, pas toutes de la même couleur. Bien que l'as ait la
 * dénomination supérieure, il peut être utilisé pour former une séquence as-2-3-4-5. Pourtant, il
 * doit être toujours au début ou à la fin d'une séquence.
 * 
 * @author Martin Desharnais
 */
public class Quinte extends AbstractAnalyseurRang {
	@Override
	protected boolean reconnaitreMain(ReqAnalyseMain contexte) {
		LinkedList<Denomination> quinte = new LinkedList<Denomination>();
		boolean asPresent = false;

		Iterator<Carte> it = contexte.getMain().iterator();
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
					quinte.addLast(carte.getDenomination());
				}
			}
		}

		if (quinte.size() == 5
				|| (quinte.size() == 4 && quinte.getLast().equals(Denomination.DEUX) && asPresent)) {
			contexte.setRangReconnu(new RangPokerQuinte(quinte.getFirst()));
			return true;
		} else {
			return false;
		}
	}
}
