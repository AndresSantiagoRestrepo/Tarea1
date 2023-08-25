package main;

import java.util.Scanner;

import models.Palabras;
import models.gestorArchivos;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingese la palabra que desea contar");
        String word = scanner.nextLine();
        System.out.println("Usted ingresó la palabra: " + word);
        Palabras palabra = new Palabras(word);

        System.out.println("Ingese el nombre y la ruta completa de la carpeta donde quiere buscar la palabra:");
        String path = scanner.nextLine();
        System.out.println("la ruta especificada es: " + path);

        gestorArchivos gestor = new gestorArchivos(path, palabra);
        gestor.contarPalabras();

    }
}