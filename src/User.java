import java.io.IOException;
import java.util.Scanner;

public class User {
    private String login;
    private String password;
    private double balance;
    final private Data data = new Data("dB.txt");

    public User(String login, String password, double balance) {
        this.login = login;
        this.password = password;
        this.balance = balance;
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
            data.writeFile(new User(tempLogin, tempPassword, 100));

            setLogin(tempLogin);
            setPassword(tempPassword);
            setBalance(100);

            return true;
        }


    }
    public boolean logIn() throws IOException {
        Scanner input = new Scanner(System.in);
        String tempLogin;
        String temmpPassword;


        System.out.println("Type login:");
        tempLogin = input.nextLine();

        System.out.println("Type password:");
        temmpPassword = input.nextLine();

        if(!data.checkUser(tempLogin)){

            System.out.println("User doesn't exist");
            return false;

        }else {
            User user =  data.readFile(tempLogin,temmpPassword);
            if(user == null) {
                System.out.println("Wrong password");
                return false;
            }else {
                setLogin(user.login);
               setPassword(user.password);
               setBalance(user.balance);

                return true;

            }

        }

    }

    public void updateUser() throws IOException {

        User user = new User(this.login,this.password,this.balance);
        data.updateFile(user);
    }


    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }
}
