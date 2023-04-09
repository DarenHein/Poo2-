import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.*; 

public class Servidor  extends JFrame implements Runnable{

    private int puerto = 9999; 
    private String ip = "LocalHost"; 
    private  JPanel panel ; 
    private JTextField campo; 
    private JLabel eti; 
    private JLabel eti2 ; 
    private JButton boton; 
    private JLabel eti3; 
    private JLabel eti4 ; 
    private int ancho = 500; 
    private int largo  = 500; 
    private JButton boton2; 


    @Override 
    public void run(){

        eti3 = new JLabel(); 

        try {

            ServerSocket servi = new ServerSocket(9998); 
            while(true){
                Socket misocket = servi.accept(); 
                DataInputStream flujo = new DataInputStream(misocket.getInputStream()); 
                String mensaje = flujo.readUTF(); 
                eti3.setText(mensaje);
                eti3.setForeground(Color.BLUE);
                eti3.setVisible(true);
                flujo.close();
                
            }
            
        } catch ( IOException e) {
            // TODO: handle exception
            System.out.println("Error en conexion .....");
        }

    }
    public Servidor(){
        Thread obj = new Thread(this); 
        obj.start();
        this.setSize(ancho,largo);
        //this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Servidor");
        paneles(); 
        

    }
    public void paneles(){
        panel = new JPanel(); 
        panel.setLayout(null);
        this.getContentPane().add(panel); 
        etiquetas(); 
        campos();
        botones();
    }
    public void etiquetas(){
        eti=new JLabel(); 
        eti.setBounds(200,50,120,20);
        eti.setText("Servidor");
        eti.setForeground(Color.red);
        eti.setFont(new Font("arial",Font.BOLD,22)); 
        panel.add(eti); 

        eti2 = new JLabel(); 
        eti2.setBounds(40,120,120,20);
        eti2.setText("Usuario :");
        eti2.setForeground(Color.blue);
        panel.add(eti2); 

        eti3 = new JLabel(); 
        eti3.setBounds(150 , 120,120,20);
        eti2.setForeground(Color.blue);
        eti3.setVisible(false);
        panel.add(eti3); 

        eti4 = new JLabel(); 
        eti4.setBounds(50,306,120,20);
        eti4.setText("Mensaje :  ");
        panel.add(eti4); 


    }

    public void campos(){
        campo = new JTextField();
        campo.setBounds(150,306,120,20); 
        panel.add(campo); 
    }

    public void botones(){
        boton = new JButton(); 
        boton.setBounds(300,306, 120,20);
        boton.setText("Enviar");
        boton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               try {

                Socket misocket2 = new Socket(ip,puerto); 
                DataOutputStream flujos = new DataOutputStream(misocket2.getOutputStream());
                flujos.writeUTF(campo.getText());
                flujos.close(); 

                
               } catch (IOException e34) {
                // TODO: handle exception
                System.out.println("error en conexion ");
               }
            }
            
        });
        panel.add(boton); 
    }
    public static void main(String[] args) {

        Servidor obj = new Servidor(); 
        obj.setVisible(true);
        
    }

}
