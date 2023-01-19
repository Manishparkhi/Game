import java.util.*;
import java.io.*;

public class TicTacToe {
    static ArrayList<Integer> UserPosition = new ArrayList<>();

    static ArrayList<Integer> CpuPosition = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        char[][] GameBoard = {
                { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' },
        };
        PrintGame(GameBoard);

        while (true) {

            System.out.println("Enter Your Position 1 to 9");
            int pos = scn.nextInt();

            while (UserPosition.contains(pos) || CpuPosition.contains(pos)) {
                System.out.println("Already Exits Position!!");
                System.out.println("Please Enter Valid Position!!");
                pos = scn.nextInt();
            }
            PositionChange(GameBoard, pos, "player1");
            // System.out.println(pos);
            // PrintGame(GameBoard);

            String str = CheckWinner();
            if (str.length() > 0) {
                PrintGame(GameBoard);
                System.out.println(str);

                break;
            }
            // PrintGame(GameBoard);

            Random rand = new Random();
            int pos2 = rand.nextInt(9) + 1;

            while (UserPosition.contains(pos2) || CpuPosition.contains(pos2)) {
                // System.out.println("Already Exits Position");
                pos2 = rand.nextInt(9) + 1;
            }

            PositionChange(GameBoard, pos2, "player2");

            str = CheckWinner();
            if (str.length() > 0) {
                PrintGame(GameBoard);
                System.out.println(str);

                break;
            }
            PrintGame(GameBoard);
        }

    }

    public static void PrintGame(char[][] GameBoard) {

        for (char i = 0; i < GameBoard.length; i++) {
            for (char j = 0; j < GameBoard[0].length; j++) {
                System.out.print(GameBoard[i][j]);
            }
            System.out.println();
        }
    }

    public static void PositionChange(char[][] GameBoard, int pos, String user) {
        char symbol = ' ';

        if (user.equals("player1")) {
            symbol = 'X';
            UserPosition.add(pos);
        } else if (user.equals("player2")) {
            symbol = 'O';
            CpuPosition.add(pos);
        }

        if (pos == 1)
            GameBoard[0][0] = symbol;

        else if (pos == 2)
            GameBoard[0][2] = symbol;
        else if (pos == 3)
            GameBoard[0][4] = symbol;
        else if (pos == 4)
            GameBoard[2][0] = symbol;
        else if (pos == 5)
            GameBoard[2][2] = symbol;
        else if (pos == 6)
            GameBoard[2][4] = symbol;
        else if (pos == 7)
            GameBoard[4][0] = symbol;
        else if (pos == 8)
            GameBoard[4][2] = symbol;
        else if (pos == 9)
            GameBoard[4][4] = symbol;
        else
            System.out.println("Enter Valid Number");
    }

    public static String CheckWinner() {
        List<List> p = new ArrayList<List>();

        List first = Arrays.asList(1, 2, 3);
        List second = Arrays.asList(4, 5, 6);
        List third = Arrays.asList(7, 8, 9);
        List fourth = Arrays.asList(1, 4, 7);
        List fifth = Arrays.asList(2, 5, 8);
        List six = Arrays.asList(3, 6, 9);
        List seven = Arrays.asList(1, 5, 9);
        List eigth = Arrays.asList(3, 5, 7);

        p.add(first);
        p.add(second);
        p.add(third);
        p.add(fourth);
        p.add(fifth);
        p.add(six);
        p.add(seven);
        p.add(eigth);

        for (List val : p) {
            if (UserPosition.containsAll(val))
                return "Congratulation You Won";
            else if (CpuPosition.containsAll(val))
                return "CPU WON sorry (:";
            else if (UserPosition.size() + CpuPosition.size() == 9)
                return "Match Tie";
        }
        return "";
    }
}
