package theaterRefactoring;

public class Bag {
    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    public Long hold(Ticket ticket) {
        if(hasInvitation()) {
            setTicket(ticket);
            return 0L;
        } else {
            minusAmount(ticket.getFee());
            setTicket(ticket);
            return ticket.getFee();
        }
    }

    private boolean hasInvitation() {

        return invitation != null;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
