import java.io.IOException;
import java.util.Scanner;

public class User {
    private String login;
    private String password;
    private int balance;
    private int won;
    private int lost;
    private int games;
    private final Data data = new Data("dB.txt");

    public User(String login, String password, int balance, int won, int lost, int games) {
        this.login = login;
        this.password = password;
        this.balance = balance;
        this.won = won;
        this.lost = lost;
        this.games = games;
    }

    public boolean signIn() throws IOException {
        Scanner input = new Scanner(System.in);
        String tempLogin;
        String tempPassword;

        System.out.println("Type login: ");
        tempLogin = input.nextLine();

        if(data.checkUser(tempLogin)){

            System.out.println("User already exists");
            return false;

        }else {
            System.out.println("Type password: ");
            tempPassword = input.nextLine();
            data.writeFile(new User(tempLogin, tempPassword, 100,0,0,0));

            this.setLogin(tempLogin);
            this.setPassword(tempPassword);
            this.setBalance(100);
            this.setLost(0);
            this.setWon(0);
            this.setGames(0);

            return true;
        }


    }
    public boolean logIn() throws IOException {
        Scanner input = new Scanner(System.in);
        String tempLogin;
        String tempPassword;


        System.out.println("Type login:");
        tempLogin = input.nextLine();



        if(!data.checkUser(tempLogin)){

            System.out.println("User doesn't exist");
            return false;

        }else {
            System.out.println("Type password:");
            tempPassword = input.nextLine();
            User user =  data.readFile(tempLogin,tempPassword);
            if(user == null) {
                System.out.println("Wrong password");
                return false;

            }else {

                this.setLogin(user.login);
                this.setPassword(user.password);
                this.setBalance(user.balance);
                this.setWon(user.won);
                this.setLost(user.lost);
                this.setGames(user.games);
                return true;

            }
        }
    }
    public void updateUser() throws IOException { data.updateFile(new User(this.login,this.password,this.balance,this.won,this.lost,this.games)); }

    public void setGames(int games) { this.games = games; }

    public int getGames() { return games; }

    public void setWon(int won) { this.won = won; }

    public int getWon() { return won; }

    public void setLost(int lost) { this.lost = lost; }

    public int getLost() { return lost; }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }
}
