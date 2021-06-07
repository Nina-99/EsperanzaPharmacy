package Controller;

import java.io.*;

//La clase debe de implementar la impresión implements Printable
//clase pública que se ejecuta donde debe de estar el main que 
// llama a la otra clase.
public class ImprimeTexto {

    public static void main(String[] args) {

        try {

            //Esto saldría en la consola de java o en la consola de sistema operatico
            System.out.println("Probando, probando la impresión.");

            //enviar a imprimir en pantalla.
            FileDescriptor fd = FileDescriptor.out;
            //- FileOutputStream os = new FileOutputStream(fd);
            FileOutputStream os = new FileOutputStream("//canon/mg-2520");
            //enviar a imprimir a la impresora en red, debemos conocer el nombre de la
            //impresora.
            //Desde windows se puede poner ...new FileOutputStream("//Au-4022/hp1100");

            //Formato UNIX
            //FileOutputStream os = new FileOutputStream("\\\\Au-4022\\hp1100");
            //Si tuviesemos la impresora en el puerto paralelo
            //FileOutputStream os = new FileOutputStream("LPT1:");
            //Si tuviesemos la impresora en el puerto serie
            //FileOutputStream os = new FileOutputStream("COM1:");
            //Enviar a un archivo de texto.
            //  FileOutputStream os = new FileOutputStream("ticket.txt");
            PrintStream ps = new PrintStream(os);
            ps.println("prueba de impresión realizada");
            ps.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
