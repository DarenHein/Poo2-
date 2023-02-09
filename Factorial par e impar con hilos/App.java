import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {

        Pares eje1 = new Pares();
        eje1.start();
        try {
            eje1.join();
        } catch (InterruptedException e) {
            // TODO: handle exception
            System.out.println("error en el join ");

        }
        try {
            eje1.sleep(1000); 
        } catch (InterruptedException e) {
            // TODO: handle exception
            System.out.println("error en Sleep");
        }
    
        Clase1 obj = new Clase1(); 
        obj.start();
        try {
            obj.join();
        } catch (InterruptedException e) {
            // TODO: handle exception
            System.out.println("erro en join ");
        }
        try {
            obj.sleep(1000);
        } catch (InterruptedException e) {
            // TODO: handle exception
            System.out.println("erroe en el sleep");

        }
        Clase2 obj2 = new Clase2(); 
        obj2.start();
        try {
            obj2.join();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("erroe en join ");
        }

        

    }
}
