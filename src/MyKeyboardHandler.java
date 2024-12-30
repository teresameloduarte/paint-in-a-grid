import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.IOException;

public class MyKeyboardHandler implements KeyboardHandler {

    private Keyboard keyboard;

    private Player player;

    public MyKeyboardHandler(Player player){
        keyboard = new Keyboard(this);
        setKeyboardEvents();
        this.player = player;

    }

    private void setKeyboardEvents() {
        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);

        KeyboardEvent paint = new KeyboardEvent();
        paint.setKey(KeyboardEvent.KEY_SPACE);
        paint.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(paint);

        KeyboardEvent save = new KeyboardEvent();
        save.setKey(KeyboardEvent.KEY_S);
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(save);

        KeyboardEvent load = new KeyboardEvent();
        load.setKey(KeyboardEvent.KEY_L);
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(load);

        KeyboardEvent clean = new KeyboardEvent();
        clean.setKey(KeyboardEvent.KEY_C);
        clean.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(clean);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT){
            player.moveLeft();
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT){
            player.moveRight();
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_UP){
            player.moveUp();
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN){
            player.moveDown();
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE){
            player.paintCell();
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_S){
            try {
                player.savePaintedCellsToFile("resources/grid.txt");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_L){
            try {
                player.loadPaintedCellsToFile("resources/grid.txt");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_C){
            player.clearGrid();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
