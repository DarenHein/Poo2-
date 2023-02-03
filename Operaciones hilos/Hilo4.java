import java.time.chrono.ThaiBuddhistChronology;

public class Hilo4  extends Thread{
    private int num1 ; 
    private int num2 ; 
    private int resultadodiv; 

    public Hilo4(int num1 , int num2 ){
        this.num1 = num1 ; 
        this.num2 = num2 ; 

    }

    @Override
    public void run(){
        resultadodiv = num1 / num2 ; 
        System.out.println("el resultado de la divicion es : " + resultadodiv);
    }
    
    
}
