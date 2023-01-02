import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> popularNames = new ArrayList<>();
        popularNames.add("Dominykas");
        popularNames.add("Gabriele");
        popularNames.add("Karolis");

        System.out.println("Sveiki atvyke i populiariausiu lietuvisku vardu sarasa");

        boolean shouldGo = true;
        Scanner sc = new Scanner(System.in);

        while (shouldGo) {
            intro();
            int choise = 0;

            try {
                choise = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Iveskite teisinga skaiciaus formata");
            }

            sc.nextLine();
            switch (choise) {
                case 1:
                    show(popularNames);
                    break;
                case 2:
                    add(sc, popularNames);
                    break;
                case 3:
                    edit(sc, popularNames);
                    break;
                case 4:
                    delete(sc, popularNames);
                    break;
                case 5:
                    System.out.println("iki kito karto");
                    shouldGo = false;
                    break;
            }

        }
    }

    public static void intro() {
        System.out.println("Pasirinkite ka norite daryt");
        System.out.println("1. Pamatyti vardus");
        System.out.println("2. Prideti varda");
        System.out.println("3. Redaguoti varda");
        System.out.println("4. Istrinti varda");
        System.out.println("5. Iseiti is programos");
    }

    public static void show(ArrayList<String> popularNames) {
        for (int i = 0; i < popularNames.size(); i++) {
            System.out.println((i+1) + ". " + popularNames.get(i));
        }
    }

    public static void add(Scanner sc, ArrayList<String> popularNames) {
        System.out.println("Iveskite varda");
        popularNames.add(sc.nextLine());
        System.out.println("aciu, vardas pridetas");
    }

    public static void delete(Scanner sc, ArrayList<String> popularNames) {
        System.out.println("kelinta varda norite istrinti?");
        int ind = sc.nextInt();
        sc.nextLine();
        popularNames.remove(ind - 1);
        System.out.println("vardas sekmingai pasalintas");
    }

    public static void edit(Scanner sc, ArrayList<String> popularNames) {
        System.out.println("iveskite vardo, kuri norite redaguoti, numeri");
        int pos = 0;
        while (true) {
            try {
                pos = sc.nextInt();
                break;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("iveskite teisinga skaiciu");
            }
        }
        sc.nextLine();
        System.out.println("jus norite redaguoti varda "+popularNames.get(pos -1)+" pozicijoje "+pos);
        System.out.println("iveskite nauja varda");
        popularNames.set(pos - 1, sc.nextLine());
        System.out.println("vardas sekmingai pakoreguotas");
    }
}