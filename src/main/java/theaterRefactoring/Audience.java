package theaterRefactoring;

public class Audience {

    private Bag bag;

    public Long buyTicket(Ticket ticket) {

        return bag.hold(ticket);
        }
    }
