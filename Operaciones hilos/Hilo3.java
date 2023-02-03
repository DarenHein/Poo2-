public class Hilo3 extends Thread{
    private int num1; 
    private  int num2; 
    private  int resultadoMultiplicacion; 

    public Hilo3(int num1 , int num2){
        this.num1 = num1; 
        this.num2 = num2 ; 
    }
    @Override
    public void run(){

        resultadoMultiplicacion = num1 * num2; 
        System.out.println("el resultado de la multiplicaion es : " + resultadoMultiplicacion);

    }
    
}
