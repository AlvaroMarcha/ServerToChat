package interfaces;
import controlador.Servidor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
public class Interfaz extends JFrame implements ActionListener{
    //Atributos
    JPanel capa;
    JLabel serverName;
    JButton abrirB, cerrarB, salirB;
    JTextArea registrosTA;
    
    
    //Constructor
    public Interfaz(){
        this.setTitle("Registros del Servidor");
        this.setSize(600, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        capa=new JPanel();
        capa.setLayout(null);
        
        String serverN=JOptionPane.showInputDialog("Nombre del Servidor");
        
        //Nombre del servidor
        serverName=new JLabel(serverN);
        serverName.setBounds(20, 40, 300, 30);
        capa.add(serverName);
        
        //TextArea donde saldran los registros 
        registrosTA=new JTextArea();
        registrosTA.setBounds(20, 70, 550, 600);
        capa.add(registrosTA);
        
        //Botones 
        //Salir
        salirB=new JButton("Salir");
        salirB.setBounds(450, 700, 100, 30);
        capa.add(salirB);
        
        //Abrir
        abrirB=new JButton("Levantar Servidor");
        abrirB.setBounds(20, 700, 150, 30);
        capa.add(abrirB);
        
        //Cerrar
        cerrarB=new JButton("Cerrar Servidor");
        cerrarB.setBounds(200, 700, 150, 30);
        capa.add(cerrarB);
        
        
        
        //Botones a la escucha
        salirB.addActionListener(this);
        abrirB.addActionListener(this);
        cerrarB.addActionListener(this);
        
        this.add(capa); 
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        //Instancia Servidor
        Servidor servidor;
        if(e.getSource()==salirB){
            System.exit(0);
        }else if(e.getSource()==abrirB){
            //Se preguntara si se quiere abrir la conexion
            int respuesta=JOptionPane.showConfirmDialog(capa, "¿Desea abrir la conexion?");
            if(respuesta==0){
                System.out.println("Iniciando Server");
                //Aqui se escribe el codigo que devuelve el server
                //Clase Servidor
                String puertoT=JOptionPane.showInputDialog("Introduce el puerto: ");
                int puerto=Integer.parseInt(puertoT);
                servidor=new Servidor(puerto);
                try {
                    System.out.println("¡¡Servidor Levantado!!");
                    //SERVIDOR A LA ESCUCHA
                    
                    registrosTA.setText(servidor.proceso());
                    
                    
                    
                    
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                
                
            }else{
                System.out.println("Servidor Cerrado");
            }
        }else if(e.getSource()==cerrarB){
            int respuesta=JOptionPane.showConfirmDialog(capa, "¿Desea cerrar la conexion?");
            if(respuesta==0){
                System.out.println("Cerrando Servidor");
            }else{
                System.out.println("Server corriendo...");
            }
        }
            
    }
}
