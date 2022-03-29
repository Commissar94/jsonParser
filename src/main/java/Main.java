import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;

public class Main {
    public static void main(String[] args) {

        try (FileReader reader = new FileReader("src\\main\\resources\\tickets.json")) {

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            Tickets tickets = gson.fromJson(reader, Tickets.class);
            System.out.println("Average hours: " + tickets.calculateAvgTime() / 1000 / 60 / 60 + " average minutes " + (tickets.calculateAvgTime() / 1000 / 60) % 60);
            long percentile = tickets.calculatePercentile(90);
            System.out.println("90 percentile : " + percentile / 1000 / 60 / 60 + " hours " + (percentile / 1000 / 60) % 60 + " minutes");

        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }
}
