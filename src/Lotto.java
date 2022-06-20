import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

    private ArrayList<Integer> numbersChoosen;
    private ArrayList<Integer> numbersRandom;
    private int checked;
    private int reward;

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public Lotto() {
        numbersChoosen = new ArrayList<>();
        numbersRandom = new ArrayList<>();
        yourNumbers();
        newNumbers();
        check();
    }

    public void yourNumbers(){
        Scanner input = new Scanner(System.in);
        int number;
        System.out.println("\nEnter 6 numbers: ");
        for (int i = 0; i < 6; i++){

            number = input.nextInt();
            if(number<=49 && number>=1 && !numbersChoosen.contains(number)) numbersChoosen.add(number);
            else{
                i--;
                System.out.println("Number beyond of bounds or already entered!");
            }
        }

        System.out.println("Your numbers: ");
        for (int i = 0; i < numbersChoosen.size();i++)
        {
            System.out.print(numbersChoosen.get(i) + " ");
        }




    }

    public void newNumbers(){
        System.out.println("\nNumbers drawn: ");
        Random random = new Random();
        for (int i = 0; i < 6; i++){

            int temp = random.nextInt(49)+1;
            if(!numbersRandom.contains(temp)) {
                numbersRandom.add(temp);
                System.out.print(temp+" ");
            }
            else i--;


        }

    }


    public void check(){
        checked = 0;

        for (int i = 0; i < 6; i++){
            if (numbersChoosen.contains(numbersRandom.get(i))) checked++;

        }
        System.out.println("\nNumbers hit: "+checked);
        System.out.println("Won: "+checked * 10+" cebulions");
        setReward(checked * 10);


    }

}