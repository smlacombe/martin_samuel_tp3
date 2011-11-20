package ets.log120.tp3.mains;

import java.util.TreeMap;

import ets.log120.tp3.cartes.Denomination;

/**
 * Classe chargée de reconnaître une quinte royale.
 * 
 * Une quinte royale est une quinte couleur dont la carte la plus haute est l'as.
 * 
 * @author Martin Desharnais
 * @author Samuel Milette-Lacombe
 * @see ets.log120.tp3.QuinteCouleur
 */
public class QuinteRoyale extends AbstractAnalyseurRang {
	@Override
	protected boolean reconnaitreMain(ReqAnalyseMain contexte) {
		if (!new QuinteCouleur().reconnaitreMain(contexte)) {
			return false;
		} else {
			TreeMap<Denomination, Integer> map = AnalyseurUtil.compterDenominations(contexte.getMain());
			
			Integer nombreJoker = map.get(Denomination.JOKER) == null ? 0 : map.get(Denomination.JOKER);
			Integer nombreAs    = map.get(Denomination.AS)    == null ? 0 : map.get(Denomination.AS);
			Integer nombreRoi   = map.get(Denomination.ROI)   == null ? 0 : map.get(Denomination.ROI);
			Integer nombreDame  = map.get(Denomination.DAME)  == null ? 0 : map.get(Denomination.DAME);
			Integer nombreValet = map.get(Denomination.VALET) == null ? 0 : map.get(Denomination.VALET);
			Integer nombreDix   = map.get(Denomination.DIX)   == null ? 0 : map.get(Denomination.DIX);
			
			if (   (nombreAs    >= 1 || nombreJoker-- >= 1)
				&& (nombreRoi   >= 1 || nombreJoker-- >= 1)
				&& (nombreDame  >= 1 || nombreJoker-- >= 1)
				&& (nombreValet >= 1 || nombreJoker-- >= 1)
				&& (nombreDix   >= 1 || nombreJoker-- >= 1)) {
				contexte.setRangReconnu(new RangPoker(11));
				return true;
			} else {
				return false;
			}
		}
	}
}