package Garaj;

public class MasinaElectrica extends Masina {
    private int autonomie;
   
    public MasinaElectrica(String marca, String model, int anFabricatie, int numarKilometrii, String culoareMasina, int autonomie){
        super(marca, model, anFabricatie, numarKilometrii, culoareMasina);
        this.autonomie=autonomie;
    }
    public int getAutonomie(){
        return autonomie;
    }
    public String toString(){
        return super.toString()+"Autonomie:"+autonomie+" km";
    }
    
}
