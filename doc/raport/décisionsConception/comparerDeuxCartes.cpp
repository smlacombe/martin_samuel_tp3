#include <iostream>

// La dénomination n'est qu'une simple énumération
enum class denomination {
	deux, trois, quatre, cinq, six, sept, huit, neuf, dix, valet, dame, roi, as
};

// La couleur n'est qu'une simple énumération
enum class couleur {
	trefle, carreau, pique, coeur
};

// La classe basic_carte utilisera DenominationTraits pour comparer ses dénominations
template <class DenominationTraits>
class basic_carte {
	public:
		basic_carte(couleur c, denomination d, DenominationTraits traits = DenominationTraits()) :
			m_couleur(c), m_denomination(d), m_traits(traits) { }

		int compareTo(basic_carte obj) const {
			// C'est m_traits qui se charge de savoir quelle dénomination est plus grande
			return m_traits.compareTo(m_denomination, obj.m_denomination);
		}

	private:
		couleur m_couleur;
		denomination m_denomination;
		DenominationTraits m_traits;
};

// --------------------------------------------------
// Implementation details
// --------------------------------------------------

// Première façon de comparer des dénominations
struct denomination_traits {
	int compareTo(const denomination& left, const denomination& right) const {
		return static_cast<int>(left) - static_cast<int>(right);
	}
};

// Seconde façon de comparer des dénominations
struct denomination_traits_2 {
	int compareTo(const denomination& left, const denomination& right) const {
		return static_cast<int>(right) - static_cast<int>(left);
	}
};

// Pour ne pas avoir à écrire le nom complet à chaque fois
typedef basic_carte<denomination_traits> carte;
typedef basic_carte<denomination_traits_2> carte_alt;

// Surcharge l'opérateur « < » pour que ce soit plus intuitif de comparer deux cartes
template <class T>
bool operator<(const basic_carte<T>& left, const basic_carte<T>& right) {
	return left.compareTo(right) < 0;
}

// --------------------------------------------------
// End implementation details
// --------------------------------------------------



int main() {
	// Avec la première façon, deux vaut moins que cinq
	carte deux(couleur::carreau, denomination::deux);
	carte cinq(couleur::carreau, denomination::cinq);

	std::cout << "deux < cinq : " << (deux < cinq ? "true" : "false") << std::endl;

	// Avec la seconde façon, deux vaut plus que cinq
	carte_alt deux_alt(couleur::carreau, denomination::deux);
	carte_alt cinq_alt(couleur::carreau, denomination::cinq);

	std::cout << "deux_alt < cinq_alt : " << (deux_alt < cinq_alt ? "true" : "false") << std::endl;
}
