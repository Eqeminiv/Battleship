import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to this simple battleship console game. Recommendation - maximize your terminal.");
        int option=0;

        while(true)
        {
            System.out.println("Choose option: \n1. Versus match\n2. Exit");
            option = scan.nextInt();
            switch(option)
            {
                case 1:
                {
                    VersusMode.versus();
                    break;
                }
                case 2:
                {
                    System.exit(0);
                }
                default:
                {
                    System.out.println("Incorrect command.");
                    break;
                }
            }
            if (option == 1)
                break;
        }


    }
}
