/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercici2;

import Exercici1.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

/**
 *
 * @author ALUMNEDAM
 */
public class Cliente {

    byte[] mensaje;
    int PORT = 3498;
    String[] lista = {"hola", "esto","es","una","prueba"};
    Cliente_lista cliente_lista = new Cliente_lista(lista);
    ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
    ObjectOutput outputStream = new ObjectOutputStream(arrayOutputStream);
    
    byte[] Eco = new byte[1000];
    
    public Cliente() throws SocketException, UnknownHostException, IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress Adreca = InetAddress.getLocalHost();
       outputStream.writeObject(cliente_lista);
      byte[] bytes =   arrayOutputStream.toByteArray();
      DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length,Adreca,PORT);
      
      datagramSocket.send(datagramPacket);
        
//        String texto = JOptionPane.showInputDialog(null, "Introduce el mensaje: ", "In", 3);
//        this.mensaje = texto.getBytes();

        
//        DatagramPacket packet = new DatagramPacket(mensaje, mensaje.length, Adreca, PORT);
//
////            String mensaje = JOptionPane.showInputDialog(null, "Introduce el mensaje: ", "In", 3);
//            datagramSocket.send(packet);
//            
//            //A partir de aqui es la copia del mensaje
//            DatagramPacket datagramPacket = new DatagramPacket(Eco, Eco.length);
//            
//            datagramSocket.receive(datagramPacket);
//            
//            String m1 = new String(datagramPacket.getData());
//            System.out.println(m1);
            
            

    }

    public static void main(String[] argv) throws Exception {
        Cliente c = new Cliente();
        while (true) {
            
        }
    }
}
