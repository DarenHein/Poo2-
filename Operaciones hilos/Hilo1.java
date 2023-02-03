public class Hilo1 extends Thread{
    private int num; 
    private int num2; 
    private int resultado; 

    public Hilo1(int num, int num2 ){
        this.num = num; 
        this.num2 = num2;
    }

    @Override
    public void run(){
        resultado = num + num2 ; 
        System.out.println("el resultado de la suma es " + resultado);
         
    }
}
