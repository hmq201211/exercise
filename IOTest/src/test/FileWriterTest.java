package test;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    public static final String LI = System.getProperty("line.separator");

    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("H:\\demo.txt", true);
            fw.write("Hello" + LI + "hmq");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
