import java.io.IOException;
import java.util.Scanner;

public class Game {

    private final Scanner input ;
    private User user ;

    public Game() throws IOException {

        user = new User("","",0,0,0);
        input = new Scanner(System.in);
        menu();

    }

    public void menu() throws IOException {

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
                            break;
                default:
                    System.out.println("\nWrong input");
                    break;
            }

        }
    }

    public void menuUser() throws IOException {

        String value ;

        loop: while (true) {
            System.out.println("\n1. Play");
            System.out.println("2. Check balance");
            System.out.println("3. Add cebulions");
            System.out.println("4. View statistics");
            System.out.println("5. Log out\n");
            value = input.nextLine();


            switch (value){
                case "1":
                    Lotto lotto = new Lotto();
                    user.setBalance((user.getBalance()-10) + lotto.getReward());
                    user.updateUser();
                    break;

                case "2":
                    System.out.println(user.getBalance()+" cebulions");
                    break;

                case "3":
                    System.out.println("\nHow much?");
                    value = input.nextLine();
                    user.setBalance(user.getBalance() + Double.parseDouble(value));
                    System.out.println("\nBalance updated!");
                    break;

                case "4":
                    System.out.println("\nLogged out!");
                    break;

                case "5":
                    System.out.println("\nLogged out!");
                        break loop;

                default:
                    System.out.println("\nWrong input!");
                    break;
            }


        }


    }


}
