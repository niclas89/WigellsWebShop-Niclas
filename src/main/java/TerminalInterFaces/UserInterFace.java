package TerminalInterFaces;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterFace {

    public void UserInterFace(){

    };


    public int start(){
        System.out.println( "1:Show Product list    2:Show shopping Cart" +
                '\n' + "3: Exit" );
        return inputHandler(1,3);
    }
    public String usersName(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello and welcome to Wigells Webshopp!" + '\n' + "Please enter your name");
        return scan.nextLine();
    }
    public int completePurchase(int products){
        System.out.println("You have " + products + " products in your shopping cart");
        System.out.println("1:Complete Order    2:Continue shopping");
        return inputHandler(1,2);
    }

    public int productList() {
        int answer;
        boolean input = true;
        System.out.println("1:Tshirt    2: Skirt");
        System.out.println("3:Pants");
        return inputHandler(1,3);

    }



    public String chooseColor(){
        System.out.println("Choose color");
        System.out.println("1:Blue    2:Black");
        String color = "";
        switch (inputHandler(1,2)){
            case 1: color = "Blue";
            break;
            case 2: color = "Black";
            break;
        }
        return color;
    }
    public int chooseLength(){
        int length;
        System.out.println("Choose Length");
        System.out.println("1:130cm    2:140cm" + '\n'+"3:150cm");
        switch (inputHandler(1,3)){
            case 1: length = 130;
            break;
            case 2: length = 140;
            break;
            default: length = 150;
        }
        return length;
    }

    public String chooseSize(){
        System.out.println("Choose Size");
        System.out.println("1: Regular    2:Large");
        String size = "";
        switch (inputHandler(1,2)){
            case 1: size = "Regular";
            break;
            case 2: size = "Large";
        }
        return size;
    }

    public static  int inputHandler(int min, int max){
        boolean input = true;
        Scanner scan = new Scanner(System.in);
        int answer = 0;
            while(input) {
                try {
                    answer = scan.nextInt();
                    if(answer >= min && answer <= max){
                        input = false;
                    }
                } catch (InputMismatchException ex) {
                    return inputHandler(min,max);
                }
            }
            return answer;
    }
}
