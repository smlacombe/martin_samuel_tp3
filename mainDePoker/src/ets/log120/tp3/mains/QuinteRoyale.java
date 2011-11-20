package ets.log120.tp3.mains;

import java.util.Iterator;

import ets.log120.tp3.cartes.Carte;
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
		QuinteCouleur quinteCouleur = new QuinteCouleur();
		boolean rangReconnu = quinteCouleur.reconnaitreMain(contexte);
		Iterator<Carte> it = contexte.getMain().iterator();
	
		Denomination carteAs =  it.next().getDenomination();
		Denomination carteRoi =  it.next().getDenomination();
		Denomination carteDame =  it.next().getDenomination();
		Denomination carteValet =  it.next().getDenomination();
		Denomination carteDix =  it.next().getDenomination();
		
		if ((rangReconnu) &&
		(carteDix.equals(Denomination.DIX) || carteDix.equals(Denomination.JOKER)) &&
		(carteValet.equals(Denomination.VALET) || carteValet.equals(Denomination.JOKER)) &&
		(carteDame.equals(Denomination.DAME) || carteDame.equals(Denomination.JOKER)) &&
		(carteRoi.equals(Denomination.ROI) || carteRoi.equals(Denomination.JOKER)) &&
		(carteAs.equals(Denomination.AS) || carteAs.equals(Denomination.JOKER)))
		{
			contexte.setRangReconnu(new RangPoker(11));
			return true;
		}
	
		return false;
	}
}