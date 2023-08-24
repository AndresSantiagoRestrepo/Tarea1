package models;

public class Palabras {

    private String palabra;
    private int vecesTexto;
    private int vecesCarpeta;

    public Palabras(String palabra) {
        this.palabra = palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public void setVecesTexto(int vecesTexto) {
        this.vecesTexto = vecesTexto;
    }

    public void setVecesCarpeta(int vecesCarpeta) {
        this.vecesCarpeta = vecesCarpeta;
    }

    

}