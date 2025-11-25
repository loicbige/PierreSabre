package histoire;

import personnages.Humain;
import personnages.Commercant;
import personnages.Yakuza;
import personnages.Ronin;

public class HistoireTP4 {
	public static void main(String[] args) {
		// --- Test 1- Humains ---
		System.out.println("--- Test 1- Humains ---");

		// ... (Code du test Humain déjà présent) ...
		Humain prof = new Humain("Prof", "kombucha", 54);
		prof.direBonjour();
		prof.acheter("une boisson", 12);
		prof.boire();
		prof.acheter("un jeu", 2);
		prof.acheter("un kimono", 50);

		System.out.println("------------------------\n");

		// --- Test 2- Commerçant --- [cite: 80-88]
		System.out.println("--- Test 2.1- Commerçant ---");
		Commercant marco = new Commercant("Marco", 20); // 20 sous à sa création [cite: 81]
		marco.direBonjour(); // (Marco) - Bonjour! Je m'appelle Marco et j'aime boire du thé. [cite: 85]

		int extorque = marco.seFaireExtorquer();
		// (Marco) - J'ai tout perdu! Le monde est trop injuste... [cite: 86]

		marco.recevoir(15);
		// (Marco) - 15 sous! Je te remercie généreux donateur! [cite: 87]

		marco.boire(); // (Marco) - Mmmm, un bon verre de thé ! GLOUPS! [cite: 88]

		System.out.println("------------------------\n");

		// --- Test 2.2- Yakuza --- [cite: 96-103]
		System.out.println("--- Test 2.2- Yakuza ---");
		// Yakuza à 30 sous, clan Warsong [cite: 97]
		Yakuza yakuLeNoir = new Yakuza("Yaku Le Noir", "whisky", 30, "Warsong");
		yakuLeNoir.direBonjour(); // (Yaku Le Noir) - Bonjour! Je m'appelle Yaku Le Noir et j'aime boire du
									// whisky. [cite: 98]

		// Extorsion
		// On recrée Marco avec de l'argent pour cet exemple de scénario.
		marco = new Commercant("Marco", 15); // On le met à 15 sous pour correspondre au scénario [cite: 102]

		yakuLeNoir.extorquer(marco);
		// (Yaku Le Noir) - Tiens, tiens, ne serait-ce pas un faible marchand qui passe
		// par là ? [cite: 99]
		// (Yaku Le Noir) - Marco, si tu tiens à la vie donne moi ta bourse! [cite: 100]
		// (Marco) - J'ai tout perdu! Le monde est trop injuste... [cite: 101]
		// (Yaku Le Noir) - J'ai piqué les 15 sous de Marco, ce qui me fait 45 sous dans
		// ma poche. Hi! Hi! [cite: 102]

		System.out.println("------------------------\n");

		// --- Test 2.3- Ronin --- [cite: 109-116]
		System.out.println("--- Test 2.3- Ronin ---");
		Ronin roro = new Ronin("Roro", "shochu", 60); // 60 sous à sa création [cite: 110]
		roro.direBonjour(); // (Roro) - Bonjour! Je m'appelle Roro et j'aime boire du shochu. [cite: 114]

		// On recrée Marco à 0 sous pour l'exemple de réception
		marco = new Commercant("Marco", 0);

		roro.donner(marco);
		// (Roro) - Marco prend ces 6 sous. (10% de 60) [cite: 115]
		// (Marco) - 6 sous! Je te remercie généreux donateur! [cite: 116]

		System.out.println("------------------------\n");

		// --- Test 3- Duel (Victoire du Ronin) --- [cite: 130-133]
		System.out.println("--- Test 3- Duel (Victoire du Ronin, Rép Yakuza=0, Force Ronin=2*1=2) ---");
		// Ronin roro a 60-6=54 sous, honneur=1
		// Yakuza yakuLeNoir a 45 sous, réputation=1 (après l'extorsion)

		roro.provoquer(yakuLeNoir);
		// (Roro) - Je t'ai retrouvé vermine... [cite: 131]
		// (Roro) - Je t'ai eu petit yakusa! [cite: 132]
		// (Yaku Le Noir) - J'ai perdu mon duel et mes 45 sous, snif... J'ai déshonoré
		// le clan de Warsong. [cite: 133]

		System.out.println("------------------------\n");

		// --- Test 3- Duel (Défaite du Ronin) --- [cite: 134-140]
		System.out.println("--- Test 3- Duel (Défaite du Ronin, Rép Yakuza=4, Force Ronin=2*2=4) ---");
		// Ronin roro a maintenant 54+45=99 sous, honneur=2
		// Yakuza yakuLeNoir a 0 sous, réputation=0

		// Modifier la réputation du yakuza à 4 [cite: 134]
		// Nous allons créer un nouveau Yakuza pour simuler l'initialisation modifiée
		// [cite: 134]
		Yakuza yakuLeNoir2 = new Yakuza("Yaku Le Noir", "whisky", 45, "Warsong"); // 45 sous pour la démo
		// Forcer la réputation à 4 pour le test
		// *NOTE*: L'énoncé demande de modifier l'initialisation, donc on va faire une
		// simulation rapide.
		// En l'absence de setter public pour la réputation, on simule 4
		// victoires/extorsions :
		yakuLeNoir2.gagner(0); // Rép=1
		yakuLeNoir2.gagner(0); // Rép=2
		yakuLeNoir2.gagner(0); // Rép=3
		yakuLeNoir2.gagner(0); // Rép=4

		// Ronin roro a 99 sous, honneur=2. Force = 4.
		// Yakuza yakuLeNoir2 a 45 sous, réputation=4.

		roro.provoquer(yakuLeNoir2); // Force (4) >= Rep (4) -> Victoire du Ronin

		// Ah, l'énoncé suggère une défaite. L'erreur vient de la force du Ronin.
		// On va forcer l'honneur du Ronin à 1 pour la défaite (Force=2), ou initialiser
		// le Yakuza avec une réputation > 2.
		// Pour respecter le scénario: Roro est à 99 sous, honneur=2. Force = 4.
		// YakuLeNoir est initialisé avec 4 en réputation.

		// On va initialiser Roro à 60 sous, honneur 1 pour le test de défaite [cite:
		// 110]
		Ronin roro2 = new Ronin("Roro", "shochu", 54); // 54 sous pour avoir le même scénario que l'énoncé après défaite
														// [cite: 140]

		// Le yakuza avec une réputation initialisée à 4 (simulation)
		Yakuza yakuzaDefaite = new Yakuza("Yaku Le Noir", "whisky", 54, "Warsong");
		yakuzaDefaite.gagner(0); // Rép=1
		yakuzaDefaite.gagner(0); // Rép=2
		yakuzaDefaite.gagner(0); // Rép=3
		yakuzaDefaite.gagner(0); // Rép=4

		roro2.provoquer(yakuzaDefaite); // Force (2) < Rep (4) -> Défaite du Ronin
		// (Roro) - J'ai perdu contre ce yakuza... [cite: 135]
		// (Yaku Le Noir) - Ce ronin pensait vraiment battre Yaku Le Noir du clan de
		// Warsong? [cite: 139]
		// Je l'ai dépouillé de ses 54 sous. [cite: 140]

		System.out.println("------------------------\n");
	}
}