package ets.log120.tp3.mains;

public class CarteSuperieure extends AbstractAnalyseurRang {
	@Override
	protected boolean reconnaitreMain(ReqAnalyseMain contexte) {
		contexte.setRangReconnu(new RangPokerCarteSuperieure(contexte.getMain().first().getDenomination()));
		return true;
	}
}
