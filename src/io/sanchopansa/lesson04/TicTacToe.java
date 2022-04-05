package io.sanchopansa.lesson04;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static char[][] map;
    public static final int SIZE = 3;

    public static final char EMPTY_CELL = '•';
    public static final char X_CELL = 'X';
    public static final char O_CELL = 'O';

    public static String winner = "Draw";

    public static void initializeGame() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = EMPTY_CELL;
            }
        }
    }

    public static void humanTurn() {
        Scanner sc = new Scanner(System.in);
        int x;
        int y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while(isInvalidCell(x, y));
        map[y][x] = X_CELL;
    }

    public static void aiTurn() {
        Random rnd = new Random();
        int x;
        int y;
        do {
            x = rnd.nextInt(SIZE);
            y = rnd.nextInt(SIZE);
        } while(isInvalidCell(x, y));
        map[x][y] = O_CELL;
    }

    private static boolean isInvalidCell(int a, int b) {
        // Некорректный ввод
        if(a < 0 || a >= SIZE && b >= SIZE || b < 0)
            return true;
        if(map[a][b] != EMPTY_CELL)
            return true;
        return false;
    }

    /*private static void checkTwoInRow(char cell) {
        for(int i = 0; i < map.length; i ++) {
            for(int j = 0; j < map[i].length; j++) {

            }
        }
    }*/

    public static void printCurrentStatus(char[][] game) {
        StringBuilder result = new StringBuilder(" 1 2 3\n┌─┬─┬─┐");
        for(int i = 0; i < game.length; i++) {
            result.append("\n│");
            for(int j = 0; j < game[i].length; j++) {
                result.append(game[i][j]).append("│");
            }
        }
        result.append("\n└─┴─┴─┘");
        System.out.println(result);
    }

    public static boolean checkGameOverCondition() {
        int xSigns;
        int oSigns;
        // Горизонтали
        for(int i = 0; i < SIZE; i++) {
            xSigns = 0;
            oSigns = 0;
            for(int j = 0; j < SIZE; j++) {
                if(map[i][j] == X_CELL)
                    xSigns++;
                if(map[i][j] == O_CELL)
                    oSigns++;

                if(xSigns == SIZE) {
                    winner = "X";
                    return true;
                }
                if(oSigns == SIZE) {
                    winner = "O";
                    return true;
                }
            }
        }
        // Вертикали
        for(int j = 0; j < SIZE; j++) {
            xSigns = 0;
            oSigns = 0;
            for(int i = 0; i < SIZE; i++) {
                if(map[i][j] == X_CELL)
                    xSigns++;
                if(map[i][j] == O_CELL)
                    oSigns++;

                if(xSigns == SIZE) {
                    winner = "X";
                    return true;
                }
                if(oSigns == SIZE) {
                    winner = "O";
                    return true;
                }
            }
        }

        // Главная диагональ
        xSigns = 0;
        oSigns = 0;
        for(int i = 0; i < SIZE; i++) {
            if(map[i][i] == X_CELL)
                xSigns++;
            if(map[i][i] == O_CELL)
                oSigns++;

            if(xSigns == SIZE) {
                winner = "X";
                return true;
            }
            if(oSigns == SIZE) {
                winner = "O";
                return true;
            }
        }

        // Побочная диагональ
        xSigns = 0;
        oSigns = 0;
        for(int i = 0; i < SIZE; i++) {
            if(map[i][SIZE - 1 - i] == X_CELL)
                xSigns++;
            if(map[i][SIZE - 1 - i] == O_CELL)
                oSigns++;

            if(xSigns == SIZE) {
                winner = "X";
                return true;
            }
            if(oSigns == SIZE) {
                winner = "O";
                return true;
            }
        }

        // Заполнение
        boolean isFull = true;
        for(int i = 0; i < SIZE; i++)
            for(int j = 0; j < SIZE; j++)
                if(map[i][j] == EMPTY_CELL) {
                    isFull = false;
                    break;
                }
        return isFull;
    }

    public static void main(String[] args) {
        initializeGame();
        printCurrentStatus(map);
        do {
            humanTurn();
            printCurrentStatus(map);
            aiTurn();
            printCurrentStatus(map);
        } while(!checkGameOverCondition());
        if(winner.equals("Draw"))
            System.out.println(winner);
        else
            System.out.printf("%s is winner", winner);
    }
}
