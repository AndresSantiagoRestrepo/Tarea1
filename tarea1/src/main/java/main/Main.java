package main;

import models.Palabras;
import models.gestorArchivos;

public class Main {
    public static void main(String[] args) {
        Palabras palabra = new Palabras("arar");
        gestorArchivos gestor = new gestorArchivos("C:/Users/Stokker/Documents/Pruebas/pruebas1", palabra);

        /// archivo.abrirRuta();
        // System.out.println(archivo.leerArchivos());
        gestor.contarPalabras();

    }
}