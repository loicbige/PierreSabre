package personnages;

public class ronin extends Humain {
	private int honneur = 1;

	public ronin(String nom, String boisson, int argent) {
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
}
