package ets.log120.tp3.mains;

/**
 * Classe représentant le contexte passé à la chaîne de responsabilités.
 * @author Martin Desharnais
 */
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
	// Attribut(s)
	// --------------------------------------------------
	
	private Main main;
	private RangPoker rang;
}
