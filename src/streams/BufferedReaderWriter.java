package streams;

import acm.program.ConsoleProgram;

import java.io.*;

public class BufferedReaderWriter extends ConsoleProgram {

    public void run() {
        setFont("Arial-bold-32");

        // writing text into a file using BufferedWriter
        try {
            FileWriter fw = new FileWriter(System.getProperty("user.home") + File.separator + "text.txt");
            BufferedWriter br = new BufferedWriter(fw);
            br.write("Hello World!");
            br.newLine();
            br.write("How is it going?");
            br.close();
        }
        catch (IOException ex) {
            println(ex.getMessage());
        }

        // Reading text from file system using BufferedReader
        try {
            FileReader fw = new FileReader(System.getProperty("user.home") + File.separator + "text.txt");
            BufferedReader br = new BufferedReader(fw);
            String line = "";
            while((line = br.readLine()) != null) {
                println(line);
            }
            br.close();
        }
        catch (IOException ex) {
            println(ex.getMessage());
        }
    }
}
