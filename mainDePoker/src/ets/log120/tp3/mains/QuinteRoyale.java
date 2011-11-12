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
		CouleurCarte couleur = null;
		Denomination derniereDenomination = null;
		for(Carte carte : contexte.getMain()) {
			if (couleur == null)
				couleur = carte.getCouleur();
			else if (!carte.getCouleur().equals(couleur))
				return false;
			
			if (derniereDenomination == null) {
				if (carte.getDenomination().equals(Denomination.AS))
					derniereDenomination = carte.getDenomination();
				else
					return false;
			} else {
				int precedant = Denomination.DENOMINATIONS.indexOf(derniereDenomination);
				int courant   = Denomination.DENOMINATIONS.indexOf(carte.getDenomination());
				if (precedant != courant - 1)
					return false;
			}
		}
		contexte.setRangReconnu(new RangPoker(12));
		return true;
	}
}
