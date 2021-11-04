package controlador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

public class Servidor {

    //Para poder usar esta Clase, se necesita el nick, mensaje e IP
    private String nick;
    private String mensaje;
    private String ip;
    private int puerto;
    ServerSocket servidor;
    Socket cliente;
    DataInputStream entrada;
    DataOutputStream envio;
    ArrayList<Socket> clientes = new ArrayList<>();

    //Constructor
    public Servidor(String nick, String mensaje, String ip, int puerto) throws IOException {
        this.nick = nick;
        this.mensaje = mensaje;
        this.ip = ip;
        this.puerto = puerto;
        clientes.add(cliente);

    }

    public Servidor(int puerto) {
        this.puerto = puerto;
    }

    //Getter and Setter
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    //toString
    @Override
    public String toString() {
        String mensaje = "Nick: " + this.nick + "- Data: " + this.mensaje + "- IP: " + this.ip;
        return mensaje;
    }

    /*
    
    METODOS DE LA CLASE PARA RECIBIR Y ENVIAR LOS DATOS
    
     */
    //Metodo a la espera...
    public String proceso() throws IOException {
        //Aceptamos peticion
        //Inicializamos ServerSocket y Socket
        servidor = new ServerSocket(this.puerto);
        cliente = servidor.accept();

        //Datas
        entrada = new DataInputStream(cliente.getInputStream());
        envio = new DataOutputStream(cliente.getOutputStream());

        if (cliente.isConnected()) {

            //Recibimos los datos
            this.mensaje = entrada.readUTF();
            System.out.println("\nSe recupero la siguiente informacion del cliente: \n");

            //Devolvemos
            envio.writeUTF("Recibido.");
            
            cerrarAll();
        } else {
            System.out.println("Esperando petición...");
        }
        return this.mensaje;
    }

    //Con este metodo enviaremos datos a la direccion IP xxx.xxx.xxx
    public void enviarDato() {

    }

    //Con este metodo recibiremos datos de la direccion IP xxx.xxx.xxx
    public void recibirDato() {

    }

    //Con este metodo cerramos los datas
    public void cerrarDatas() throws IOException {
        //Cerramos datas
        envio.close();
        entrada.close();
        System.out.println("Se cerro el envio y la entrada de datos");
    }

    //Con este metodo cerramos el servidor
    public void cerrarServer() throws IOException {
        cliente.close();
        servidor.close();
        System.out.println("Se cerro la conexion con el servidor");
    }

    //Con este metodo Cerramos TODO
    public void cerrarAll() throws IOException {
        cerrarDatas();
        cerrarServer();
        System.out.println("Se cerraron todas las comunicaciones al servidor");
    }

    //Con este metodo podemos crear otro Socket para otro cliente a la escucha
    public void crearSocket() {
        System.out.println("Cliente 1: " + clientes.toString());

    }

}
