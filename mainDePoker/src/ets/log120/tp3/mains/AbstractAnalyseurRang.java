package ets.log120.tp3.mains;

/**
 * Classe de base de la chaîne de responsabilités.
 * 
 * Tous les maillons de la chaîne doivent hériter de cette classe.
 * 
 * @author Martin Desharnais
 */
public abstract class AbstractAnalyseurRang {

	// --------------------------------------------------
	// Accesseur(s)
	// --------------------------------------------------

	/**
	 * Retourne le maillon suivant de la chaîne.
	 */
	public AbstractAnalyseurRang getSuivant() {
		return suivant;
	}

	// --------------------------------------------------
	// Mutateur(s)
	// --------------------------------------------------

	/**
	 * Défini le maillon suivant de la chaîne.
	 */
	public void setSuivant(AbstractAnalyseurRang suivant) {
		this.suivant = suivant;
	}

	// --------------------------------------------------
	// Méthodes(s)
	// --------------------------------------------------

	/**
	 * Analyse la main et, si un rang est trouvé, défini le rang de poker correspondant dans le
	 * contexte.
	 */
	protected abstract boolean reconnaitreMain(ReqAnalyseMain contexte);

	/**
	 * Parcour la chaîne de responsabilité pour trouver le meilleure rang de poker possible.
	 */
	public boolean traiterDemande(ReqAnalyseMain contexte) {
		if (reconnaitreMain(contexte))
			return true;
		else if (suivant != null)
			return suivant.traiterDemande(contexte);
		else
			return false;
	}

	// --------------------------------------------------
	// Attribut(s)
	// --------------------------------------------------

	private AbstractAnalyseurRang suivant;
}
