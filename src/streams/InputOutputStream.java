package streams;

import acm.program.ConsoleProgram;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class InputOutputStream extends ConsoleProgram {

    public void run() {
        setFont("Arial-bold-32");

        // Writing to a byte file
        FileOutputStream fos = null;
        try
        {
            // Writing byte data to the file bytes.dat.
            // user.home is the home directory of the current user
            // use File.separator to write programs for windows and linux/mac
            fos = new FileOutputStream(System.getProperty("user.home") + File.separator + "bytes.dat");
            for (int i=0; i<256; i++)
                fos.write(i);
            // always close the file otherwise you cannot guarantee that the bytes are written to the file system
            fos.close();
        }
        catch (Exception ex)
        {
            println(ex.getMessage());
        }

        // Reading from byte file
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(System.getProperty("user.home") + File.separator + "bytes.dat");
            int data = 0;
            // with read() we can read each byte separately. If you need the whole file it is better to use Files.readAllBytes(path)
            while ((data = fis.read()) != -1) {
                println(data);
            }
            fis.close();
        }
        catch (Exception ex)
        {
            println(ex.getMessage());
        }


    }
}
