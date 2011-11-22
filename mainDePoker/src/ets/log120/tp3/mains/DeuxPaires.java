package ets.log120.tp3.mains;

import java.util.Map;
import java.util.TreeMap;

import ets.log120.tp3.cartes.Denomination;

/**
 * Classe chargée de reconnaître dans une main, deux paires distinctes
 * 
 * Exemple de deux paires: deux cinq et deux valets.
 * 
 * @author Martin Desharnais
 * @author Samuel Milette-Lacombe
 */
public class DeuxPaires extends AbstractAnalyseurRang {
	@Override
	protected boolean reconnaitreMain(ReqAnalyseMain contexte) {
		TreeMap<Denomination, Integer> map = AnalyseurUtil.compterDenominations(contexte.getMain());
		Denomination meilleurePaire = null;
		Denomination autrePaire = null;
		Denomination kicker = null;
		
		Integer nombreJoker = map.remove(Denomination.JOKER);
		if (nombreJoker == null)
			nombreJoker = 0;
		
		for (Map.Entry<Denomination, Integer> entry : map.entrySet()) {
			if (meilleurePaire == null && (entry.getValue() >= 2
					|| (entry.getValue() == 1 && nombreJoker-- >= 1)))
				meilleurePaire = entry.getKey();
			else if (autrePaire == null && (entry.getValue() >= 2
					|| (entry.getValue() == 1 && nombreJoker-- >= 1)))
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
