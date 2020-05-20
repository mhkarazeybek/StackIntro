import java.lang.reflect.Array;
import java.util.ArrayList;

public class Stack {

    
/*

L I F O 
            | ♦ |
            | ♦ |
            | ♦ |
            |_♦_| 

*/

//arrays :reference type 
    static int counter=0;
    static GameDVD[] stack =null;
    public static void main(String[] args) {
        GameDVD[] games = {new GameDVD("GTA V",94.0),
                           new GameDVD("Pubg", 20.0),
                           new GameDVD("LoL", 10.0),
                           new GameDVD("Call of Duty MW3", 40.0),
                           new GameDVD("Clash of Clans", 1.0),
                           new GameDVD("GTA V 2",94.0),
                           new GameDVD("Pubg 2", 20.0),
                           new GameDVD("LoL 2", 10.0),
                           new GameDVD("Call of Duty MW3 2", 40.0),
                           new GameDVD("Clash of Clans 2", 1.0)
                            };

        stack = new GameDVD[10];
        for (GameDVD gameDVD : games)
            push(gameDVD);

        getElements();
        System.out.println(stack.length);
        push(new GameDVD("CS Go", 15.0));
        getElements();
        System.out.println(stack.length);

        counter =counter-1;
        System.out.println("---------------------- POP --------------------");
        System.out.println(pop().getName());
        System.out.println(pop().getName());
        System.out.println(stack.length);
        System.out.println(pop().getName());
        System.out.println(pop().getName());
        System.out.println(pop().getName());
        System.out.println(pop().getName());
        System.out.println(pop().getName());
        System.out.println(stack.length);
        System.out.println(counter);

    }

    public static void push(GameDVD gameDVD){
        if(counter >= getStackSize()){
            GameDVD[] temp =new GameDVD[getStackSize()*2];
            for (int i = 0; i < stack.length; i++) {
                temp[i] = stack[i];
            }
            stack = temp;
        }
        Array.set(stack, counter++, gameDVD);
    }

    public static void getElements(){
        for (GameDVD gameDVD : stack)
            if(gameDVD != null)
                System.out.println(gameDVD.getName());
    }

    public static GameDVD pop(){
        if(counter<getStackSize()/2){
            GameDVD[] temp =new GameDVD[getStackSize()/2];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = stack[i];
            }
            stack = temp;
        }
        GameDVD temp = stack[counter];
        stack[counter--]=null;
        return temp;
    }

    public static int getStackSize(){return stack.length;}

}