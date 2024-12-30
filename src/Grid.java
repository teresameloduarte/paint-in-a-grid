import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private Rectangle rectangle;

    public static final int PADDING = 10;
    private static final int CELL_SIZE = 30;

    private final int gridWidth = 600;
    private final int gridHeight = 600;


    public int getCellSize() {
        return CELL_SIZE;
    }

    public int getGridHeight() {
        return gridHeight;
    }

    public int getGridWidth() {
        return gridWidth;
    }

    public Grid() {

        this.rectangle = new Rectangle(PADDING, PADDING, gridWidth, gridHeight);
        rectangle.draw();
        drawGrid();
    }

    private void drawGrid() {
        for (int i = 10; i <= gridWidth + PADDING; i += CELL_SIZE) {
            Line lineX = new Line(i, PADDING, i, gridHeight + PADDING);
            lineX.draw();
        }

        for (int i = 10; i <= gridHeight + PADDING; i += CELL_SIZE) {
            Line lineY = new Line(PADDING, i, gridWidth + PADDING, i);
            lineY.draw();
        }
    }
}

