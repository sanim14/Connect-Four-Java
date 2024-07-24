import java.util.Scanner;
public class MainFile
{
    public static void main (String [] args)
    {
        int column = 0;
        int player = ConnectFourGame.RED;
        boolean s = true;
        ConnectFourGame connectFour = new ConnectFourGame();

        Scanner keyboard = new Scanner (System.in);

        while (s == true)
        {
            connectFour.draw();
            if (player == connectFour.RED)
            {
                System.out.print("\nRed enter a column for your move (0-6): ");
                column =  keyboard.nextInt();

                if (connectFour.dropPiece(column, player) == true)
                {
                    if (connectFour.status() == ConnectFourGame.RED_WINS)
                    {
                        System.out.println("Red wins!");
                        connectFour.draw();
                        break;
                    }
                    else if (connectFour.status() == ConnectFourGame.BLACK_WINS)
                    {
                        System.out.println("Black wins!");
                        connectFour.draw();
                        break;
                    }
                    else if (connectFour.status() == ConnectFourGame.DRAW)
                    {
                        System.out.println("No one wins :(");
                        connectFour.draw();
                        break;
                    }
                    else if (connectFour.status() == ConnectFourGame.PLAYING)
                    {
                        player = ConnectFourGame.BLACK;
                        continue;
                    }
                }
                else
                {
                    System.out.print("Invalid\n");
                    continue;
                }
            }
            else
            {
                System.out.print("\nBlack enter a column for your move (0-6): ");
                column =  keyboard.nextInt();

                if (connectFour.dropPiece(column, player) == true)
                {
                    if (connectFour.status() == ConnectFourGame.RED_WINS)
                    {
                        System.out.println("Red wins!");
                        connectFour.draw();
                        break;
                    }
                    else if (connectFour.status() == ConnectFourGame.BLACK_WINS)
                    {
                        System.out.println("Black wins!");
                        connectFour.draw();
                        break;
                    }
                    else if (connectFour.status() == ConnectFourGame.DRAW)
                    {
                        System.out.println("No one wins :(");
                        connectFour.draw();
                        break;
                    }
                    else if (connectFour.status() == ConnectFourGame.PLAYING)
                    {
                        player = ConnectFourGame.RED;
                        continue;
                    }
                }
                else
                {
                    System.out.print("Invalid\n");
                    continue;
                }
            }

        }
    }
}
