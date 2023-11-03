package Garaj;

import java.util.ArrayList;
import java.util.List;
//Aceasta este clasa Garaj, in ea implementam toate masinile pe care le dorim
public class Garaj {
    private List<Masina> masini = new ArrayList<>();
    private static final int size = 8;
    private static Garaj instance;
//Avem un constructor denumit 'Garaj'
    public Garaj() {
        
        if (masini.size() >= size) {
            System.out.println("Garajul este plin. Nu se mai pot adăuga mașini.");
        } else {
        // Adaugăm mașinile în garaj cu informatiile despre fiecare
        masini.add(new Masina("BMW", "M3", 2003,240000,"Albastru"));
        masini.add(new Masina("Toyota", "Supra", 1998,50321,"Gri Inchis"));
        masini.add(new Masina("Honda", "Civic", 2018,25432,"Negru"));
        masini.add(new Masina("Ferrari", "LaFerrari", 2010,18540,"Rosu"));
        masini.add(new Masina("Dodge", "Charger", 1970,20040,"Negru"));
        MasinaElectrica masinaElectrica=new MasinaElectrica("Tesla", "3", 2022, 43000, " Alb ", 400);
        masini.add(masinaElectrica);
    }
    }
    public static Garaj getInstance() {
        if (instance == null) {
            instance = new Garaj();
        }
        return instance;
    }
//Metoda selecteazaMasina este pentru a ne returna masina dorita
    public Masina selecteazaMasina(int index) {
        if (index >= 0 && index < masini.size()) {
            return masini.get(index);
        }
        return null;
    }
//Metoda afiseazaMasini ne afiseaza toate pentru a putea alege (afiseaza Modelul)
    public void afiseazaMasini() {
        System.out.println("Mașinile din garaj:");
        for (int i = 0; i < masini.size(); i++) {
            Masina masina = masini.get(i);
            System.out.println(i + ". " + masina.getModel());
        }
    }
//Metoda getNumarMasini ne ofera numarul total de masini
    public int getNumarMasini() {
        return masini.size();
    }
    public void adaugaMasina(Masina masina) {
        masini.add(masina);
       
    }
    public void stergeMasina(Masina masina) {
        masini.remove(masina);
    }
}