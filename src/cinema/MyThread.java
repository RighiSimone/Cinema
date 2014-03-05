package cinema;

public class MyThread implements Runnable{
    //Variabili di utilizzo
    int r;
    int c;
    int action;
    
    //Costruzione dell'array per le gestione dei posti
    static char postiCinema[][] = new char[10][10];
    
    //Costruisco il costruttore
    public MyThread(int riga, int colonna, int action){
        this.action = action;
        this.c = colonna;
        this.r= riga;
    }
    
    
    synchronized public void run(){
        switch(action){
                //Nel caso venga generato 1 avviene una prenotazione
                case 1:
                    System.out.println("Prenotazione in corso al posto:"+ r + " " + c);
                    if(postiCinema[r][c]!= 'p'){
                        postiCinema[r][c] = 'p';
                    }else{
                        System.out.println("Posto già occupato");
                    }
                    break;
                //Nel caso venga generato 2 avviene un acquisto
                case 2:
                    System.out.println("Acquisto in corso del posto: " + r + " " + c);
                    if(postiCinema[r][c]!='a'){
                        postiCinema[r][c]='a';
                    }else{
                        System.out.println("Posto già occupato");
                    }
                    break;
                //Nel caso venga generato 3 viene annullata la prenotazione
                case 3: 
                    System.out.println("Annullamento prenotazione: ");
                    if(postiCinema[r][c]!='p'){
                        postiCinema[r][c]='.';
                    }
                    else{
                        System.out.println("Il posto non è occupato da nessuno!");
                    }
                    break;
                //Caso default, generazione random errata
                default: 
                    System.out.println("Inserimento non valido");
                    break;
   
        }
     //Stampo la situazione della sala
     stampaCinema();    
    }
    
    //Metodo per la stampa completa del cinema ogni fine run del Thread
    synchronized void stampaCinema(){
        for(int x=0; x<10; x++){
            for(int y=0; y<10; y++){
                    System.out.print(postiCinema[x][y]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
}
