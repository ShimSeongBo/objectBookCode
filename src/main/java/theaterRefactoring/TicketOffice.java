package theaterRefactoring;


import java.util.List;

public class TicketOffice {

    private Long amount;
    private List<Ticket> tickets;

    public void sellTicketTo(Audience audience) {

        plusAmount(audience.buyTicket(getTicket()));
    }


    public Ticket getTicket() {
        return tickets.remove(0);
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
