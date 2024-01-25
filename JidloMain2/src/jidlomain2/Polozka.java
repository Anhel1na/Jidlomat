/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jidlomain2;

/**
 *
 * @author 38067
 */
public class Polozka {
     private String název;
    private int cena;
    private int počet;
    private int kód;

    public Polozka(String název, int cena, int počet, int kód) {
        this.název = název;
        this.cena = cena;
        this.počet = počet;
        this.kód = kód;
    }

    public String getNázev() {
        return název;
    }

    public int getCena() {
        return cena;
    }

    public int getPočet() {
        return počet;
    }

    public int getKód() {
        return kód;
    }

    public void setPočet(int počet) {
        this.počet = počet;
    }

    @Override
    public String toString() {
        return "Položka{" +
                "název='" + název + '\'' +
                ", cena=" + cena +
                ", počet=" + počet +
                ", kód=" + kód +
                '}';
    }
    
}
