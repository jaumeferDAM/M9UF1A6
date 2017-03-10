/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercici2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;

/**
 *
 * @author ALUMNEDAM
 */
public class Cliente_lista {
    String[] listaS = new String[5];
    
    public Cliente_lista(String[] lista) {
        this.listaS = lista;
}

    public Cliente_lista() {
}
}
