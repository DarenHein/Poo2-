public class Hilo2  extends Thread{
    private int num1 ;
    private int num2 ; 
    private int resultadoresta; 
    
    public Hilo2(int num1 , int num2){
        this.num1 = num1; 
        this.num2 = num2 ; 
    }

    @Override

    public void run(){
        resultadoresta = num1 - num2 ; 
        System.out.println("el resultado de la resta es : " + resultadoresta);
    }
}
