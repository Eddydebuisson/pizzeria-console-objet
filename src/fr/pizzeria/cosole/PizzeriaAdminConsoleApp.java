package fr.pizzeria.cosole;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static Pizza[] listepizza = new Pizza[100];
	public static Scanner sc = new Scanner(System.in);

	/**
	 * Initialisation des pizzas.
	 */
	public static void initListe() {

		listepizza[0] = new Pizza ( 0, "PEP", "Pépéroni", 12.50 );
		listepizza[1] = new Pizza ( 1, "MAR", "Margherita", 14.00 );
		listepizza[2] = new Pizza ( 2, "REI", "La Reine", 11.50 );
		listepizza[3] = new Pizza ( 3, "FRO", "La 4 fromages", 12.00 );
		listepizza[4] = new Pizza ( 4, "CAN", "La cannibale", 12.50 );
		listepizza[5] = new Pizza ( 5, "SAV", "La savoyarde", 13.00 );
		listepizza[6] = new Pizza ( 6, "ORI", "L'orientale", 13.50 );
		listepizza[7] = new Pizza ( 7, "IND", "L'indienne", 14.00 );
	}

	/**
	 * Affiche la liste de toutes les pizzas actuels.
	 * 
	 * @param a
	 */
	public static void listeDesPizzas(Pizza[] a) {
		int i = 0;
		for (Pizza s : a) {
			if (s != null ) {
				System.out.println(a[i].getCode() + "->" + a[i].getNom() + " (" + a[i].getPrix() + ")");
				i++;
			}
		}

	}

	/**
	 * Permet l'ajout d'une nouvelle Pizza.
	 * 
	 * @param a
	 */
	public static void ajoutPizza(Pizza[] a) {
		System.out.println("Tapez 99 pour annuler");
		System.out.println("Veuillez saisir le code");
		String code = sc.next();
		if (!code.equals("99")) {
			System.out.println("Veuillez saisir le nom (sans espace)");
			String nom = sc.next();
			System.out.println("Veuillez saisir le prix");
			String prix = sc.next();
			int i = 0;
			for (Pizza s : a) {
				if (s != null ) {
					i++;
				}
			}
			a[i] = new Pizza ( i, code, nom, Double.parseDouble(prix) );
		}
	}

	/**
	 * Permet la modification d'une pizza et affiche une erreur si la pizza
	 * n'existe pas.
	 * 
	 * @param a
	 * @param b
	 */
	public static void modifPizza(Pizza[] a, String b) {
		System.out.println("Tapez 99 pour annuler");
		System.out.println("Veuillez saisir le code");
		String code = sc.next();
		if (!code.equals("99")) {
			System.out.println("Veuillez saisir le nom (sans espace)");
			String nom = sc.next();
			System.out.println("Veuillez saisir le prix");
			String prix = sc.next();
			int i = 0;
			while (!a[i].getCode().equals(b)) {

				i++;

			}
			if (i != 100) {
				a[i] = new Pizza( i, code, nom, Double.parseDouble(prix));
			} else {
				System.out.println("404 PIZZA NOT FOUND");
			}

		}
	}

	/**
	 * Affiche en premiers les pizzas actuel et demande ensuite la pizza à
	 * modifier.
	 * 
	 * @param a
	 */
	public static void miseAjourPizza(Pizza[] a) {

		listeDesPizzas(a);
		System.out.println("Veuillez choisir la pizzza à modifier");
		String pizza = sc.next();
		modifPizza(a, pizza);

	}

	/**
	 * Permet de retirer une pizza du menu
	 * 
	 * @param a
	 */
	public static void supprimePizza(Pizza[] a) {
		listeDesPizzas(a);
		System.out.println("Tapez 99 pour annuler");
		System.out.println("Veuillez choisir la pizzza à modifier");
		String pizza = sc.next();
		if (!pizza.equals("99")) {
			int i = 0;
			while (!a[i].getCode().equals(pizza)) {
				i++;
			}

			while (a[i] != null ) {
				if(a[i+1] != null){
				a[i].setId(a[i+1].getId());;
				a[i].setCode(a[i+1].getCode());;
				a[i].setNom(a[i+1].getNom());;
				a[i].setPrix(a[i+1].getPrix());;
				}else{
					a[i]=null;
				}
				i++;
			}
		}
	}

	public static void main(String[] args) {

		initListe();
		int reponse = -1;
		do {
			System.out.println(
					"***** Pizzeria Administration ***** \n 1. Lister les pizza \n 2.Ajouter une nouvelle pizza \n 3.Mettre à jour une pizza \n 4.Supprimmer une pizza \n 99.Sortir");
			reponse = sc.nextInt();
			switch (reponse) {

			case 1:
				System.out.println("Liste des pizzas");
				listeDesPizzas(listepizza);
				break;

			case 2:
				System.out.println("Ajout d'une nouvelle pizza");
				ajoutPizza(listepizza);
				break;
			case 3:
				System.out.println("Mise à jour d'une pizza");
				miseAjourPizza(listepizza);
				break;
			case 4:
				System.out.println("Suppression d'une pizza");
				supprimePizza(listepizza);
				break;
			case 99:
				System.out.println("Aurevoir =( ");
				break;
			}
		} while (reponse != 99);

	}

}
