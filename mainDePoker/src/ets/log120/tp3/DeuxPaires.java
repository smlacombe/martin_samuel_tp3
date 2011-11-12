package ets.log120.tp3;

public class DeuxPaires extends AbstractAnalyseurRang {
	@Override
	protected boolean reconnaitreMain(ReqAnalyseMain contexte) {
		if (Paire.getNombreDePaire(contexte.getMain()) >= 2) {
			contexte.setRangReconnu(new RangPoker(2));
			return true;
		}
		
		return false;
	}
}
