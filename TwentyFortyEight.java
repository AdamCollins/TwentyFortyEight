package com.githubAdamColins;

import java.util.Scanner;

public class TwentyFortyEight
{

    private static int[][] board;
    private static Scanner in;

    public static void main(String[] args)
    {
        board = new int[4][4];
        in = new Scanner(System.in);
        newBoard();
        playGame();
    }

    private static void playGame()
    {
        String move = "";
        while (!move.equals("exit"))
        {
            printBoard();
            System.out.print("move: ");
            move = in.nextLine();
            switch (move)
            {
                case "up":
                    shiftUp();
                    break;
                case "down":
                    shiftDown();
                    break;
                case "left":
                    shiftLeft();
                    break;
                case "right":
                    shiftRight();
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid move.");
            }
        }
    }

    private static void shiftUp()
    {
        for (int shift = 0; shift < board.length; shift++)
        {
            for (int r = 1; r <= 3; r++)
            {
                for (int c = 0; c < board[0].length; c++)
                {
                    if (board[r][c] == board[r - 1][c] || board[r - 1][0] == 0)
                    {
                        board[r - 1][c] += board[r][c];
                        board[r][c] = 0;
                    }
                }
            }
        }
        addTile();
    }

    private static void shiftDown()
    {
        for (int shift = 0; shift < board.length; shift++)
        {
            for (int r = 2; r >= 0; r--)
            {
                for (int c = 0; c < board[0].length; c++)
                {
                    if (board[r][c] == board[r + 1][c] || board[r + 1][c] == 0)
                    {
                        board[r + 1][c] += board[r][c];
                        board[r][c] = 0;
                    }
                }
            }
        }
        addTile();
    }

    private static void shiftLeft()
    {
        for (int shift = 0; shift < board.length; shift++)
        {
            for (int c = 1; c < board[0].length; c++)
            {
                for (int r = 0; r < board.length; r++)
                {
                    if (board[r][c] == board[r][c - 1] || board[r][c - 1] == 0)
                    {
                        board[r][c - 1] += board[r][c];
                        board[r][c] = 0;
                    }
                }
            }
        }
        addTile();
    }

    private static void shiftRight()
    {
        for (int shift = 0; shift < board[0].length; shift++)
        {
            for (int c = 2; c >= 0; c--)
            {
                for (int r = 0; r < board.length; r++)
                {
                    if (board[r][c] == board[r][c + 1] || board[r][c + 1] == 0)
                    {
                        board[r][c + 1] += board[r][c];
                        board[r][c] = 0;
                    }
                }
            }
        }
        addTile();
    }

    private static void printBoard()
    {
        for (int r = 0; r < board.length; r++)
        {
            for (int c = 0; c < board[0].length; c++)
            {
                System.out.printf("[");
                if(board[r][c]!=0)System.out.printf("%2d",board[r][c]);
                else System.out.print("  ");

                System.out.print("]");
            }
            System.out.println("");
        }
        System.out.println();
    }

    private static void newBoard()
    {
        clearBoard();
        addTile();
        addTile();
    }

    private static void addTile()
    {
        int r = (int) (Math.random() * 4);
        int c = (int) (Math.random() * 4);
        if (board[r][c] == 0)
        {
            if ((int) (Math.random() * 10) == 9)
                board[r][c] = 4;
            else
                board[r][c] = 2;
        } else
        {
            addTile();
        }
    }

    private static void clearBoard()
    {
        for (int r = 0; r < board.length; r++)
        {
            for (int c = 0; c < board[0].length; c++)
            {
                board[r][c] = 0;
            }
        }
    }
}

/*
*  C0 C1 C2 C3
*R0[0][0][0][0]
*R1[0][0][0][0]
*R2[0][0][0][0]
*R3[0][0][0][0]
*
 */
