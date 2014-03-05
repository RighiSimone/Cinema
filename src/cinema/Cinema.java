package cinema;
import java.util.Random;
import java.math.*;


public class Cinema {
    
    public static void main(String[] args) {        
        //Numero casuale che rappresenta la quantità di nuovi Thread
        double random = Math.random()*100;
        random = (int) random;
        
        //Istanzio un oggetto di tipo Random per le operazione all'internodel for
        Random r = new Random();
        
        //Inizio ciclo di creazione dei Thread
        for(int x=0; x<random; x++){
            //Genero casualmente un'azione
            int azioneCinema = r.nextInt(2);
            
            //Prenotazione righe casuale
            int righe = r.nextInt(9);
            
            //Prenotazione colonne casuale
            int colonne = r.nextInt(9);
            
            //Incremento per evitare il caso 0
            azioneCinema++;
            
            //Creo un thread con i dati righe, colonne e azioneCinema
            MyThread cine = new MyThread(righe,colonne,azioneCinema);
            
            //Avvio del thread
            cine.run();
        }
    }
    
}
