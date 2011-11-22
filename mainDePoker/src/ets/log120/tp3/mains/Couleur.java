package ets.log120.tp3.mains;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.CouleurCarte;
import ets.log120.tp3.cartes.Denomination;

/**
 * Classe chargée de reconnaître une couleur.
 * 
 * Une couleur est constitué de cinq cartes de même couleur qui ne forment pas de séquence.
 * 
 * @author Martin Desharnais
 * @author Samuel Milette-Lacombe
 */
public class Couleur extends AbstractAnalyseurRang {
	@Override
	protected boolean reconnaitreMain(ReqAnalyseMain contexte) {
		TreeMap<CouleurCarte, ArrayList<Denomination>> flushs = new TreeMap<CouleurCarte, ArrayList<Denomination>>(); 

		for (Carte carte : contexte.getMain()) {
			ArrayList<Denomination> flush = flushs.get(carte.getCouleur());
			
			if (flush == null)
				flush = new ArrayList<Denomination>();
			
			flush.add(carte.getDenomination());
			flushs.put(carte.getCouleur(), flush);
		}

		ArrayList<Denomination> meilleureFlush = null;
		int valeurMeilleureFlush = 0;
		
		for (Map.Entry<CouleurCarte, ArrayList<Denomination>> flush : flushs.entrySet()) {
			if (flush.getValue().size() == 5) {
    			int valeur = 0;
    			
    			for (Denomination d : flush.getValue())
    				valeur += Denomination.DENOMINATIONS.indexOf(d);
    			
    			if (valeur > valeurMeilleureFlush) {
    				valeurMeilleureFlush = valeur;
    				meilleureFlush = flush.getValue();
    			}
			}
		}
		
		if (meilleureFlush != null) {
			contexte.setRangReconnu(new RangPokerCouleur(meilleureFlush));
			return true;
		}
		else {
			return false;
		}
	}
}
