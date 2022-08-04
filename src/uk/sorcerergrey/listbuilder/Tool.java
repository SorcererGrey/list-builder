package uk.sorcerergrey.listbuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tool {

    public static void CNOut(String s) {
        System.out.println(s);
    }
    public static String CNIn() {
        System.out.print("$> ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
