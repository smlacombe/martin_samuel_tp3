package ets.log120.tp3.mains;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;

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
 * @author Samuel Milette-Lacombe
 */
public class Quinte extends AbstractAnalyseurRang {
	@Override
	protected boolean reconnaitreMain(ReqAnalyseMain contexte) {
		TreeMap<Denomination, Integer> map = AnalyseurUtil.compterDenominations(contexte.getMain());
		Integer nombreJoker = map.remove(Denomination.JOKER);
		
		if (nombreJoker == null)
			nombreJoker = 0;
		
		LinkedList<Denomination> quinte = new LinkedList<Denomination>();
		boolean asPresent = false;

		Iterator<Carte> it = contexte.getMain().iterator();
		Denomination dernierNonJoker=null;
		while (it.hasNext() && quinte.size() < 5) {
			Carte carte = it.next();
			Denomination denominationCourante = carte.getDenomination();
					
			if (denominationCourante.equals(Denomination.AS))
				asPresent = true;

			if (quinte.size() == 0) {
				quinte.addLast(denominationCourante);
			} else {
				Denomination denominationPrecedente = quinte.getLast();
				if (!(denominationCourante.equals(denominationPrecedente)) || denominationCourante.equals(Denomination.JOKER) ) {
					int valeurPrecedente = Denomination.DENOMINATIONS.indexOf(denominationPrecedente);
					int valeurCourante = Denomination.DENOMINATIONS.indexOf(denominationCourante);
									
					if ((valeurPrecedente == valeurCourante  + 1) || (nombreJoker-->=1)) {
						if (!(carte.getDenomination().equals(Denomination.JOKER)))
							dernierNonJoker = denominationCourante;
						
						quinte.addLast(denominationCourante);
					} else {
						quinte.clear();
						quinte.addLast(denominationCourante);
					}
				}
			}
			
		}

		if (quinte.size() == 5
				|| (quinte.size() == 4 && quinte.getLast().equals(Denomination.DEUX) && asPresent)) {
			Denomination meilleure = Denomination.DENOMINATIONS.get(Denomination.DENOMINATIONS.indexOf(dernierNonJoker) + 4);
			contexte.setRangReconnu(new RangPokerQuinte(meilleure));
			return true;
		} else {
			return false;
		}
	}
}
