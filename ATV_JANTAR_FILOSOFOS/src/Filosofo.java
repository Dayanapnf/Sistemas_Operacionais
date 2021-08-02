public class Filosofo extends Thread{
   Jantar jantar;
   int filosofo;

   //construtor
   public Filosofo (String nome, Jantar j, int filo){
      super(nome);
      jantar = j;
      filosofo = filo;
   }

   //sobrescrevendo
   public void run (){
      int duracao = 0;
      while (true){
         duracao = (int) (Math.random() * 1000);
         pensar(duracao);
         getGarfos();
         duracao = (int) (Math.random() * 1000);
         comer(duracao);
         situacaoGarfos();
      }
   }

   public void pensar (int duracao){
      try{
         sleep(duracao);
      }catch (InterruptedException e){
      }
   }

   public void comer (int duracao){
      try{
         sleep(duracao);
      }catch (InterruptedException e){
      }
   }

   public void getGarfos(){
      jantar.pegarGarfos(filosofo);
   }

   public void situacaoGarfos(){
      jantar.statusGarfos(filosofo);
   }
}