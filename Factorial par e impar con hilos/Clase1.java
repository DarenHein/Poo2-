public class Clase1 extends Thread {
    long i ; 
    long contador =1 ; 
    long resultado ; 
    @Override
    public void run(){
        System.out.println("\n**************FACTORIALES***************");

        for( i = 1 ; i <=50 ; i++){
            contador = contador * i ; 
            resultado = contador; 
            System.out.println("El factorial de : " + i + "! es : " + contador);
            
            try {
                Clase1.sleep(1000); 
                
            } catch (InterruptedException e) {
                // TODO: handle exception
                System.out.println("erroe en sleep");
            }
        }

        System.out.println("************************************************");
    }
    
}
