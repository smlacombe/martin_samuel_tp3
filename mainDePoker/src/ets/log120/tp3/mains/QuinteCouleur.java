package ets.log120.tp3.mains;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.CouleurCarte;
import ets.log120.tp3.cartes.Denomination;

/**
 * Classe chargée de reconnaître une quinte couleur.
 * 
 * Une quinte couleur est une quinte où toutes les cartes sont de la même couleur.
 * 
 * @author Martin Desharnais
 * @see ets.log120.tp3.Quinte
 */
public class QuinteCouleur extends AbstractAnalyseurRang {
	@Override
	protected boolean reconnaitreMain(ReqAnalyseMain contexte) {
		TreeMap<Denomination, Integer> map = AnalyseurUtil.compterDenominations(contexte.getMain());
		Integer nombreJoker = map.remove(Denomination.JOKER);
		
		if (nombreJoker == null)
			nombreJoker = 0;
		
		LinkedList<Denomination> quinte = new LinkedList<Denomination>();
		boolean asPresent = false;
	
		Iterator<Carte> it = contexte.getMain().iterator();
		CouleurCarte couleurPrecedente = null;
		while (it.hasNext() && quinte.size() < 5) {
			Carte carte = it.next();
			
			if (carte.getDenomination().equals(Denomination.AS))
				asPresent = true;
	
			if (quinte.size() == 0) {
				quinte.addLast(carte.getDenomination());
				couleurPrecedente = carte.getCouleur();
			} else {
				int precedant = Denomination.DENOMINATIONS.indexOf(quinte.getLast());
				int courant = Denomination.DENOMINATIONS.indexOf(carte.getDenomination());
				
				if (((precedant == courant + 1) && (carte.getCouleur().equals(couleurPrecedente)))
				|| ((nombreJoker-->=1))) {
					quinte.addLast(carte.getDenomination());
					couleurPrecedente = carte.getCouleur();
				} else {
					quinte.clear();
					couleurPrecedente = carte.getCouleur();
					quinte.addLast(carte.getDenomination());
				}
			}
						
		}
	
		if (quinte.size() == 5
				|| (quinte.size() == 4 && quinte.getLast().equals(Denomination.DEUX) && asPresent)) {
			contexte.setRangReconnu(new RangPokerQuinteCouleur(quinte.getFirst()));
			return true;
		} else {
			return false;
		}

	}
}
