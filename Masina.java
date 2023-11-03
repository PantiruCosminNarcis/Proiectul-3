package Garaj;

public class Masina {
    private String marca;
    private String model;
    private int anFabricatie;
    private int numarKilometrii;
    private String culoareMasina;

    public Masina(String marca, String model, int anFabricatie, int numarKilometrii, String culoareMasina) {
        this.marca = marca;
        this.model = model;
        this.anFabricatie = anFabricatie;
        this.numarKilometrii = numarKilometrii;
        this.culoareMasina = culoareMasina;
    }

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

    public String culoareMasina() {
        return culoareMasina;
    }
    public void setCuloareMasina(String culoareMasina) {
        this.culoareMasina = culoareMasina;
    }
    @Override
    public String toString() {
        return marca+" "+model+" "+anFabricatie+" "+culoareMasina;
    }
    }

