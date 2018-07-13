package Klasvoorbeelden;
import java.util.Scanner;

public class MMA {
	public static void main (String[] args) {
		System.out.println("Welkom bij MMA! Welke speler is de 1e speler?");
		Scanner scInput = new Scanner (System.in);
		String speler1 = scInput.nextLine();
		System.out.println("Welke de 2e?");
		String speler2 = scInput.nextLine();
		
		Strijder strijder1 = new Strijder("Subzero", 124); //Verwijst naar (String deNaam, int hp) in constructor van Strijder
		Strijder strijder2 = new Strijder("Raiden", 115);
		Strijder strijder3 = new Strijder("Scorpion", 100);
		Strijder strijder4 = new Strijder("Gitana", 150);
		System.out.println(strijder1);
		System.out.println(strijder2);
		strijder1.introduceren();
		strijder2.introduceren();
		strijder1.slaan(strijder2); //geeft nu aan methode 'slaan' de parameter strijder2 mee in 'geslagenstrijder'
		for (int i = 0; i < 10; i++) {
			strijder1.slaan(strijder2);
		}
		for (int i = 0; i < 10; i++) {
			strijder3.slaan(strijder4);
		}
		for (int i = 0; i < 10; i++) {
			strijder3.slaan(strijder1);
		}
	}
}
class Strijder{
	int hp;
	boolean winnaar;
	String naam;
	Strijder(String deNaam, int hp){
		naam = deNaam;
		this.hp = hp;
	}
	void introduceren() {
		System.out.println("Hoi ik ben " +naam +" en ik heb "+hp +"hp. Winnaar: " + winnaar);
	}
	void slaan (Strijder geslagenStrijder) {
		if(geslagenStrijder.hp > 0) {
			System.out.println(naam + " slaat " + geslagenStrijder.naam);
	        geslagenStrijder.hp -= 20;
	        if(geslagenStrijder.hp <= 10) {
	            System.out.println("FINISH HIM");
	        }
			if (geslagenStrijder.hp < 0){ // geef je aan dat het om de hp van geslagenstrijder gaan, niet van degene die slaat
				geslagenStrijder.doodgaan();
				System.out.println(naam +" heeft gewonnen");
				winnaar = true;
			}	
		}	
	}
	void doodgaan() {
		System.out.println(naam + "zegt auw");
	}
}
	