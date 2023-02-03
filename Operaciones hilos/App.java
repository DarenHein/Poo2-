import java.util.Scanner; 
public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in); 
      int num ; 
      int num2 ; 

      Hilo1  obj ;// suma  
      Hilo2 obj2; // resta 
      Hilo3 obj3 ; //multiplicacion 
      Hilo4 obj4 ; // divicion

      System.out.println("ingresa el primer numero ");
      num = entrada.nextInt(); 
      System.out.println("ingrese el segundo numero ");
      num2 = entrada.nextInt(); 
      obj = new Hilo1(num, num2); 
      obj.start();

      try{

        obj.sleep(1000);

      }catch(InterruptedException e){
        System.out.println("erroe en hilo 1");
      }
      System.out.println("\n");
      System.out.println("\t RESTA ");
      System.out.println("ingresa el primer numero ");
      num = entrada.nextInt(); 
      System.out.println("ingrese el segundo numero ");
      num2 = entrada.nextInt();
      obj2 = new Hilo2(num, num2); 
      
      obj2.start();

      try{
            obj2.sleep(1000);
      }catch(InterruptedException e){
        System.out.println("error hilo 2 ");
      }

      System.out.println("\n");
      System.out.println("\t Multiplicaion ");
      System.out.println("ingresa el primer numero ");
      num = entrada.nextInt(); 
      System.out.println("ingrese el segundo numero ");
      num2 = entrada.nextInt();
      obj3 = new Hilo3(num, num2); 
      obj3.start();
      try{
        obj3.sleep(1000);
      }catch(InterruptedException e){
        System.out.println("error en el hilo 3 ");
      }

      try {
        System.out.println("\n");
      System.out.println("\t Divicion ");
      System.out.println("ingresa el primer numero ");
      num = entrada.nextInt(); 
      System.out.println("ingrese el segundo numero ");
      num2 = entrada.nextInt();
      obj4 = new Hilo4(num, num2); 
      obj.start();
      try{
        obj4.sleep(1000);
      }catch(InterruptedException e){
        System.out.println("error en el hilo4 ");
      }
      } catch (Exception e) {
        System.out.println("valor invalido");
      }








    }
}
