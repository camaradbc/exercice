package test.exercice.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import test.exercice.model.Direction;
import test.exercice.model.Maps;
import test.exercice.model.Position;

public class Adventurer {

    private static final String PATH_AND_FILE_NAME = "resources/carte.txt";

    public static Position play(Position position) {
        boolean rowFirst = true;
        ArrayList<List<String>> bigLists = downloadFile();
        Maps maps = buildMaps(bigLists);
        maps.checkPossibility(position.getX(), position.getY());
        int x = position.getX();
        int y = position.getY();
        if (!maps.getPoints()[x][y].isBlank()) {
            y = position.getX();
            x = position.getY();
            rowFirst = false;
        }
        for (char c : position.getPath()) {
            x = Adventurer.move(x, y, Direction.valueOf(c), maps.getPoints())[0];
            y = Adventurer.move(x, y, Direction.valueOf(c), maps.getPoints())[1];
        }
        if (rowFirst) {
            position.setX(x);
            position.setY(y);
        } else {
            position.setX(y);
            position.setY(x);
        }
        return position;
    }

    private static ArrayList<List<String>> downloadFile() {
        ArrayList<List<String>> bigLists = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(PATH_AND_FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                List<String> listOfChars = new ArrayList<>();

                for (char c : line.toCharArray()) {
                    listOfChars.add(String.valueOf(c));
                }
                bigLists.add(listOfChars);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return bigLists;
    }

    private static Maps buildMaps(ArrayList<List<String>> bigLists) {
        int lines = bigLists.size();
        int column = bigLists.get(0).size();
        String[][] arrayTwoDimension = new String[lines][column];
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < column; j++) {
                arrayTwoDimension[i][j] = bigLists.get(i).get(j);
            }
        }
        return new Maps(arrayTwoDimension);
    }

    private static int[] move(int x, int y, Direction direction, String[][] arrayTwoDimension) {
        int newX = x;
        int newY = y;
        switch (direction) {
            case N -> newX = (x > 0) ? x - 1 : x;
            case S -> newX = (x < arrayTwoDimension.length - 1) ? x + 1 : x;
            case O -> newY = (y > 0) ? y - 1 : y;
            case E -> newY = (y < arrayTwoDimension[0].length - 1) ? y + 1 : y;
        }
        if (!arrayTwoDimension[newX][newY].isBlank()) {
            newX = x;
            newY = y;
        }
        return new int[]{newX, newY};
    }

}
