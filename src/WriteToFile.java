import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public WriteToFile(String filename, String[] args) {
        try {
            FileWriter writer = new FileWriter(filename, true);
            for(String i : args){
                writer.write(i + '\n');
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
