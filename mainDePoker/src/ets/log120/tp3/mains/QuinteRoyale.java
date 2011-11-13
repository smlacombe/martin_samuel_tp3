package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.CouleurCarte;
import ets.log120.tp3.cartes.Denomination;

/**
 * Classe chargée de reconnaître une quinte royale.
 * 
 * Une quinte royale est une quinte couleur dont la carte la plus haute est l'as.
 * 
 * @author Martin Desharnais
 * @see ets.log120.tp3.QuinteCouleur
 */
public class QuinteRoyale extends AbstractAnalyseurRang {
	@Override
	protected boolean reconnaitreMain(ReqAnalyseMain contexte) {
		QuinteCouleur quinteCouleur = new QuinteCouleur();
		if (!quinteCouleur.reconnaitreMain(contexte))
			return false;
		
		if (!contexte.getMain().first().getDenomination().equals(Denomination.AS))
			return false;
		
		contexte.setRangReconnu(new RangPoker(12));
		return true;
	}
}
