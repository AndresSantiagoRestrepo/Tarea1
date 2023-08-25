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
        ArrayList<String> txtPaths = new ArrayList<String>();

        try {
            File ruta = new File(this.strRuta);
            String[] nombresArchivos = ruta.list();

            if (!ruta.exists()) {

                System.out.println("No se encuentra la carpeta indicada");

            } else {
                for (int i = 0; i < nombresArchivos.length; i++) {

                    String path = this.strRuta + "/" + nombresArchivos[i];
                    txtPaths.add(path);
                }
            }

        } catch (Exception e) {
            System.out.println("error: la ruta especificada no existe");
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

    public String conseguirNombre(String path) {
        String salida = "";

        String[] partes = path.split("[\\\\/]");
        salida = partes[partes.length - 1];

        return salida;

    }

    public void contarPalabras() {
        boolean flag = false;
        int contador = 0;
        String temp = "";
        ArrayList<String> paths = abrirRuta();

        // este primer for es para recorrer los archivos de texto
        for (int i = 0; i < paths.size(); i++) {
            int contadorTemp = 0;

            if (conseguirNombre(paths.get(i)).endsWith(".txt") || conseguirNombre(paths.get(i)).endsWith(".xml") ||
                    conseguirNombre(paths.get(i)).endsWith(".json") || conseguirNombre(paths.get(i)).endsWith(".csv")) {
                flag = true;
                temp = leerArchivos(paths.get(i)); // Aqui accedo a leer el archivo de texto
                String[] palabras = temp.split("\\s+|\\p{Punct}");

                // Aqui estoy recorriendo por las palabras y de esa forma empiezo a contar las
                // ocurrencias
                for (int j = 0; j < palabras.length; j++) {
                    if (palabras[j].equals(palabra.getPalabra())) {
                        contador += 1;
                        contadorTemp += 1;
                    }

                    if (j == palabras.length - 1) {
                        String nombre = conseguirNombre(paths.get(i));
                        System.out.println(nombre + " " + contadorTemp + " veces");

                    }

                }

            }
        }
        if (flag) {
            System.out.println("Total: " + contador); // Contador de las veces que apareció en todos los textos
        } else {
            System.out.println("No se encontraron archivos de texto en la carpeta");
        }
    }

    public void iniciar() {

        if ((this.strRuta != "") && (this.palabra != null)) {
            contarPalabras();
        } else {
            System.out.println("Uno de los campos quedó vacío, reintente");
        }

    }

}
