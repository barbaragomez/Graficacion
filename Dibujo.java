
package com.mycompany.examenu1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dibujo extends JPanel{
    private final JFrame ventana;
    private final Container contenedor;
    int opcion;
    Scanner scan = new Scanner(System.in);
    
    //Declaramos un arreglo, y almacenamos los bits para la figura
    private final int [] FIGURA = {
        0x001F0000,
        0x003F8000,
        0x007FC000,
        0x00FFE000,
        0x00FFE000,
        0x01FFF000,
        0x01FFF000,
        0x01FFF000,
        0x01FFF800,
        0x00FFF800,
        0x00FFF800,
        0x00FFF000,
        0x007FE000,
        0x003F8000,
        0x000E0000

    };
    //Declaramos el tipo y número de nuestra máscara
    private final int MASCARA = 0x80000;
    //Declaramos el tipo y número del ancho de la figura en bits
    private final int ANCHO_BITS = 20;
    //Declaramos nuestras coordenadas
    private int coordenadasx, coordenadasy;
    
    //Definiendo hilo de ejecucion
    private final Thread hilo;
    //Definimos nuestro método Dibujo
    public Dibujo() {
        ventana = new JFrame ("Dibujando icono");
        ventana.setSize(600, 400);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        
        contenedor = ventana.getContentPane();
        contenedor.setSize(400, 400);
        contenedor.add(this, BorderLayout.CENTER);
        
        this.hilo = new Thread();
    }

    @Override
    protected void paintComponent(Graphics graficos) {
        super.paintComponent(graficos);
        
        //Iterador de la figura
        for (int i = 0; i < this.FIGURA.length; i++) {
          //Iterador para el ancho en bits
            for (int j = 0; j < this.ANCHO_BITS; j++) {
                int temp = this.FIGURA [i] & (this.MASCARA >> j);
                if (temp != 0){
                    graficos.drawLine(j + coordenadasx,
                                      i + coordenadasy,
                                      j + coordenadasx,
                                      i + coordenadasy);
                }
            }
        }
    }
    //Definimos nuestro método dibujar
    public void dibujar(){
        this.coordenadasx = (int) (Math.random()*200);
        this.coordenadasy = (int) (Math.random()*200);
        
        
        System.out.println("Hacia donde desea desplazar la figura:"
                + "\n1.- Arriba"
                + "\n2.- Abajo"
                + "\n3.- Izquierda"
                + "\n4.- Derecha");
        
        opcion = scan.nextInt();
        
        if (opcion == 1){
            Arriba();
        }else if(opcion == 2){
            Abajo();
        }else if(opcion == 3){
            Izquierda();
        }else if(opcion == 4){
            Derecha();
        }else if( opcion >= 0 && opcion <= 5){
            System.out.println("Introduce una opcion valida");
        }
    }
        
        
       public void Arriba(){
        
        for (int i = 0; i < 25; i++) {
            try{
                this.coordenadasy = this.coordenadasy -20;
                Thread.sleep(200);
                paint(getGraphics());
                
            }catch(InterruptedException e){
                System.err.println(e.getMessage());
            }
        System.out.println("La figura recorrió: " + i + " hacia la derecha hasta el borde");
        }
        
        paint(getGraphics());
    }
        public void Abajo(){
        
        for (int i = 0; i < 25; i++) {
            try{
                this.coordenadasy = this.coordenadasy +20;
                Thread.sleep(200);
                paint(getGraphics());
                
            }catch(InterruptedException e){
                System.err.println(e.getMessage());
            }
        System.out.println("La figura recorrió: " + i + " hacia la derecha hasta el borde");
        }
        
        paint(getGraphics());
    }
         public void Izquierda(){
        
        for (int i = 0; i < 25; i++) {
            try{
                this.coordenadasx = this.coordenadasx -20;
                Thread.sleep(200);
                paint(getGraphics());
                
            }catch(InterruptedException e){
                System.err.println(e.getMessage());
            }
        System.out.println("La figura recorrió: " + i + " hacia la derecha hasta el borde");
        }
        
        paint(getGraphics());
    }
          public void Derecha(){
        
        for (int i = 0; i < 25; i++) {
            try{
                this.coordenadasx = this.coordenadasx +20;
                Thread.sleep(200);
                paint(getGraphics());
                
            }catch(InterruptedException e){
                System.err.println(e.getMessage());
            }
        System.out.println("La figura recorrió: " + i + " hacia la derecha hasta el borde");
        }
        
        paint(getGraphics());
    }
    
} //ends clase principal




