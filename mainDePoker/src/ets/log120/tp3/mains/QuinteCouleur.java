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
 * @author Samuel Milette-Lacombe
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
		Denomination dernierNonJoker = null;
		
		while (it.hasNext() && quinte.size() < 5) {
			Carte carte = it.next();
			Denomination denominationCourante = carte.getDenomination();
			
			if (denominationCourante.equals(Denomination.AS))
				asPresent = true;
	
			if (quinte.size() == 0) {
				quinte.addLast(denominationCourante);
				couleurPrecedente = carte.getCouleur();
			} else {
				int precedant = Denomination.DENOMINATIONS.indexOf(quinte.getLast());
				int courant = Denomination.DENOMINATIONS.indexOf(denominationCourante);
				
				if (((precedant == courant + 1) && (couleurPrecedente.equals(CouleurCarte.JOKER) || carte.getCouleur().equals(couleurPrecedente)))
				|| ((nombreJoker-->=1))) {
					
					if (!(carte.getDenomination().equals(Denomination.JOKER)))
						dernierNonJoker = denominationCourante;
					
					quinte.addLast(denominationCourante);
					couleurPrecedente = carte.getCouleur();
				} else {
					quinte.clear();
					couleurPrecedente = carte.getCouleur();
					quinte.addLast(denominationCourante);
				}
			}
						
		}
	
		if (quinte.size() == 5
				|| (quinte.size() == 4 && quinte.getLast().equals(Denomination.DEUX) && asPresent)) {
			Denomination meilleure = Denomination.DENOMINATIONS.get(Denomination.DENOMINATIONS.indexOf(dernierNonJoker) + 4);
			contexte.setRangReconnu(new RangPokerQuinteCouleur(meilleure));
			return true;
		} else {
			return false;
		}

	}
}
