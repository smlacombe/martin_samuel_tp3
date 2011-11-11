package ets.log120.tp3;

public class Carte
	implements Comparable<Carte>{

	// --------------------------------------------------
	// Constructeur(s)
	// --------------------------------------------------

	public Carte(Denomination d, CouleurCarte c) {
		this.denomination = d;
		this.couleur = c;
	}
	
	// --------------------------------------------------
	// Accesseur(s)
	// --------------------------------------------------

	public CouleurCarte getCouleur() {
		return couleur;
	}
	
	public Denomination getDenomination() {
		return denomination;
	}
	
	@Override
	public String toString() {
		return "Carte [couleur=" + couleur + ", denomination=" + denomination + "]";
	}
	
	@Override
	public int compareTo(Carte obj) {
		if(obj == null)
				throw new NullPointerException();
		
		if (getDenomination().compareTo(obj.getDenomination()) > 0)
			return 1;
		else if (getDenomination().compareTo(obj.getDenomination()) < 0)
			return -1;
		else {
			if (getCouleur().compareTo(obj.getCouleur()) > 0)
				return 1;
			else if (getCouleur().compareTo(obj.getCouleur()) < 0)
				return -1;
			else
				return 0;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((couleur == null) ? 0 : couleur.hashCode());
		result = prime * result
				+ ((denomination == null) ? 0 : denomination.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carte other = (Carte) obj;
		if (couleur == null) {
			if (other.couleur != null)
				return false;
		} else if (!couleur.equals(other.couleur))
			return false;
		if (denomination == null) {
			if (other.denomination != null)
				return false;
		} else if (!denomination.equals(other.denomination))
			return false;
		return true;
	}
	
	// --------------------------------------------------
	// Mutateur(s)
	// --------------------------------------------------

	// --------------------------------------------------
	// Attribut(s)
	// --------------------------------------------------
	
	CouleurCarte couleur;
	Denomination denomination;
}
