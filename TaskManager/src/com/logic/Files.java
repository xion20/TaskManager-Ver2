package com.logic;

import com.logic.Task;
import com.util.List;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.*;

public class Files {
    
     /*Método para convertir un objeto Task en string y escribirlo en el 
      archivo */
    public static void writeFileText(Task task) {
        File file = new File(System.getProperty("user.home") + "\\Tasks.txt");
        String text = task.convert_to_text();
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(file,true))) {
            
            writer.println(text);
            System.out.println("Texto escrito en el archivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Metodo para leer un archivo y devolverlo en formato string//
    public static String readFileText() {
        File file = new File(System.getProperty("user.home") + "\\Tasks.txt");
        StringBuilder contenido = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contenido.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contenido.toString();
    }
    
     //Método para crear un archivo//
    public static void createFile() {
        File file = new File(System.getProperty("user.home") + "\\Tasks.txt");

        try {
            if (file.createNewFile()) {
                System.out.println("El archivo ha sido creado: " + file.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al crear el archivo.");
            e.printStackTrace();
        }
    }
    
    /*Aqui habria que completar estos metodos, el primero devolveria una List 
    con Objetos de la clase TASK que esten en status == 0; el segundo lo mismo 
    pero con status == 1;
    */

    public static List getDoneLs() {
        List temp = new List ();
        
        File file = new File(System.getProperty("user.home") + "\\Tasks.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                
                String[] parts = line.split(",");
                String title = parts[0];
                String info = parts[1];
                boolean status = Boolean.parseBoolean(parts[2]);
                
                if (status==true) {
                	Task task = new Task(title,info,status);
                	temp.insert(task);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }
    
    // status 0
    public static List getTodoLs() {
        List temp = new List ();
        File file = new File(System.getProperty("user.home") + "\\Tasks.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                
                String[] parts = line.split(",");
                String title = parts[0];
                String info = parts[1];
                boolean status = Boolean.parseBoolean(parts[2]);
                if (status==false) {
                	Task task = new Task(title,info,status);
                	temp.insert(task);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }
     
     /*
     Leer el archivo, encontrar la tarea que coincida con ese titulo y cambiarle el 
     status en el primero cambiarserlo a 0 y en 2do a 1
     */
     
    public static void chanceTodo(String selectedTitle) {
        try (BufferedReader lector = new BufferedReader(new FileReader(System.getProperty("user.home") + "\\Tasks.txt"));
             BufferedWriter escritor = new BufferedWriter(new FileWriter(System.getProperty("user.home") + "\\Tasks.txt" + "_temp", false))) {

            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 3 && partes[0].trim().equalsIgnoreCase(selectedTitle)) {
                    // Modifica el valor booleano (última parte de la línea)
                	partes[2] = String.valueOf(false);

                    // Reconstruye la línea modificada
                    String lineaModificada = String.join(",", partes);

                    // Escribe la línea modificada al archivo original
                    escritor.write(lineaModificada);
                } else {
                    // Escribe la línea original al archivo original
                    escritor.write(linea);
                }

                // Agrega un salto de línea después de cada línea escrita
                escritor.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Elimina el archivo original y renombra el archivo temporal
        File archivoOriginal = new File(System.getProperty("user.home") + "\\Tasks.txt");
        File archivoTemporal = new File(System.getProperty("user.home") + "\\Tasks.txt" + "_temp");
        archivoOriginal.delete();
        archivoTemporal.renameTo(archivoOriginal);
    }

    public static void chanceDone(String selectedTitle) {
         try (BufferedReader lector = new BufferedReader(new FileReader(System.getProperty("user.home") + "\\Tasks.txt"));
             BufferedWriter escritor = new BufferedWriter(new FileWriter(System.getProperty("user.home") + "\\Tasks.txt" + "_temp", false))) {

            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 3 && partes[0].trim().equalsIgnoreCase(selectedTitle)) {
                    // Modifica el valor booleano (última parte de la línea)
                	partes[2] = String.valueOf(true);

                    // Reconstruye la línea modificada
                    String lineaModificada = String.join(",", partes);

                    // Escribe la línea modificada al archivo original
                    escritor.write(lineaModificada);
                } else {
                    // Escribe la línea original al archivo original
                    escritor.write(linea);
                }

                // Agrega un salto de línea después de cada línea escrita
                escritor.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Elimina el archivo original y renombra el archivo temporal
        File archivoOriginal = new File(System.getProperty("user.home") + "\\Tasks.txt");
        File archivoTemporal = new File(System.getProperty("user.home") + "\\Tasks.txt" + "_temp");
        archivoOriginal.delete();
        archivoTemporal.renameTo(archivoOriginal);
    }
    
    /*
    Borra una tarea del archivo
    */
    
    public static void delateTask (String selectedTitle) {
        try (BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.home") + "\\Tasks.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("user.home") + "\\Tasks.txt" + "_temp", false))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Divide la línea en partes utilizando la coma como delimitador
                String[] parts = line.split(",");

                // Verifica si hay al menos tres partes (título, información, booleano)
                if (parts.length >= 3) {
                    // Obtiene el título de la línea
                    String tituloEnLinea = parts[0].trim();

                    // Compara el título buscado con el título en la línea (insensible a mayúsculas y minúsculas)
                    if (!tituloEnLinea.equalsIgnoreCase(selectedTitle)) {
                        // Escribe la línea al archivo temporal si no coincide con el título buscado
                        writer.write(line);
                        writer.newLine(); // Agrega un salto de línea después de cada línea escrita
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); }

    // Elimina el archivo original y renombra el archivo temporal
    File archivoOriginal = new File(System.getProperty("user.home") + "\\Tasks.txt");
    File archivoTemporal = new File(System.getProperty("user.home") + "\\Tasks.txt" + "_temp");
    archivoOriginal.delete();
    archivoTemporal.renameTo(archivoOriginal);
    }

    
    // TEST PART IGNORE
    public static void main(String[] args) {
        List list = new List();
        list = getDoneLs();
        list.muestra();
        
       
    }

    
}