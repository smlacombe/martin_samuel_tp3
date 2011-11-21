package ets.log120.tp3.mains;

import java.util.TreeMap;

import ets.log120.tp3.cartes.Denomination;

/**
 * Classe chargée de reconnaître une quinte.
 * 
 * Une quinte est une séquence de cinq cartes, pas toutes de la même couleur. Bien que l'as ait la
 * dénomination supérieure, il peut être utilisé pour former une séquence as-2-3-4-5. Pourtant, il
 * doit être toujours au début ou à la fin d'une séquence.
 * 
 * @author Martin Desharnais
 * @author Samuel Milette-Lacombe
 */
public class Quinte extends AbstractAnalyseurRang {
	@Override
	protected boolean reconnaitreMain(ReqAnalyseMain contexte) {
		TreeMap<Denomination, Integer> map = AnalyseurUtil.compterDenominations(contexte.getMain());
		
		for (int i = Denomination.DENOMINATIONS.indexOf(Denomination.AS); i >= 0; --i) {
			Integer nombreJoker = map.get(Denomination.JOKER) == null ? 0 : map.get(Denomination.JOKER);
			
			for (int j = i; j >= i - 4 && j >= -1; --j) {
				Integer nombre  = null;
				if (j == -1)
					nombre = map.get(Denomination.AS);
				else
					nombre = map.get(Denomination.DENOMINATIONS.get(j));
				
				if (nombre == null && nombreJoker-- <= 0)
					break;
				else if (j == i - 4) {
					contexte.setRangReconnu(new RangPokerQuinte(Denomination.DENOMINATIONS.get(i)));
					return true;
				}
			}
		}
		
		return false;
	}
}
