package ets.log120.tp3.mains;

public class CarteSuperieure extends AbstractAnalyseurRang {
	@Override
	protected boolean reconnaitreMain(ReqAnalyseMain contexte) {
		contexte.setRangReconnu(new RangPoker(1));
		return true;
	}
}
