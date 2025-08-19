import java.util.ArrayList;
import java.util.Random;

public class UsaClasses {
    public static void main(String[] args) {

        

        ArrayList<Tank> tanques = new ArrayList<>();
        
        tanques.add(new Tank("Sawyer"));
        tanques.add(new Tank("Jack"));
        tanques.add(new Tank("Kate"));
        tanques.add(new Tank("Hurley"));
        tanques.add(new Tank("Locke"));


        
        for(Tank t : tanques){
            System.out.println("Tanque:" + t);
        }

        Random random = new Random();

        int primeiroTanque = random.nextInt(tanques.size());
        int segundoTanque = random.nextInt(tanques.size());

        System.out.println("Primeiro tanque: " + tanques.get(primeiroTanque));
        if(primeiroTanque == segundoTanque){
            segundoTanque = random.nextInt(tanques.size());
        }
        System.out.println("Segundo tanque: " + tanques.get(segundoTanque));

        tanques.get(primeiroTanque).fire_at(tanques.get(segundoTanque));
        if(tanques.get(segundoTanque).getArmor() <= 0){
            tanques.get(segundoTanque).explode();
        } 


    }
}
