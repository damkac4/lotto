import java.io.IOException;
import java.util.Scanner;

public class Game {

    Scanner input ;
    User user ;

    public Game() throws IOException {
        user = new User("","",0);
        input = new Scanner(System.in);
        menu();

    }

    public boolean menu() throws IOException {
        String choice ;
        while (true) {
            System.out.println("\n1. Log in");
            System.out.println("2. Sign in");
            System.out.println("3. Quit\n");
            choice = input.nextLine();


            switch (choice){
               case "1": if(user.logIn()) menuUser();
                            break;
                case "2":  if(user.signIn())menuUser();
                            break;
                case "3": System.exit(1);

                default:
                    System.out.println("\nWrong input");
                    break;
            }

        }
    }

    public void menuUser() throws IOException {
        String choice2 ;
        loop: while (true) {
            System.out.println("\n1. Play");
            System.out.println("2. Check balance");
            System.out.println("3. Log out\n");
            choice2 = input.nextLine();


            switch (choice2){
                case "1":
                    Lotto lotto = new Lotto();
                    user.setBalance((user.getBalance()-10) + lotto.getReward());
                    user.updateUser();
                    break;

                case "2":
                    System.out.println(user.getBalance()+" cebulions");
                    break;

                case "3":
                    System.out.println("\nLogged out!");
                        break loop;

                default:
                    System.out.println("\nWrong input!");
                    break;
            }


        }


    }


}
