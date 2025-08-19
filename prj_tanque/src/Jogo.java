import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.*;

public class Jogo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        ArrayList<Tank> tanks = new ArrayList<>();

        int numTanks = 0;
        while (numTanks < 2 || numTanks > 10) {
            System.out.print("Quantos tanques deseja criar? (2 a 10): ");
            numTanks = scanner.nextInt();
            scanner.nextLine();
        }

        for (int i = 0; i < numTanks; i++) {
            System.out.print("Digite o nome do tanque #" + (i + 1) + ": ");
            String name = scanner.nextLine();
            tanks.add(new Tank(name));
        }

        int rodada = 1;
        while (contarTanquesVivos(tanks) > 1) {
            System.out.println("\n===== RODADA " + rodada + " =====");

            ArrayList<Tank> ordemDaRodada = new ArrayList<>(tanks);
            Collections.shuffle(ordemDaRodada);

            for (Tank atirador : ordemDaRodada) {
                if (!atirador.isAlive()) continue;

                List<Tank> alvos = new ArrayList<>();
                for (Tank t : tanks) {
                    if (t != atirador && t.isAlive()) {
                        alvos.add(t);
                    }
                }

                if (alvos.isEmpty()) break;

                System.out.println("\n" + atirador.getName() + ", escolha um inimigo para atirar:");
                for (int i = 0; i < alvos.size(); i++) {
                    System.out.println(i + ": " + alvos.get(i).getName());
                }

                int escolha = -1;
                while (escolha < 0 || escolha >= alvos.size()) {
                    System.out.print("Digite o número do inimigo: ");
                    escolha = scanner.nextInt();
                }

                atirador.fire_at(alvos.get(escolha));
            }

            System.out.println("\n=== STATUS APÓS RODADA " + rodada + " ===");
            for (Tank t : tanks) {
                System.out.println(t);
            }

            rodada++;
        }

        System.out.println("\n===== FIM DE JOGO =====");
        for (Tank t : tanks) {
            if (t.isAlive()) {
                System.out.println("Vencedor: " + t.getName() + "!");
            }
        }

        scanner.close();
    }

    public static int contarTanquesVivos(ArrayList<Tank> tanks) {
        int vivos = 0;
        for (Tank t : tanks) {
            if (t.isAlive()) vivos++;
        }
        return vivos;
    }
}



        

        





