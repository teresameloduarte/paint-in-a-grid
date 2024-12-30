import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;

import java.io.*;
import java.util.LinkedList;

public class Player {
    Rectangle player;
    Grid grid;
    String name;

    public Player(String name, Grid grid) {
        this.name = name;
        this.grid = grid;
        player = new Rectangle(Grid.PADDING, Grid.PADDING, grid.getCellSize(), grid.getCellSize());
        player.fill();
        player.setColor(Color.BLUE);
        player.translate(grid.getCellSize(), 0);
    }

    public void moveLeft() {
        if (player.getX() > grid.getCellSize()) {
            player.translate(-grid.getCellSize(), 0);
        }
    }

    public void moveRight() {
        if (player.getX() < grid.getGridHeight() - grid.getCellSize()) {
            player.translate(grid.getCellSize(), 0);
        }
    }

    public void moveUp() {
        if (player.getY() > grid.getCellSize()) {
            player.translate(0, -grid.getCellSize());
        }
    }

    public void moveDown() {
        if (player.getY() < grid.getGridWidth() - grid.getCellSize()) {
            player.translate(0, grid.getCellSize());
        }
    }

    LinkedList<Rectangle> paintedCells = new LinkedList<Rectangle>();

    public void paintCell() {

        int cellX = (player.getX() / grid.getCellSize()) * grid.getCellSize();
        int cellY = (player.getY() / grid.getCellSize()) * grid.getCellSize();
        Rectangle paintedRectangle = new Rectangle(cellX + Grid.PADDING, cellY + Grid.PADDING, grid.getCellSize(), grid.getCellSize());

        if (isCellPainted(cellX, cellY)) {
            deleteCell(cellX, cellY);
        } else {
            paintedRectangle.fill();
            paintedCells.add(paintedRectangle);
        }
    }

    private boolean isCellPainted(int cellX, int cellY) {
        for (Rectangle rect : paintedCells) {
            if (rect.getX() == cellX + Grid.PADDING && rect.getY() == cellY + Grid.PADDING) {
                return true;
            }
        }
        return false;
    }

    private void deleteCell(int cellX, int cellY) {
        for (Rectangle rect : paintedCells) {
            if (rect.getX() == cellX + Grid.PADDING && rect.getY() == cellY + Grid.PADDING) {
                rect.delete();
                paintedCells.remove(rect);
                break;
            }
        }
    }
    public void savePaintedCellsToFile(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int y = 0; y < grid.getGridHeight(); y++) {
                for (int x = 0; x < grid.getGridWidth(); x++) {
                    if (isCellPainted (x * grid.getCellSize(), y * grid.getCellSize())) {
                        writer.write("1");
                        writer.newLine();
                        writer.flush();
                    } else {
                        writer.write("0");
                        writer.newLine();
                        writer.flush();
                    }
                }
            }
        }
    }

    public void loadPaintedCellsToFile(String filePath) throws IOException{
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                int y = 0;

                while ((line = reader.readLine()) != null && y < grid.getGridHeight()) {
                    for (int x = 0; x < line.length() && x < grid.getGridWidth(); x++) {
                        char cell = line.charAt(x);
                        if (cell == '1') {
                            int cellX = x * grid.getCellSize();
                            int cellY = y * grid.getCellSize();
                            Rectangle paintedRectangle = new Rectangle(cellX + Grid.PADDING, cellY + Grid.PADDING, grid.getCellSize(), grid.getCellSize());
                            paintedCells.add(paintedRectangle);
                            paintedRectangle.fill();
                        }
                    }
                    y++;
                }
            }
        }
    public void clearGrid() {
        for (Rectangle rect : paintedCells) {
            rect.delete();
        }
        paintedCells.clear();
    }
}

