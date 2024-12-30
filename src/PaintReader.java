import java.io.*;
import java.util.stream.Collectors;

public class PaintReader  {
        private BufferedReader bufferedReader;
        Player player;

        Grid grid;

        public PaintReader() {
            try {
                bufferedReader = new BufferedReader(new FileReader("resources/grid.txt"));
            } catch (FileNotFoundException ex) {
                System.out.println("file not found.");
            }
        }

        public String loadFile() throws IOException{
            try(BufferedReader bufferedReader1 = new BufferedReader(new FileReader("resources/grid.txt"))) {
                return bufferedReader1.lines().collect(Collectors.joining("\n"));
            }
        }

}
