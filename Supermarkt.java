package Klasvoorbeelden;
import java.util.Scanner;

public class Supermarkt {
	public static void main(String[] args) {
		Persoon persoon = new Persoon();
		persoon.naam = "Frits";
		Winkel winkel = new Winkel();
		winkel.winkelnaam = "Edah";
		
		winkel.product1.prijs = 20;
		winkel.product2.prijs = 10;
		winkel.product3.prijs = 5;
		
		System.out.println(persoon.dePortemonee); //refereren naar object dePortemonnee in object persoon
		persoon.dePortemonee.geldhoeveelheid = 60;
		
		System.out.println(persoon.dePortemonee.geldhoeveelheid); //print hoeveelheid geld in object dePortemonee uit
		persoon.getInfo(); //voert methode getInfo uit uit class Persoon met object persoon
		System.out.println("De winkel is " +winkel.winkelnaam);
		
		berekenen (winkel, persoon);
		persoon.getInfo();
		
	}
	static void berekenen (Winkel w1, Persoon p1) {
		boolean doorgaan = true;

		while (doorgaan) {
			Scanner scproductkeuze = new Scanner(System.in);
			System.out.println("Welk product wil je kopen? 1, 2 of 3?");
			int ikkies = scproductkeuze.nextInt();
			int koopproduct = 0;
			switch (ikkies) {
				case 1: koopproduct = w1.product1.prijs;
					break;
				case 2: koopproduct = w1.product2.prijs;
					break;
				case 3: koopproduct = w1.product3.prijs;
					break;
			}		
			int nieuwbedrag = p1.dePortemonee.geldhoeveelheid - koopproduct; //trekken product.prijs af van de geldhoeveelheid
			if (nieuwbedrag >= 0) {
				p1.dePortemonee.geldhoeveelheid = nieuwbedrag;
			}
			System.out.println("Je hebt nu " + p1.dePortemonee.geldhoeveelheid + "in je portemonnee");
				
			if (nieuwbedrag > 0) {
				System.out.println("Wil je nog wat kopen? Zeg 'nee' als je klaar bent.");
				Scanner blijfkopen = new Scanner(System.in);
				String kopen = blijfkopen.nextLine();
				if(kopen.equals("nee")) {
					doorgaan = false;
				}
			}
		}
		
	}
}
class Persoon{
	String naam;
	Portemonee dePortemonee = new Portemonee(); //maken
	void getInfo() {
		System.out.println("Mijn naam is " + naam + " en ik heb " + dePortemonee.geldhoeveelheid + "euro"); //normaal <persoon.dePo|lheid>, hoeft nu alleen geen persoon want zit al in class
	}
}
class Portemonee{
	int geldhoeveelheid;
}
class Winkel{
	String winkelnaam;
	Product product1 = new Product();//nu maken we een object product uit class Product binnen de class Winkel
	Product product2 = new Product();
	Product product3 = new Product();
}

class Product{
	int prijs;
}