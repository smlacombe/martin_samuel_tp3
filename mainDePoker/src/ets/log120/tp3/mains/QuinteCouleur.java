package ets.log120.tp3.mains;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;

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
		TreeMap<Denomination, Integer> denominations = AnalyseurUtil.compterDenominations(contexte.getMain());
		TreeMap<CouleurCarte, ? extends Collection<Denomination>> couleurs = AnalyseurUtil.compterCouleurs(contexte.getMain());
		
		for (int i = Denomination.DENOMINATIONS.indexOf(Denomination.AS); i >= 0; --i) {
			Integer nombreJoker = denominations.get(Denomination.JOKER) == null ? 0 : denominations.get(Denomination.JOKER);
			ArrayList<CouleurCarte> couleursCommunes = new ArrayList<CouleurCarte>(couleurs.keySet());
			
			for (int j = i; j >= i - 4 && j >= -1; --j) {
				Denomination denominationCourante = (j == -1) ? Denomination.AS : Denomination.DENOMINATIONS.get(j);
				Integer nombre = denominations.get(denominationCourante);
				
				if (nombre == null) {
					if (nombreJoker-- <= 0)
						break;
					else
						continue;
				} else {
					for (int k = 0; k < couleursCommunes.size(); ++k) {
						CouleurCarte couleur = couleursCommunes.get(k);
						Collection<Denomination> denominationDeCetteCouleur = couleurs.get(couleur);
						if (!denominationDeCetteCouleur.contains(denominationCourante)) {
							couleursCommunes.remove(couleur);
							--k;
						}
					}
				}
				
				if (j == i - 4 && couleursCommunes.size() >= 1) {
					contexte.setRangReconnu(new RangPokerQuinteCouleur(Denomination.DENOMINATIONS.get(i)));
					return true;
				}
			}
		}
		
		return false;
	}
}
