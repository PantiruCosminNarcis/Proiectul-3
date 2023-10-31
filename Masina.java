public class Masina {
    //Avem atributele clasei Masina private, deoarece nu pot fi modificate
    private String marca;
    private String model;
    private int anFabricatie;
    private int numarKilometrii;
    private String culoareMasina;
//Constructorul Masina
    public Masina(String marca, String model, int anFabricatie, int numarKilometrii, String culoareMasina) {
        this.marca = marca;
        this.model = model;
        this.anFabricatie = anFabricatie;
        this.numarKilometrii=numarKilometrii;
        this.culoareMasina=culoareMasina;
    }
//Mai jos avem metodele pentru a obtine informatiile despre masina(model,marca,anul fabricatiei)
    public String getModel() {
        return model;
    }
    public String getMarca() {
        return marca;
    }
    public int getAnFabricatie() {
        return anFabricatie;
    }
    public int numarKilometrii() {
        return numarKilometrii;
    }
    public String culoareMasina(){
        return culoareMasina;
    }
}