/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jidlomain2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author 38067
 */
public class Jidlomat {
     private Polozka[] položky;
    private int početPoložek;

    public Jidlomat(int kapacita) {
        this.položky = new Polozka[kapacita];
        this.početPoložek = 0;
    }

    public void přidejPoložku(Polozka položka) {
        if (početPoložek < položky.length) {
            položky[početPoložek++] = položka;
        } else {
            System.out.println("Nelze přidat další položku, jídlomat je plný.");
        }
    }

    public void vypišPoložky() {
        for (int i = 0; i < početPoložek; i++) {
            System.out.println(položky[i].toString());
        }
    }

    public Penize kupPoložku(int kód, int vloženéPeníze) {
        for (int i = 0; i < početPoložek; i++) {
            if (položky[i].getKód() == kód) {
                if (položky[i].getCena() <= vloženéPeníze && položky[i].getPočet() > 0) {
                    int vrácenéPeníze = vloženéPeníze - položky[i].getCena();
                    if (vrácenéPeníze >= 0) {
                        položky[i].setPočet(položky[i].getPočet() - 1);
                        return vrácenéMince(vrácenéPeníze);
                    } else {
                        System.out.println("Nedostatek peněz!");
                    }
                } else {
                    System.out.println("Položka není dostupná nebo nedostatek peněz!");
                }
            }
        }
        System.out.println("Položka nenalezena!");
        return null;
    }

    private Penize vrácenéMince(int částka) {
        int početPětiKorun = částka / 5;
        částka %= 5;
        int početDvoukorun = částka / 2;
        int početJednokorun = částka % 2;
        return new Penize(početJednokorun, početDvoukorun, početPětiKorun);
    }

    public int cenaVšechPoložek() {
        int celkováCena = 0;
        for (int i = 0; i < početPoložek; i++) {
            celkováCena += položky[i].getCena() * položky[i].getPočet();
        }
        return celkováCena;
    }

    public void načtiPoložkyZeSouboru(String souborCesta) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(souborCesta))) {
            String line;
            while ((line = bufferedReader.readLine()) != null && početPoložek < položky.length) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
