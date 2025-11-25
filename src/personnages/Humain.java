package personnages;



public class Humain {
	private String nom;
	private String boisson;
	private int argent;
	protected int nbConnaissance;
	protected Humain[] memoire = new Humain[MAX_TAILLE_MEMOIRE];

	private static final int MAX_TAILLE_MEMOIRE = 3;

	public Humain(String nom, String boisson, int argent) {
		this.nom = nom;
		this.boisson = boisson;
		this.argent = argent;
		this.nbConnaissance = 0;

	}

	public int getArgent() {
		return argent;
	}

	public String getNom() {
		return nom;
	}

	public void direBonjour() {
		parler("Bonjour ! Je m'appelle" + nom + "et j'aime boire du " + boisson);
	}

	public void boire() {
		parler("Mmmm, un bn verre de " + boisson + " ! GLOUPS !");
	}

	public void acheter(String bien, int prix) {

		if (argent < prix) {
			parler("Je n'ai plus que " + argent + "sous en poche. Je ne peux même pas m'offrir " + bien + "à" + prix
					+ " sous");
		} else {
			parler("J'ai  " + argent + "sous en poche. " + "Je vais pouvoir m'offrir " + bien + " à " + prix
					+ " sous ");
			perdreArgent(prix);
		}

	}

	protected void gagnerArgent(int gain) {
		argent += gain;
	}

	protected void perdreArgent(int perte) {
		argent -= perte;
	}

	protected void parler(String text) {
		System.out.println("(" + nom + ") - " + text);
	}

	public void faireConnaissanceAvec(Humain personne) {
		direBonjour();
		memoriser(personne);
		personne.repondre(this);
	}

	private void memoriser(Humain personne) {
		if (nbConnaissance < MAX_TAILLE_MEMOIRE) {
			nbConnaissance++;
			memoire[nbConnaissance-1] = personne;
		} else {
			for (int i = 0; i < MAX_TAILLE_MEMOIRE - 1; i++) {
				memoire[i] = memoire[i + 1];
			}
			memoire[MAX_TAILLE_MEMOIRE - 1] = personne;
		}
	}

	private void repondre(Humain personne) {
		direBonjour();
		memoriser(personne);
	}

	public void listerConnaissance() {
        StringBuilder liste = new StringBuilder();
        for (int i = 0; i < nbConnaissance; i++) {
            liste.append(memoire[i].getNom());
            if (i < nbConnaissance - 1) {
                liste.append(", ");
            }
        }
	parler("Je connais beaucoup de monde dont : " + liste);
    }

}
