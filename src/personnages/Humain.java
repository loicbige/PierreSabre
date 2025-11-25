package personnages;

public class Humain {
	private String nom;
	private String boisson;
	private int argent;
	
	
	public Humain(String nom, String boisson, int argent) {
		this.nom = nom;
		this.boisson = boisson;
		this.argent = argent;
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
		parler("Mmmm, un bn verre de " + boisson +" ! GLOUPS !");
	}
	
	public void acheter(String bien, int prix) {
		
		if (argent < prix) {
			parler("Je n'ai plus que " + argent +"sous en poche. Je ne peux même pas m'offrir "+ bien + "à" + prix +" sous");
		} else {
			parler("J'ai  "+argent + "sous en poche. " + "Je vais pouvoir m'offrir "+ bien + " à " + prix + " sous ");
			perdreArgent(prix);
		}
		
	}
	
	private void gagnerArgent(int gain) {
		argent += gain;
	}
	
	private void perdreArgent(int perte) {
		argent -= perte;
	}
	
	public void parler(String text) {
		System.out.println( "(" + nom + ") - " + text);
	}
}
