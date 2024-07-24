public class ConnectFourGame {
    public static final int PLAYING = 0;
    public static final int RED_WINS = 1;
    public static final int BLACK_WINS = 2;
    public static final int DRAW = 3;
    public static final int RED = 4;
    public static final int BLACK = 5;
    public static final int EMPTY = 6;
    private int[][] board = new int[6][7];

    public ConnectFourGame()
    {
        for(int r = 0; r < board.length; r++)
        {
            for(int c = 0; c < board[0].length; c++)
            {
                board[r][c] = EMPTY;
            }
        }

    }

    public boolean dropPiece(int column, int player)
    {
        if (column <= 6 && column >= 0)
        {
            if (player != RED && player != BLACK)
            {
                return false;
            }
            else
            {
                for (int r = (board.length-1); r >= 0; r--)
                {
                    if (board [r][column] != EMPTY)
                    {
                        continue;
                    }
                    else
                    {
                        board[r][column] = player;
                        return true;
                    }
                }
                System.out.print(column);
                return false;
            }

        }
        else
        {
            return false;
        }
    }

    public int status()
    {
        int r;
        int c;

        for(r = 0; r < 6; r++)
        {
            for(c = 0; c <= 3; c++)
            {
                if (board[r][c] == RED && board[r][c + 1] == RED && board[r][c + 2] == RED && board[r][c + 3] == RED) 
                {
                    return RED_WINS;
                }

                if (board[r][c] == BLACK && board[r][c + 1] == BLACK && board[r][c + 2] == BLACK && board[r][c + 3] == BLACK) 
                {
                    return BLACK_WINS;
                }
            }
        }

        for(r = 0; r < 3; r++)
        {
            for(c = 0; c <= 3; c++)
            {
                if (board[r][c] == RED && board[r + 1][c] == RED && board[r + 2][c] == RED && board[r + 3][c] == RED)
                {
                    return RED_WINS;
                }

                if (board[r][c] == BLACK && board[r + 1][c] == BLACK && board[r + 2][c] == BLACK && board[r + 3][c] == BLACK)
                {
                    return BLACK_WINS;
                }
            }
        }

        for(r = 0; r < 3; r++)
        {
            for(c = 0; c <= 3; c++)
            {
                if (board[r][c] == RED && board[r + 1][c + 1] == RED && board[r + 2][c + 2] == RED && board[r + 3][c + 3] == RED)
                {
                    return RED_WINS;
                }

                if (board[r][c] == BLACK && board[r + 1][c + 1] == BLACK && board[r + 2][c + 2] == BLACK && board[r + 3][c + 3] == BLACK)
                {
                    return BLACK_WINS;
                }
            }
        }

        for(r = 0; r < 3; r++)
        {
            for(c = 3; c <= 6; c++)
            {
                if (board[r + 3][c - 3] == RED && board[r + 2][c - 2] == RED && board[r + 1][c - 1] == RED && board[r][c] == RED)
                {
                    return RED_WINS;
                }

                if (board[r + 3][c - 3] == BLACK && board[r + 2][c - 2] == BLACK && board[r + 1][c - 1] == BLACK && board[r][c] == BLACK)
                {
                    return BLACK_WINS;
                }
            }
        }

        for(r = 3; r < 6; r++)
        {
            for(c = 3; c <= 6; c++)
            {
                if (board[r - 3][c - 3] == RED && board[r - 2][c - 2] == RED && board[r - 1][c - 1] == RED && board[r][c] == RED)
                {
                    return RED_WINS;
                }

                if (board[r - 3][c - 3] == BLACK && board[r - 2][c - 2] == BLACK && board[r - 1][c - 1] == BLACK && board[r][c] == BLACK)
                {
                    return BLACK_WINS;
                }
            }
        }

        for(r = 0; r < board[0].length; r++)
        {
            if (columnFull(r) != true)
            {
                return PLAYING;
            }
        }

        return DRAW;
    }

    public boolean columnFull(int column)
    {
        for(int r = 0; r < board.length; r++)
        {
            if (board[r][column] == EMPTY)
            {
                return false;
            }
        }

        return true;
    }

    public void draw() 
    {
        for(int r = 0; r < board.length; r++)
        {
            System.out.print("|");

            for(int c = 0; c < board[0].length; c++)
            {
                if (board[r][c] == RED)
                {
                    System.out.print("R");
                }
                else if (board[r][c] == BLACK)
                {
                    System.out.print("B");
                }
                else if (board[r][c] == EMPTY)
                {
                    System.out.print(" ");
                }

                System.out.print("|");
            }

            System.out.print("\n");
        }

        System.out.print("---------------");
    }

    public int getSpot(int col, int row)
    {
        if (row < board[0].length && row >= 0)
        {
            if (col < board.length && col >= 0)
            {
                return board[col][row];
            }
            else
            {
                return -1;
            }
        }
        else
        {
            return -1;
        }
    }
}
