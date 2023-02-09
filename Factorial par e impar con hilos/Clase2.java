public class Clase2 extends Thread{

    @Override
    public void run(){
        int n;
    int contador=0;
    System.out.println("************* NUMEROS PARES DEL 1 - 10 ********************* ");
    for (n=1;n<=10;n++){
    if (n % 2!=0) {
    System.out.print(""+n+"\n");
    contador=contador+n;    
    }    
    }    
    System.out.print("la suma de los impares" + contador +"\n");
    System.out.print("*********************");
    }
    }

