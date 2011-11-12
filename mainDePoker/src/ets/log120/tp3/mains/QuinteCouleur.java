package ets.log120.tp3.mains;

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
		Quinte quinte = new Quinte();
		if (!quinte.reconnaitreMain(contexte))
			return false;
		
		Couleur couleur = new Couleur();
		if (!couleur.reconnaitreMain(contexte))
			return false;
		
		contexte.setRangReconnu(new RangPoker(9));
		return true;
	}
}
