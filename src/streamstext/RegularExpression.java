package streamstext;

import acm.program.ConsoleProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression extends ConsoleProgram {

    // we just read a simple text file from filesystem
    String readFile(String filepath) {
        String ret = "";
        try {
            FileReader fw = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fw);
            String line = "";
            while((line = br.readLine()) != null) {
                ret += line + '\n';
            }
            br.close();
        }
        catch (IOException ex) {
            println(ex.getMessage());
        }
        return ret;
    }

    // this is the magic, here we translate any old language into the
    // ohm's new brand languge
    String translateToNewBrandLanguage(String text) {
        String ret = "";

        // we know already the replace method, which we could use:
        ret = text.replaceAll("TH Nürnberg", "Ohm");
        ret = ret.replaceAll("THN", "Ohm");
        ret = ret.replaceAll("Technische Hochschule Nürnberg", "Ohm");
        println(ret);

        // the problem is we have to define each match manually
        // sometimes it is easier to use regular expressions for such tasks
        // it is quite handy that the replaceAll string methods accepts a pattern:
        String universityNamePattern = "T(echnische)?\\s?H(ochschule)?\\s?N([üu]rnberg)?";
        ret = text.replaceAll(universityNamePattern, "Ohm");
        println(ret);

        return ret;
    }

    // in this example we use regular expressions to extract all email addresses with th-nuernberg.de from our text
    HashSet<String> getEmailAddresses(String text) {
        HashSet<String> ret = new HashSet<>();
        // email addresses with characters a-z, numbers 0-9 or the .
        // remark: we need to escape the . because it is a metacharater which matches any character
        Pattern emailPattern = Pattern.compile("[0-9a-z\\.]+@th-nuernberg.de", Pattern.CASE_INSENSITIVE);
        Matcher emailMatcher = emailPattern.matcher(text);

        while(emailMatcher.find())
        {
            ret.add(emailMatcher.group());
        }
        return ret;
    }


    public void run() {
        setFont("Arial-bold-32");

        String pressRelease = readFile("/Users/winkelmannsv/git/prog2a/src/streamstext/pressemitteilung.txt");
        translateToNewBrandLanguage(pressRelease);

        HashSet<String> emailAddressesInArticle = getEmailAddresses(pressRelease);
        for(String s: emailAddressesInArticle)
            println(s);
    }
}
