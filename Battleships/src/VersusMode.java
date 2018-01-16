import java.awt.*;
import java.util.Scanner;

public class VersusMode {

    public static void versus()
    {
        Board p1 = new Board(), p2 = new Board();
        int p1HP, p2HP;
        boolean hit;
        Point attackPlace;
        Scanner scan = new Scanner(System.in);
        System.out.println("Now let player 1 place his ships on the battlefield. No peeking!");
        p1.placeShips();
        for(int i=0;i<50;i++)
        {
            System.out.println();
        }
        System.out.println("It's player 2's turn now. No peeking I said!");
        p2.placeShips();
        for(int i=0;i<50;i++)
        {
            System.out.println();
        }
        p1.drawBothBoards(p2);
        p1HP = p1.getHitCount();
        p2HP = p2.getHitCount();

        while(p1HP > 0 && p2HP > 0)
        {
            hit = false;
            do {
                System.out.println("Player 1 turn.\nYour HP: "+p1HP+"\nPlayer 2's HP: "+p2HP+"\nChoose coordinates you wish to attack: ");
                attackPlace = new Point(scan.nextInt()-1, scan.nextInt()-1);
                if(attackPlace.x > -1 && attackPlace.x < 10 && attackPlace.y > -1 && attackPlace.y < 10 && p2.canIHit(attackPlace))
                {
                    if (!p2.isEmpty(attackPlace))
                    {
                        hit = true;
                        p2.erase(attackPlace, -1);
                        p1.drawBothBoards(p2);
                        p2HP--;
                        System.out.println("Hit!");
                    }
                    else
                    {
                        hit = false;
                        p2.erase(attackPlace, -2);
                        p1.drawBothBoards(p2);
                        System.out.println("Miss!");
                    }

                }
                else
                {
                    System.out.println("Coordinates once used. Choose again");
                    hit = true;
                }

            }while(hit);

            hit = false;

            do {
                System.out.println("Player 2 turn.\nYour HP: "+p2HP+"\nPlayer 1's HP: "+p1HP+"\nChoose coordinates you wish to attack: ");
                attackPlace = new Point(scan.nextInt()-1, scan.nextInt()-1);
                if(attackPlace.x > -1 && attackPlace.x < 10 && attackPlace.y > -1 && attackPlace.y < 10 && p1.canIHit(attackPlace))
                {
                    if (!p1.isEmpty(attackPlace))
                    {
                        hit = true;
                        p1.erase(attackPlace, -1);
                        p1.drawBothBoards(p2);
                        p1HP--;
                        System.out.println("Hit!");
                    }
                    else
                    {
                        hit = false;
                        p1.erase(attackPlace, -2);
                        p1.drawBothBoards(p2);
                        System.out.println("Miss!");
                    }

                }
                else
                {
                    System.out.println("Coordinates once used. Choose again");
                    hit = true;
                }

            }while(hit);
        }
        if(p1HP == 0)
            System.out.println("Player 2 won! Shame on you, Player 1!");
        else
            System.out.println("Player 1 won! Shame on you, Player 2!");


    }


}
