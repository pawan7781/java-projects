import java.util.Scanner;

class guesser
{
    int guessnum;
    public int guessnumber()
    {
        Scanner scan= new Scanner(System.in);
        System.out.println("player! guess one number");
        int guessnum= scan.nextInt();
       
            return guessnum;
    }
        
}

class players
{
    int pguessnum;
    public int pguessnumber()
    {
        System.out.println("player! guess one number");
        Scanner scan= new Scanner(System.in);
        int pguessnum= scan.nextInt();
        return pguessnum;

    }
}
class umpire
{
    int numFromGuesser;
    int numFromPlayer1;
    int numFromPlayer2;
    int numFromPlayer3;
    void collectnumFromGuesser()
    {
        guesser g = new guesser();
        numFromGuesser=g.guessnumber();

    }
    void collectnumFromPlayers()
    {
        players p1 =new players();
        players p2 =new players();
        players p3 = new players();

        numFromPlayer1= p1.pguessnumber();
        numFromPlayer2= p2.pguessnumber();
        numFromPlayer3= p3.pguessnumber();
    }

    void compare()
    {
        
        if(numFromGuesser==numFromPlayer1)
        {
            if(numFromGuesser==numFromPlayer2 && numFromGuesser==numFromPlayer3)
            {
                System.out.println("player1 player2 and player3 are winners");
                
            }
            else if(numFromGuesser== numFromPlayer2)
            {
                System.out.println("player 1 and player 2");
            }
            else if(numFromGuesser== numFromPlayer3)
            {
                System.out.println("player 1 and player 3 are winner");
            }
            else
            {
                System.out.println("hurrey! player1 won!");
            }
           
        }
        else if(numFromGuesser==numFromPlayer2)
        {
            if(numFromGuesser == numFromPlayer3)
            {
                System.out.println(" player 2 and player 3 are winner");
            }
            else
            {
            System.out.println("hurrey! player2 won!");
            }
        }
        else if(numFromGuesser==numFromPlayer3)
        {
            System.out.println("hurrey! player3 won!");
        }
        else
        {
            System.out.println("ohhh! you all are lost the game");
        }

    }

}
public class game1
{ 
    public static void main(String []args)
    {
        umpire ump = new umpire();
        ump.collectnumFromGuesser();
        ump.collectnumFromPlayers();
        ump.compare();
    }
}