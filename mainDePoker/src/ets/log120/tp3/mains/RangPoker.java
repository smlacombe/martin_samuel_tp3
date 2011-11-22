package ets.log120.tp3.mains;

/**
 * Classe représentant un rang de poker.
 * 
 * @author Martin Desharnais
 */
public class RangPoker
	implements Comparable<RangPoker>{

	// --------------------------------------------------
	// Constructeur(s)
	// --------------------------------------------------

	/**
	 * Construit un rang de poker à partir de la valeur de son rang.
	 * @param rang
	 */
	public RangPoker(int rang) {
		this.rang = rang;
	}
	
	// --------------------------------------------------
	// Accesseur(s)
	// --------------------------------------------------
	
	/**
	 * Retourne la valeur du rang.
	 */
	public int getRang() {
		return rang;
	}
	
	@Override
	public int compareTo(RangPoker obj) {
		return rang - obj.getRang();
	}
	
	// --------------------------------------------------
	// Attribut(s)
	// --------------------------------------------------
	
	private int rang;
}
