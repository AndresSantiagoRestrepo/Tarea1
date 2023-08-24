package models;

public class Palabras {

    private String palabra;
    private int vecesCarpeta;

    public Palabras(String palabra) {
        this.palabra = palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    
    public void setVecesCarpeta(int vecesCarpeta) {
        this.vecesCarpeta = vecesCarpeta;
    }

    public String getPalabra() {
        return palabra;
    }

   

    public int getVecesCarpeta() {
        return vecesCarpeta;
    }


    
    

}