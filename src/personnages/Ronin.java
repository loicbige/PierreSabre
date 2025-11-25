package personnages;

public class Ronin extends Humain {
	private int honneur = 1;

	public Ronin(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
	}
	
	public void donner(Commercant beneficiaire) {
		
		int don = (int)(getArgent()*0.1);
		
		if (don > 0) {
			parler(beneficiaire.getNom() + " prend ces " + don + " sous.");
			perdreArgent(don);
			beneficiaire.recevoir(don);
		} else {
			parler("Je n'ai pas assez d'argent pour faire un don.");
		}
	
	}
	public void provoquer(Yakuza adversaire) {
		int forceRonin = 2*honneur;
		
		if (forceRonin >= adversaire.getReputation()) {
			int argentGagne = adversaire.perdre();
			gagnerArgent(argentGagne);
			honneur++;
			parler("Je t'ai eu petit yakusa!");
		} else {
			perdreArgent(getArgent());
			adversaire.gagner(getArgent());
			honneur--;
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
		}
	}
}
