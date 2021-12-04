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
    private Pattern hamletOnePattern = Pattern.compile("\\bHamlet\\b");
    private Pattern hamletTwoPattern = Pattern.compile("\\bHAMLET\\b");
    private Pattern horatioOnePattern = Pattern.compile("\\bHoratio\\b");
    private Pattern horatioTwoPattern = Pattern.compile("\\bHORATIO\\b");

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
        Matcher hamletOneMatcher = hamletOnePattern.matcher(input);
        Matcher hamletTwoMatcher = hamletTwoPattern.matcher(input);

        if (hamletOneMatcher.find()) {
            return -1;
        } else if (hamletTwoMatcher.find()) {
            return 1;
        }
        return 0;
    }

    public Integer findHoratio(String input) {
        Matcher horatioOneMatcher = horatioOnePattern.matcher(input);
        Matcher horatioTwoMatcher = horatioTwoPattern.matcher(input);

        if (horatioOneMatcher.find()) {
            return -1;
        } else if (horatioTwoMatcher.find()) {
            return 1;
        }
        return 0;
    }

    public String changeHamletToLeon(String input) {
        Matcher replacementOne = hamletOnePattern.matcher(input);
        Matcher replacementTwo = hamletTwoPattern.matcher(input);

        if (findHamlet(input) == -1) {
            return replacementOne.replaceAll("Leon");
        } else if (findHamlet(input) == 1) {
            return replacementTwo.replaceAll("LEON");
        }
        return null;
    }

    public String changeHoratioToTariq(String input) {
        Matcher replacementOne = horatioOnePattern.matcher(input);
        Matcher replacementTwo = horatioTwoPattern.matcher(input);

        if (findHoratio(input) == -1) {
            return replacementOne.replaceAll("Tariq");
        } else if (findHoratio(input) == 1) {
            return replacementTwo.replaceAll("TARIQ");
        }
        return null;
    }
}
