public class JantarDosFilosofos{
   public static void main (String[] args){
      Jantar jantar = new Jantar ();
      
      for (int i = 0; i < 5; i++){
         new Filosofo("Filosofo_" + i, jantar, i).start();
      }
   }
}  