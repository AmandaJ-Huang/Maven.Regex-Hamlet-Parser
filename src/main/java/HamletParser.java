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
    private Pattern hamletOnePattern = Pattern.compile("Hamlet");
    private Pattern hamletTwoPattern = Pattern.compile("HAMLET");
    private Pattern horatioOnePattern = Pattern.compile("Horatio");
    private Pattern horatioTwoPattern = Pattern.compile("HORATIO");

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
        return input;
    }

    public String changeHoratioToTariq(String input) {
        Matcher replacementOne = horatioOnePattern.matcher(input);
        Matcher replacementTwo = horatioTwoPattern.matcher(input);

        if (findHoratio(input) == -1) {
            return replacementOne.replaceAll("Tariq");
        } else if (findHoratio(input) == 1) {
            return replacementTwo.replaceAll("TARIQ");
        }
        return input;
    }

    public String changeHamletAndHoratio(String input) {
        String result = input;
        while (findHamlet(result) != 0 && findHoratio(result) != 0) {
            result = changeHamletToLeon(result);
            result = changeHoratioToTariq(result);
        }
        return result;
    }
}
