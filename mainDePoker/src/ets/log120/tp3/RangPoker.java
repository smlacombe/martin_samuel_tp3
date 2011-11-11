package ets.log120.tp3;

public class RangPoker
	implements Comparable<RangPoker>{

	// --------------------------------------------------
	// Constructeur(s)
	// --------------------------------------------------

	public RangPoker(int rang) {
		this.rang = rang;
	}
	
	// --------------------------------------------------
	// Accesseur(s)
	// --------------------------------------------------
	
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
