import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public Integer findHamlet(String input) {
        Pattern hamletNamePattern = Pattern.compile("\\bHamlet\\b");
        Pattern hamletPersonPattern = Pattern.compile("\\bHAMLET\\b");
        Matcher hamletNameMatcher = hamletNamePattern.matcher(input);
        Matcher hamletPersonMatcher = hamletPersonPattern.matcher(input);

        if (hamletNameMatcher.find()) {
            return -1;
        } else if (hamletPersonMatcher.find()) {
            return 1;
        }

        return 0;
    }

    public Integer findHoratio(String input) {
        Pattern horatioPattern = Pattern.compile("\\bhoratio\\b", Pattern.CASE_INSENSITIVE);
        Matcher horatioMatcher;
        horatioMatcher = horatioPattern.matcher(input);
        return 0;
    }

    public String changeHamletToLeon(String input) {
        return null;
    }

    public String changeHoratioToTariuq(String input) {
        return null;
    }
}
