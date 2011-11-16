package ets.log120.tp3.mains;

import java.util.Map;
import java.util.TreeMap;

import ets.log120.tp3.cartes.Denomination;

/**
 * Classe chargée de reconnaître dans une main, deux paires distinctes
 * 
 * Exemple de deux paires: deux cinq et deux valets.
 * @author Samuel Milette Lacombe
 */
public class DeuxPaires extends AbstractAnalyseurRang {
	@Override
	protected boolean reconnaitreMain(ReqAnalyseMain contexte) {
		TreeMap<Denomination, Integer> map = Paire.compterDenominations(contexte.getMain());
		Denomination meilleurePaire = null;
		Denomination autrePaire = null;
		Denomination kicker = null;
		
		for (Map.Entry<Denomination, Integer> entry : map.entrySet()) {
			if (meilleurePaire == null && entry.getValue() >= 2)
				meilleurePaire = entry.getKey();
			else if (autrePaire == null && entry.getValue() >= 2)
				autrePaire = entry.getKey();
			else if (kicker == null)
				kicker = entry.getKey();
			
			if (meilleurePaire != null && autrePaire != null && kicker != null) {
				contexte.setRangReconnu(new RangPokerDeuxPaires(meilleurePaire, autrePaire, kicker));
				return true;
			}
		}
		
		return false;
	}
}
