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
    }

    @Test
    public void testChangeHoratioToTariq() {
    }

    @Test
    public void testFindHoratio() {
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