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
    private Pattern hamletPattern = Pattern.compile("\\bhamlet\\b", Pattern.CASE_INSENSITIVE);
    private Pattern horatioPattern = Pattern.compile("\\bhoratio\\b", Pattern.CASE_INSENSITIVE);
    private Matcher hamletMatcher;
    private Matcher horatioMatcher;

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

    public Boolean findHamlet(String input) {
        hamletMatcher = hamletPattern.matcher(input);
        return hamletMatcher.find();
    }

    public Boolean findHoratio(String input) {
        horatioMatcher = horatioPattern.matcher(input);
        return horatioMatcher.find();
    }

    public String changeHamletToLeon(String input) {
        hamletMatcher = hamletPattern.matcher(input);
        return hamletMatcher.replaceAll("LEON");
    }

    public String changeHoratioToTariuq(String input) {
        horatioMatcher = horatioPattern.matcher(input);
        return horatioMatcher.replaceAll("TARIQ");
    }
}
