
      package tresenraya;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TresRaya {

    private static int columna;
    private static int fila;

    int tablero[][]= new int [3][3];
   
    public static void main(String[] args) {
        TresRaya mi_tresraya = new TresRaya();             
        Scanner entrada = new Scanner(System.in);
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String texto;
        boolean sortir = false;
        do{
            System.out.println("--- Menu 3 en Raya ---");
            System.out.println("\t1) Jugar Tres en Raya");
            System.out.println("\t2) Guardar partida");
            System.out.println("\t3) Carregar Partida");
            System.out.println("\t4) Sortir");
            int opcio = entrada.nextInt();
            entrada.nextLine();
            switch(opcio){
                case 1:
                    mi_tresraya.juego();
                    mi_tresraya.dibujar_tablero();
                    mi_tresraya.jugar_partida();
                        break;
                case 2:
                    mi_tresraya.guardarPartida();
                       break;
                //case 3: cargarPartida();
                  //      break;
                case 4: sortir = true;
                        break;       
                default:
                    System.out.println("Opcio no valida");
            }
       
        }while(!sortir);
    }
   
    public void dibujar_tablero(){         
       int columnas_tablero;
       int filas_tablero;
       
       System.out.println("---- Tres en Raya ----");
       for(int i = 0; i < tablero.length; i++){
            for(int j = 0; j < tablero.length; j++){
               
                if(tablero[i][j] == 0){                   
                    System.out.print("| " + tablero[i][j] + " ");
                }
                if (tablero[i][j] == 1)
                {
                     System.out.print("| " + "X" + " "); 
                }
                if (tablero[i][j] == 3)
                {
                     System.out.print("|" + "  ");
                }
            }
            System.out.print("|");
            System.out.println("");
        }
        System.out.println("-----------------------");   
    }
   
    public void juego(){
        for(int i = 0; i<tablero.length; i++){
            for(int j = 0; j<tablero.length; j++){
                tablero[i][j] = 3;
            }
        }
    }
   
    public void jugar_partida(){
        try {
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

            boolean fin=false;
           
            System.out.println("¿Cómo quieres jugar X/0?");
            String juego = teclado.readLine().toUpperCase();
            int valor_juego=0;
            if(juego.equals("0")){
                valor_juego=0;
            }
            if(juego.equals("X")){             
                valor_juego=1;
            }
            if(juego.equals("X") || (juego.equals("0"))){
                       
            while(fin==false){
            dibujar_tablero();
            if(valor_juego==1){
                System.out.println("Te toca X");
            }
            if(valor_juego==0){
                System.out.println("Te toca 0");
            }
            System.out.println("Introduce coordenadas de posición: (0,0) ");
            System.out.println("Introduce la fila");
            int fila= Integer.parseInt(teclado.readLine());
            System.out.println("Introduce la columna");
            int columna= Integer.parseInt(teclado.readLine());
            if(tablero[fila][columna]==3){
                boolean ganador;
                tablero[fila][columna]=valor_juego;
                dibujar_tablero();
                ganador=comprobacion(valor_juego);
               
                if(ganador){
                    System.out.println("Ha ganado " + valor_juego);
                    fin=true;
                    juego();
                }else {
                    int estado_empate=0;
                    for(int i=0;i<=2;i++){
                        for(int j=0;j<=2;j++){
                            if((tablero[i][j]==0) || (tablero[i][j]==1)){
                                estado_empate=estado_empate+1;
                            }
                        }
                    }
                    if(estado_empate==9){
                        System.out.println("Se ha empatado");
                        fin=true;
                    }
                    if(valor_juego==1){
                        valor_juego=0;
                    }
                    else{
                        if(valor_juego==0){
                        valor_juego=1;
                        }
                    }
                }
            }else{
                System.out.println("No puede jugar, ya está usado");
            }
            }
            }
        } catch (IOException ex) {
            Logger.getLogger(TresRaya.class.getName()).log(Level.SEVERE, null, ex);
        }
   
}
   

    public boolean comprobacion(int valor_tresraya){
   
        if((tablero[0][0]==valor_tresraya) && (tablero[0][1]==valor_tresraya) && (tablero[0][2]==valor_tresraya)){
            return true;
        }
        if((tablero[1][0]==valor_tresraya) && (tablero[1][1]==valor_tresraya) && (tablero[1][2]==valor_tresraya)){
            return true;
        }
        if((tablero[2][0]==valor_tresraya) && (tablero[2][1]==valor_tresraya) && (tablero[2][2]==valor_tresraya)){
            return true;
        }
        if((tablero[0][0]==valor_tresraya) && (tablero[2][0]==valor_tresraya) && (tablero[3][0]==valor_tresraya)){
            return true;
        }
        if((tablero[0][1]==valor_tresraya) && (tablero[1][1]==valor_tresraya) && (tablero[2][1]==valor_tresraya)){
            return true;
        }
        if((tablero[0][2]==valor_tresraya) && (tablero[1][2]==valor_tresraya) && (tablero[2][2]==valor_tresraya)){
            return true;
        }
        if((tablero[0][0]==valor_tresraya) && (tablero[1][1]==valor_tresraya) && (tablero[2][2]==valor_tresraya)){
            return true;
        }
        if((tablero[0][2]==valor_tresraya) && (tablero[1][1]==valor_tresraya) && (tablero[2][0]==valor_tresraya)){
            return true;
        }
        return false;
    }
   
    public void guardarPartida(){
       try{
        BufferedReader in=new
        BufferedReader(new InputStreamReader(new FileInputStream("D:\\arc.txt")));
        int filas=Integer.parseInt(in.readLine());
        int columnas=Integer.parseInt(in.readLine());
        tablero = new int[fila][columna];
        for(int i = 0; i < fila; i++){
        for(int j = 0; j < columna; j++){
        tablero[ i ][ j ]=(int)(in.read());
        }
        }
        in.close();
        }catch(Exception e){}
    }

   
   
    //public void cargarPartida(){
       
    //}
   
   
}
