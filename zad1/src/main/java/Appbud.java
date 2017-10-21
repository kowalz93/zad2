import java.io.*;
import java.util.Scanner;

/**
 * Created by Marcin on 04.10.2017.
 */

public class Appbud {

    public static void main(String[] args) throws FileNotFoundException {
        new Appbud().run(new BufferedReader(new InputStreamReader(System.in)), new PrintWriter(System.out));

    }

    public void run(BufferedReader in, PrintWriter out) throws FileNotFoundException {

        System.out.println("Hej zaczynamy. Podaj plik do zczytania. ");
        Scanner scanner = new Scanner(System.in);
        String read = scanner.nextLine();

        FileReaderHelper fileReaderHelper = new FileReaderHelper();
        String readedFile = fileReaderHelper.readFileContentFromClasspath(read);
        String fileWithoutSpaces = fileReaderHelper.deleteFileWhiteSpaces(readedFile);

        System.out.println(readedFile+"\n*******************************************************************************************"
                +"\nDokument po usunięciu białych znaków: \n");

        System.out.println(fileWithoutSpaces);

    }
}
