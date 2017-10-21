import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.startsWith;
import static org.mockito.Mockito.mock;


/**
 * Created by Marcin on 19.10.2017.
 */
public class FileReaderHelperTest {

    @Test
    public void shouldReadContentFromFileOnClasspath() throws FileNotFoundException {
        String result = new FileReaderHelper().readFileContentFromClasspath("pdokument.txt");

        assertEquals("sdsojojsod sod osd sd s     dfkdmk  oskdokosk    oksok\r\n" +
                "sdkoskd  sdasd sd adfd d d d  ddgdf jsk sk    sojdo\r\n" +
                "              oskd so            sokd osk d\r\n" +
                "              sod\r\n" +
                "     sdsd s sd aifmklmz qsdnakmq qw d k smiej qowlamspd ", result);
    }

    @Test(expected = FileNotFoundException.class)
    public void shouldThrowAFileNotFoundExceptionWhenNoFileFound() throws FileNotFoundException {
        new FileReaderHelper().readFileContentFromClasspath("not existing file");

    }
    @Test
    public void  testStringExample(){
        String str = new String("Hej zaczynamy. Podaj plik do zczytania. ");
        assertEquals(str,"Hej zaczynamy. Podaj plik do zczytania. " );
    }
    @Test
    public void whenReadUsingScanner_thenCorrect() throws IOException {
        String input = "pdokument.txt";
        InputStream zmienna = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        String results = scanner.nextLine();
        assertEquals(input,results);
        System.setIn(zmienna);
        scanner.close();
    }

}