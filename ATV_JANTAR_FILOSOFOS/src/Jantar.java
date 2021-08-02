public class Jantar{

    
    boolean[] garfos = new boolean[5];
    int[] filosofos = new int[5];
    final static int PENSANDO = 1;
    final static int COMENDO = 2;
    final static int FOME = 3;
   
    // instanciando os garfos e os filosofos
    public Jantar(){
        for (int i = 0; i < 5; i++){
            garfos[i] = true;
            filosofos[i] = PENSANDO;
        }
    }

    

    public synchronized void statusGarfos (int filosofo){
        garfos[garfoEsquerdo(filosofo)] = true;
        garfos[garfoDireito(filosofo)] = true;
        if (filosofos[L_esquerdo(filosofo)] == FOME || filosofos[L_direito(filosofo)] == FOME){
            notifyAll();
        }
        filosofos[filosofo] = PENSANDO;
            printFilosofos();
    }

    public int garfoEsquerdo (int filosofo){
        int garfoEsquerdo = filosofo;
        return garfoEsquerdo;
    }

    public int garfoDireito (int filosofo){
        int garfoDireito;
        if (filosofo == 4){
            garfoDireito = 0;
        }
        else{
            garfoDireito = filosofo + 1;
        }
        return garfoDireito;
    }
    
    public synchronized void pegarGarfos (int filosofo){
        filosofos[filosofo] = FOME;
        while (filosofos[L_esquerdo(filosofo)] == COMENDO || filosofos[L_direito(filosofo)] == COMENDO){
            try {
               wait();
            }
            catch (InterruptedException e){
            }
        }
        // MUDANDO O ESTADO DO GARFO .
        garfos[garfoEsquerdo(filosofo)] = false;
        garfos[garfoDireito(filosofo)] = false;
        filosofos[filosofo] = COMENDO;
        printFilosofos();
    }

    public int L_direito (int filosofo){
        int direito;
        if (filosofo == 4){
            direito = 0;
        }
        else{
            direito = filosofo + 1;
        }
        return direito;
    }

    public int L_esquerdo (int filosofo){
        int esquerdo;
        if (filosofo == 0){
            esquerdo = 4;
        }
        else{
            esquerdo = filosofo - 1;
        }
        return esquerdo;
    }

    

    public void printFilosofos (){
        String texto = "*";
      
        for (int i = 0; i < 5; i++){
            switch (filosofos[i]){
                case COMENDO :
                    if(i==0)
                        texto = "COMENDO COM O GARFO: " + (i+1)+ " e 5 "   ;
                    else texto = "COMENDO COM O GARFO: " + i + " e " + (i+1)   ;
                    break;
                case FOME :
                    texto = "PENSANDO";
                    break;
                case PENSANDO :
                    texto = "PENSANDO";
                    break;
                default:  
                
            }
            System.out.print("Filósofos_" + (i+1) + " : ");
            System.out.print(texto + " ");
            System.out.println("");
        
        }
        System.out.println("******************************");
   }

}