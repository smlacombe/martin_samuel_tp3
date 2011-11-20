/*
 * Pour compiler sous UNIX : g++ -std=c++0x trouverMeilleureQuinte.cpp
 */

#include <iostream>
#include <iomanip>
#include <vector>

template <class Iterator>
Iterator trouverMeilleureQuinte(Iterator begin, Iterator end) {
	std::vector<int> quinte; // contiendra notre quinte « potentielle »
	quinte.reserve(5);       // sera plus performant

	Iterator it = begin;     // nous utiliserons it pour nous déplacer
	                         // et begin pour sauvegarder le début de la quinte

	while (it != end && quinte.size() < 5) {
		if (quinte.empty()) {                  // nous commençons à chercher une quinte
			quinte.push_back(*it);
			begin = it;
		} else if (quinte.back() == *it + 1) { // la carte courante a bien la dénomination qui suit la dernière
			quinte.push_back(*it);
		} else {                               // la carte courante a une dénomination qui ne suit pas la dernière
			quinte.clear();                    // nous recommencons à chercher une nouvelle quinte
			quinte.push_back(*it);
			begin = it;
		}
		++it; // on se déplace vers la carte suivante
	}

	if (quinte.size() == 5)
		return begin; // begin pointe sur la première carte de la meilleure quinte
	else
		return end;   // équivalent à retourner un itérateur null en java
}

int main() {
	std::vector<int> main = { 13, 12, 11, 10, 9, 7, 6, 5, 4, 3, 2 };

	// Trouve la meilleure quinte
	auto quinte = trouverMeilleureQuinte(main.begin(), main.end());
	if(quinte != main.end())
		std::cout << "Début de la meilleure quinte : " << *quinte << std::endl;
	else
		std::cout << "Aucune quinte trouvée" << std::endl;

	std::cout << std::endl;

	// Parcour toute les quintes (pour vérifier leur couleur, qu'elles commencent par un as, etc.)
	auto begin = main.begin();
	while ((begin = trouverMeilleureQuinte(begin, main.end())) != main.end()) {
		for (int i = 0; i < 5; ++i, ++begin)                  // affiche toutes les quintes trouvées
			std::cout << std::left << std::setw(3) << *begin; // de la meilleure à la moins bonne
		std::cout << std::endl;
	}
}
