package interfaces;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class InterForm extends JFrame implements ActionListener{
    //Atributos
    JPanel capa;
    JLabel usuarioL, passwordL;
    JPasswordField passwordT;
    JTextField usuarioT;
    JButton salirB, entrarB;
    JTextArea registrosTA;
    
    
    
    //Constructor
    public InterForm(){
        this.setTitle("Login");
        this.setSize(400, 340);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        capa=new JPanel();
        capa.setLayout(null);
       
      
        //Botones 
        //Salir
        salirB=new JButton("Salir");
        salirB.setBounds(150, 240, 100, 30);
        capa.add(salirB);
        
        //Entrar
        entrarB=new JButton("Entrar");
        entrarB.setBounds(130, 200, 140, 30);
        capa.add(entrarB);
        
        //JLabel
        //Usuario
        usuarioL=new JLabel("Usuario");
        usuarioL.setBounds(175, 20, 100, 30);
        capa.add(usuarioL);
        
        //Password
        passwordL=new JLabel("Contraseña");
        passwordL.setBounds(165, 100, 100, 30);
        capa.add(passwordL);
        
        //JTextField and JPasswordField
        usuarioT=new JTextField();
        usuarioT.setBounds(100, 50, 200,30);
        capa.add(usuarioT);
        
        passwordT=new JPasswordField();
        passwordT.setBounds(100, 130, 200,30);
        capa.add(passwordT);
        
        
        
        
        
        //Botones a la escucha
        salirB.addActionListener(this);
        entrarB.addActionListener(this);
        
        this.add(capa); 
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==salirB){
            System.exit(0);
        }else if(e.getSource()==entrarB){
            //Usuario y Contraseña
            String user;
            String pass;
            user=usuarioT.getText();
            pass=passwordT.getText();
            
            if(user.equalsIgnoreCase("uno") && pass.equalsIgnoreCase("uno")){
                Interfaz inter=new Interfaz();
                this.setVisible(false);
                inter.setVisible(true);
                System.out.println("Entro");
            }
            
        }
            
    }
}

