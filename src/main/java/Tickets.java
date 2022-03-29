import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tickets {
    public List<Ticket> tickets;

    //TODO принимает аргументы места вылета и места назначения и считает только по ним
    public long calculateAvgTime() {

        long time = 0;

        for (Ticket ticket : tickets) {
            time += ticket.getFlyTime();
        }

        return time / tickets.size();
    }

    public List<Long> timeOfTickets() {
        List<Long> list = new ArrayList<>();
        for (Ticket ticket : tickets) {
            list.add(ticket.getFlyTime());
        }
        return list;
    }

    public long calculatePercentile(int percentile) {
        List<Long> list = timeOfTickets();
        Collections.sort(list);
        int index = (int) Math.ceil(percentile / 100.00 * list.size());
        return list.get(index - 1);
    }
}
