package ets.log120.tp3;

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
				assert valeursDenominations != null;
				int valeurPrecedante = valeursDenominations.get(derniereDenomination);
				int valeurCourante   = valeursDenominations.get(carte.getDenomination());
				if (!(valeurPrecedante == valeurCourante - 1))
					return false;
			}
		}
		return true;
	}

}
