import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        String expected = "The Tragedy of Leon, Prince of Denmark";

        // When
        String actual = hamletParser.changeHamletToLeon(input);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHamletToLeonUpperCase() {
        // Given
        String input = "The Tragedy of HAMLET, Prince of Denmark";
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
        String expected = "If you do meet Tariq and Marcellus,";

        // When
        String actual = hamletParser.changeHoratioToTariq(input);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariqUpperCase() {
        // Given
        String input = "If you do meet HORATIO and Marcellus,";
        String expected = "If you do meet TARIQ and Marcellus,";

        // When
        String actual = hamletParser.changeHoratioToTariq(input);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio() {
        // Given
        String lineTwentyNine = "If you do meet Horatio and Marcellus,";

        // When
        Integer actual = hamletParser.findHoratio(lineTwentyNine);

        // Then

    }

    @Test
    public void testFindHamlet() {
        // Given
        String title = "The Tragedy of Hamlet, Prince of Denmark";
        Integer expected = -1;
        String enter = "Enter KING CLAUDIUS, QUEEN GERTRUDE, HAMLET, POLONIUS, LAERTES, VOLTIMAND, CORNELIUS, Lords, and Attendants\n" +
                "KING CLAUDIUS";
        Integer expectedEnter = 1;

        // When
        Integer actual = hamletParser.findHamlet(title);
        Integer actualEnter = hamletParser.findHamlet(enter);

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedEnter, actualEnter);
    }
}