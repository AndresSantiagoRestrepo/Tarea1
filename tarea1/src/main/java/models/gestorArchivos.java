package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class gestorArchivos {

    private String strRuta;
    public Palabras palabra;

    public gestorArchivos(String strRuta, Palabras palabra) {
        this.strRuta = strRuta;
        this.palabra = palabra;

    }

    // Set para acrualizar los datos de ruta
    public void setStrRuta(String strRuta) {
        this.strRuta = strRuta;
    }

    public void setPalabra(Palabras palabra) {
        this.palabra = palabra;
    }

    public ArrayList<String> abrirRuta() {
        File ruta = new File(this.strRuta);
        String[] nombresArchivos = ruta.list();
        ArrayList<String> txtPaths = new ArrayList<String>();

        for (int i = 0; i < nombresArchivos.length; i++) {

            String path = this.strRuta + "/" + nombresArchivos[i];
            txtPaths.add(path);
        }
        return txtPaths;

    }

    public String leerArchivos(String path) {

        String texto = "";

        try {
            BufferedReader bf = new BufferedReader(new FileReader(path));
            String temp = "";
            String bfRead;

            while ((bfRead = bf.readLine()) != null) {

                temp = temp + bfRead;

            }

            texto = temp;

        } catch (Exception e) {
            System.out.println("Error Archivo " + " " + e);
        }
        return texto;
    }

    public void contarPalabras() {
        int contador = 0;
        String temp = "";
        ArrayList<String> paths = abrirRuta();

        // este primer for es para recorrer los archivos de texto
        for (int i = 0; i < paths.size(); i++) {
            // System.out.println(paths.get(i));
            temp = leerArchivos(paths.get(i)); // Aqui accedo a leer el archivo de texto
            String[] palabras = temp.split("\\s+|\\p{Punct}");

            // Aqui estoy recorriendo por las palabras y de esa forma empiezo a contar las
            // ocurrencias
            for (int j = 0; j < palabras.length; j++) {
                int contadorTemp = 0;
                System.out.println(palabras[j]);
                if (palabras[j].equals(palabra.getPalabra())) {
                    contador += 1;
                    contadorTemp+=1;
                }

            }
        }
        System.out.println(contador); // Contador de las veces qeu apareció en todos los textos
    }

}
