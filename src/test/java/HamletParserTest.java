import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        // Given
        String input = "The Tragedy of Hamlet, Prince of Denmark";
        String expected = "The Tragedy of LEON, Prince of Denmark";

        // When
        String actual = hamletParser.changeHamletToLeon(input);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        // Given
        String input = "If you do meet Horatio and Marcellus,";
        String expected = "If you do meet TARIQ and Marcellus,";

        // When
        String actual = hamletParser.changeHoratioToTariuq(input);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio() {
        // Given
        String lineTwentyNine = "If you do meet Horatio and Marcellus,";

        // When
        Boolean actual = hamletParser.findHoratio(lineTwentyNine);

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void testFindHamlet() {
        // Given
        String title = "The Tragedy of Hamlet, Prince of Denmark";
        String upperHamlet = "HAMLET";
        String lowerHamlet = "hamlet";
        String justHamlet =  "Hamlet";

        // When
        Boolean actual = hamletParser.findHamlet(title);
        Boolean actualUpperHamlet = hamletParser.findHamlet(upperHamlet);
        Boolean actualLowerHamlet = hamletParser.findHamlet(lowerHamlet);
        Boolean actualJustHamlet = hamletParser.findHamlet(justHamlet);

        // Then
        Assert.assertTrue(actual);
        Assert.assertTrue(actualUpperHamlet);
        Assert.assertTrue(actualLowerHamlet);
        Assert.assertTrue(actualJustHamlet);
    }
}