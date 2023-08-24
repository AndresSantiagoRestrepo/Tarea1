package main;

import models.gestorArchivos;

public class Main {
    public static void main(String[] args) {

        gestorArchivos archivo = new gestorArchivos("C:/Users/Stokker/Documents/Pruebas/pruebas1");

        ///archivo.abrirRuta();
        // System.out.println(archivo.leerArchivos());
        archivo.contarPalabras();

    }
}