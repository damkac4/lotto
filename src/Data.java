import java.io.*;
import java.util.ArrayList;

public class Data {

    private final String path;


    public Data(String path) {
        this.path = path;
    }

    public User readFile(String login, String haslo) throws IOException {
        File file = new File(path);
        file.createNewFile();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while((line = bufferedReader.readLine()) != null) {
            if(login.equals(line.split(";")[0]) && haslo.equals(line.split(";")[1]))
                return new User(line.split(";")[0],line.split(";")[1],Integer.parseInt(line.split(";")[2]),
                        Integer.parseInt(line.split(";")[3]),Integer.parseInt(line.split(";")[4]),Integer.parseInt(line.split(";")[5]));
        }
        return null;
    }

    public void writeFile(User user) throws IOException {
        File file = new File(path);
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(path, true);
        PrintWriter zapis = new PrintWriter(fileWriter);
        zapis.println(user.getLogin() + ";" + user.getPassword() + ";" + user.getBalance() + ";" + user.getWon() + ";" + user.getLost() + ";" + user.getGames() );
        zapis.close();

    }

    public void updateFile(User user) throws IOException {

        File file = new File(path);
        file.createNewFile();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        ArrayList<String> lines = new ArrayList<>();
        while((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }

            for (int i = 0; i < lines.size(); i++) {
                if(lines.get(i).contains(user.getLogin() + ";" + user.getPassword() + ";")) lines.remove(i);
            }
            lines.add(user.getLogin() + ";" + user.getPassword() + ";" + user.getBalance() + ";" + user.getWon() + ";" + user.getLost() + ";" + user.getGames());
            PrintWriter writer = new PrintWriter(path);
            writer.print("");
            for (int i = 0; i < lines.size(); i++) {
                writer.println(lines.get(i).split(";")[0] + ";" + lines.get(i).split(";")[1] + ";" + lines.get(i).split(";")[2]+
                        ";" + lines.get(i).split(";")[3] + ";" + lines.get(i).split(";")[4] + ";" + lines.get(i).split(";")[5]);
            }
            writer.close();

    }

    public boolean checkUser(String login) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while((line = bufferedReader.readLine()) != null) {
            if(login.equals(line.split(";")[0]))
                return true;
        }
        return false;
    }


}
