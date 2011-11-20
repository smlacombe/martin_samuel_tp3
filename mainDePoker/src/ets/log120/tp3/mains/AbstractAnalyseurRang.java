package ets.log120.tp3.mains;

import java.util.TreeMap;

import ets.log120.tp3.cartes.Denomination;

public abstract class AbstractAnalyseurRang {
	
	// --------------------------------------------------
	// Constructeur(s)
	// --------------------------------------------------
	
	// --------------------------------------------------
	// Accesseur(s)
	// --------------------------------------------------
	
	public AbstractAnalyseurRang getSuivant() {
		return suivant;
	}
	
	// --------------------------------------------------
	// Mutateur(s)
	// --------------------------------------------------
	
	public void setSuivant(AbstractAnalyseurRang suivant) {
		this.suivant = suivant;
	}
	
	// --------------------------------------------------
	// Méthodes(s)
	// --------------------------------------------------

	protected abstract boolean reconnaitreMain(ReqAnalyseMain contexte);
	
	public void traiterDemande(ReqAnalyseMain contexte) {
		if (!reconnaitreMain(contexte) && suivant != null)
			suivant.traiterDemande(contexte);
	}
	
	public static void setValeursDenominations(TreeMap<Denomination, Integer> valeurs) {
		valeursDenominations = valeurs;
	}
	
	// --------------------------------------------------
	// Attribut(s)
	// --------------------------------------------------
	
	protected static TreeMap<Denomination, Integer> valeursDenominations;
	private AbstractAnalyseurRang suivant;
}
