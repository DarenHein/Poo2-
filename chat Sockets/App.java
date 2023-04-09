import javax.swing.JFrame;

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
/* aplicacion cliente sockets con interfas grafica  
 * alumno Manjarrez carbajal Luis Raul 
*/
public class App extends JFrame implements Runnable {

    private int ancho = 500; 
    private int largo = 500;  
    private JPanel panel ; 
    private JLabel eti ; 
    private JLabel eti2; 
    private JLabel eti3 ; 
    private JLabel eti4; 
    String ip = "LocalHost"; 
    int puerto = 9998; 
    private JTextField campo; 
    private JButton boton; 

    @Override
    public void run(){
        eti4 = new JLabel(); 
        try {
            ServerSocket servi = new ServerSocket(9999); 
            while(true){
                Socket misocket2 = servi.accept(); 
                DataInputStream flujoe = new DataInputStream(misocket2.getInputStream()); 
                String mensaje = flujoe.readUTF(); 
                eti4.setText(mensaje);
                eti4.setForeground(Color.red);
                eti4.setVisible(true);
                flujoe.close();
            }
            
        } catch (IOException e) {
            // TODO: handle exception
        }
        
    }

    public App(){
        Thread obj = new Thread(this); 
        obj.start();
        this.setSize( ancho, largo );
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Usuario");
        this.setLocationRelativeTo(null);
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
        eti = new JLabel(); 
        eti.setBounds(200, 50, 120, 20);
        eti.setText("Usuario");
        eti.setForeground(Color.blue);
        eti.setFont(new Font("arial",Font.BOLD,20));
        panel.add(eti); 

        eti2 = new JLabel(); 
        eti2.setBounds(50,306,120,20);
        eti2.setText("Enviar mensaje : ");
        panel.add(eti2); 

        eti3 = new JLabel(); 
        eti3.setBounds(50, 120, 120, 20);
        eti3.setText("Servidor : ");
        eti3.setForeground(Color.red);
        panel.add(eti3); 

        eti4 = new JLabel(); 
        eti4.setBounds(200, 120, 120, 20);
        eti4.setForeground(Color.red);
        eti4.setVisible(false);
        panel.add(eti4); 
        
    }
    public void campos(){
        campo = new JTextField(); 
        campo.setBounds(170,306,120,20);
        panel.add(campo); 
    }

    public void botones(){
        boton = new JButton(); 
        boton.setBounds(350, 306, 70, 20);
        boton.setText("Enviar");
        boton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    Socket misocket = new Socket(ip,puerto); 
                    DataOutputStream flujo = new DataOutputStream(misocket.getOutputStream()); 
                    flujo.writeUTF(campo.getText());
                    flujo.close();
                    
                } catch (IOException e2) {
                    // TODO: handle exception
                    System.out.println("Error en conexion ");
                }
              
               
            }
            
        });
        panel.add(boton); 
    }

    public static void main(String[] args) {
        System.out.println("Iniciando programa....");
        App obj = new App(); 
        obj.setVisible(true);
    }

}
