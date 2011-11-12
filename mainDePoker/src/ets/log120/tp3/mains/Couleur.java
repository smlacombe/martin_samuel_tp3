package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.CouleurCarte;

/**
 * Classe chargée de reconnaître une couleur.
 * 
 * Une couleur est constitué de cinq cartes de même couleur qui ne forment pas de séquence.
 * 
 * @author Martin Desharnais
 */
public class Couleur extends AbstractAnalyseurRang {
	@Override
	protected boolean reconnaitreMain(ReqAnalyseMain contexte) {
		CouleurCarte couleur = null;
		for(Carte carte : contexte.getMain()) {
			if (couleur == null)
				couleur = carte.getCouleur();
			else if (!carte.getCouleur().equals(couleur))
				return false;
		}
		
		contexte.setRangReconnu(new RangPoker(6));
		return true;
	}
}
