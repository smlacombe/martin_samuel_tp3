package ets.log120.tp3.mains;

public class ReqAnalyseMain {
	
	// --------------------------------------------------
	// Constructeur(s)
	// --------------------------------------------------
	
	public ReqAnalyseMain(Main main) {
		this.main = main;
	}
	
	// --------------------------------------------------
	// Accesseur(s)
	// --------------------------------------------------
	
	public Main getMain() {
		return main;
	}
	
	public RangPoker getRangReconnu() {
		return rang;
	}
	
	// --------------------------------------------------
	// Mutateur(s)
	// --------------------------------------------------
	
	public void setRangReconnu(RangPoker rang) {
		this.rang = rang;
	}
	
	// --------------------------------------------------
	// Méthodes(s)
	// --------------------------------------------------
	
	// --------------------------------------------------
	// Attribut(s)
	// --------------------------------------------------
	
	private Main main;
	private RangPoker rang;
}
