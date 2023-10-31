import java.util.ArrayList;
import java.util.List;
//Aceasta este clasa Garaj, in ea implementam toate masinile pe care le dorim
public class Garaj {
    private List<Masina> masini = new ArrayList<>();
    private static final int size = 6;
//Avem un constructor denumit 'Garaj'
    public Garaj() {
        
        if (masini.size() >= size) {
            System.out.println("Garajul este plin. Nu se mai pot adăuga mașini.");
        } else {
        // Adaugăm mașinile în garaj cu informatiile despre fiecare
        masini.add(new Masina("BMW", "M3", 2003,240000,"Albastru"));
        masini.add(new Masina("Toyota", "Supra", 1998,50321,"Gri Inchis"));
        masini.add(new Masina("Honda", "Civic", 2018,25432,"Negru"));
        masini.add(new Masina("Volkswagen", "Passat", 2023,600,"Maro"));
        masini.add(new Masina("Dacia", "Duster", 2022,4032,"Negru"));
        masini.add(new Masina("Ferrari", "LaFerrari", 2010,18540,"Rosu"));
    }
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
}