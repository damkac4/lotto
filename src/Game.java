import java.io.IOException;
import java.util.Scanner;

public class Game {

    private final Scanner input ;
    private User user ;

    public Game() throws IOException {

        user = new User("","",0,0,0,0);
        input = new Scanner(System.in);
        menu();

    }

    public void menu() throws IOException {

        String choice ;

        while (true) {
            System.out.println("\n|MAIN MENU|");
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
            System.out.println("\n|USER MENU|");
            System.out.println("\n1. Play");
            System.out.println("2. Check balance");
            System.out.println("3. Add cebulions");
            System.out.println("4. View statistics");
            System.out.println("5. Log out\n");
            value = input.nextLine();


            switch (value){
                case "1":
                    System.out.println("\n|GAME STARTED|");
                    Lotto lotto = new Lotto();
                    user.setBalance((user.getBalance()-10) + lotto.getReward());
                    user.setWon(user.getWon()+lotto.getReward());
                    user.setLost(user.getLost()+10);
                    user.setGames(user.getGames()+1);
                    user.updateUser();
                    break;

                case "2":
                    System.out.println("\n|BALANCE|");
                    System.out.println(user.getBalance()+" cebulions");
                    System.in.read();
                    break;

                case "3":
                    System.out.println("\n|ADDING CEBULIONS|");
                    System.out.println("How much?");
                    value = input.nextLine();
                    user.setBalance(user.getBalance() + Integer.parseInt(value));
                    System.out.println("\nBalance updated!");
                    break;

                case "4":
                    System.out.println("\n|STATISTICS|");
                    System.out.println("\nGames: "+user.getGames());
                    System.out.println("Won: "+user.getWon());
                    System.out.println("Lost: "+user.getLost());
                    System.out.println("[+/-]: "+ (user.getWon() - user.getLost()));
                    try {

                        System.out.println("Ratio: " + Math.round(Double.valueOf(user.getWon()) / Double.valueOf(user.getLost()) * 100.0)/100.0);


                    } catch (Exception e){

                        System.out.println("Ratio: " + 0.0);
                    }
                    System.in.read();
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
