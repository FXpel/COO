package fil.coo.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readString() throws IOException {
        return scanner.next();
    }

    public static String readLine() throws IOException {
        return scanner.nextLine();
    }

    public static int readInt() throws IOException {
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        try {
            System.out.print(" chaine : ? ");
            String chaineLue = Input.readString();
            System.out.println("lue  => " + chaineLue);
            System.out.print(" int : ? ");
            int intLu = Input.readInt();
            System.out.println("lue  => " + intLu);
        }
        catch (IOException chaineLue) {
            // empty catch block
        }
    }
}

