import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

// javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java
// java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest

public class MarkdownParseTest {
    @Test
    public void testFile() throws IOException {
        List<String> temp = MarkdownParse.getLinks(Files.readString(Path.of("test-file.md")));
        List<String> expected = List.of("some-page.html","google.com");
        System.out.println(temp);
        assertEquals(expected, temp);
    }
    @Test
    public void testFile2() throws IOException {
        List<String> temp = MarkdownParse.getLinks(Files.readString(Path.of("test-file2.md")));
        List<String> expected = List.of("https://something.com", "some-page.html", "google.com");
        assertEquals(expected, temp);
    }
}