/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jidlomain2;

/**
 *
 * @author 38067
 */
public class JidloMain2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jidlomat jídlomat = new Jidlomat(10); // Kapacita 10 položek

        // Přidání položek do jídlomatu
        jídlomat.přidejPoložku(new Polozka("Sendvič", 30, 5, 1));
        jídlomat.přidejPoložku(new Polozka("Káva", 20, 10, 2));
        jídlomat.přidejPoložku(new Polozka("Rohlík", 10, 8, 3));

        // Vypsání položek v jídlomatu
        System.out.println("Položky v jídlomatu:");
        jídlomat.vypišPoložky();

        // Simulace nákupu
        int kódPoložky = 2; // Káva
        int vloženéPeníze = 25;

        System.out.println("Nákup: Káva");
        Penize vrácenéMince = jídlomat.kupPoložku(kódPoložky, vloženéPeníze);

        // Vypsání výsledku nákupu
        if (vrácenéMince != null) {
            System.out.println("Nákup úspěšný!");
            System.out.println("Zbývající mince: " + vrácenéMince.toString());
        } else {
            System.out.println("Nákup neúspěšný!");
        }

        // Vypsání celkové ceny všech položek v jídlomatu
        System.out.println("Celková cena všech položek: " + jídlomat.cenaVšechPoložek());

        // Načtení položek ze souboru
        jídlomat.načtiPoložkyZeSouboru("jidlomat.csv");
        System.out.println("Položky po načtení ze souboru:");
        jídlomat.vypišPoložky();
    }
    }
    

