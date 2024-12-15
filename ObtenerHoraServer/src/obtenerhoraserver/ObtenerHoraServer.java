/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package obtenerhoraserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 *
 * @author root
 */
public class ObtenerHoraServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random();
        int port = 1234;
        
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Servidor iniciado en el puerto " + port + ".");

            
            // Aceptar una conexion
            Socket client = server.accept();
            System.out.println("Cliente conectado: " + client.getInetAddress());

            // Leer y responder al cliente
            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter output = new PrintWriter(client.getOutputStream(), true);

            
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date();
            String answer = dateFormat.format(date);
            output.println(answer); 

        } catch (IOException ex) {
        ex.printStackTrace();
        } 
    }
    
}
