import com.google.gson.annotations.SerializedName;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ticket {

    private String origin;
    @SerializedName("origin_name")
    private String originName;
    private String destination;
    @SerializedName("destination_name")
    private String destinationName;
    @SerializedName("departure_date")
    private String departureDate;
    @SerializedName("departure_time")
    private String departureTime;
    @SerializedName("arrival_date")
    private String arrivalDate;
    @SerializedName("arrival_time")
    private String arrivalTime;
    private String carrier;
    private int stops;
    private int price;

    public long getFlyTime() {
        String[] departureDate = this.departureDate.split("\\.");
        int depYear = Integer.parseInt(departureDate[2]);
        int depMonth = Integer.parseInt(departureDate[1]);
        int depDay = Integer.parseInt(departureDate[0]);
        String[] departureTime = this.departureTime.split(":");
        int depHour = Integer.parseInt(departureTime[0]);
        int depMin = Integer.parseInt(departureTime[1]);

        Calendar departure = new GregorianCalendar(depYear, depMonth, depDay, depHour, depMin);

        String[] arrivalDate = this.arrivalDate.split("\\.");
        int arrYear = Integer.parseInt(arrivalDate[2]);
        int arrMonth = Integer.parseInt(arrivalDate[1]);
        int arrDay = Integer.parseInt(arrivalDate[0]);
        String[] arrivalTime = this.arrivalTime.split(":");
        int arrHour = Integer.parseInt(arrivalTime[0]);
        int arrMin = Integer.parseInt(arrivalTime[1]);

        Calendar arrival = new GregorianCalendar(arrYear, arrMonth, arrDay, arrHour, arrMin);

        return arrival.getTimeInMillis() - departure.getTimeInMillis();
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "origin='" + origin + '\'' +
                ", originName='" + originName + '\'' +
                ", destination='" + destination + '\'' +
                ", destinationName='" + destinationName + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", carrier='" + carrier + '\'' +
                ", stops=" + stops +
                ", price=" + price +
                '}';
    }
}