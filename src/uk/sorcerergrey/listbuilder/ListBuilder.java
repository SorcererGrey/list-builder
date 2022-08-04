package uk.sorcerergrey.listbuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import uk.sorcerergrey.listbuilder.Tool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListBuilder {

    static List<String> items = new ArrayList<>();

    public static void main(String[] args) {
        Tool.CNOut("List Builder / V 1.0a / Alpha");
        for (;;) {
            String input = Tool.CNIn();
            String[] arg = input.split(" ");
            switch (arg[0]) {
                case "lb":
                    if (arg.length > 1) {
                        switch (arg[1]) {
                            case "-add":
                                Tool.CNOut("You may now begin entering items:");
                                while (true) {
                                    String entry = Tool.CNIn();
                                    if (!entry.equals("--")) {
                                        items.add(entry);
                                    } else break;
                                }
                                Tool.CNOut("-- Item entry ended --");
                                break;
                            case "-list":
                                Tool.CNOut("The following items have been added:");
                                int i = 1;
                                for (String item : items ) {
                                    Tool.CNOut("(" + i + "): " + item);
                                    i++;
                                }
                                break;
                            case "-rmlast":
                                items.remove(items.size() - 1);
                                break;
                            case "-export":
                                SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy");
                                Date date = new Date();
                                File file = new File("C:/Users/dylan/Downloads/list" + formatter.format(date) + ".json");
                                GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
                                Gson gson = builder.create();
                                try {
                                    if (!file.exists()) {
                                        if (file.createNewFile()) {
                                            try {
                                                FileWriter writer = new FileWriter("C:/Users/dylan/Downloads/list" + formatter.format(date) + ".json");
                                                writer.write(gson.toJson(items));
                                                writer.close();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            Tool.CNOut("-- Exported successfully --");
                                        } else {
                                            Tool.CNOut("-- Failed to export --");
                                        }
                                    } else Tool.CNOut("An export file for today already exists");
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                break;
                            default:
                                Tool.CNOut("-- Unknown Command --");
                                break;
                        }
                    } else Tool.CNOut("You need to specify a process to run");
                    break;
                default:
                    Tool.CNOut("-- Unknown Command --");
                    Tool.CNOut("");
                    break;
            }
        }
    }

}
