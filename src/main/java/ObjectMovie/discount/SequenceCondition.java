package ObjectMovie.discount;

import ObjectMovie.Screening;

public class SequenceCondition implements DiscountConditionInterface {

    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
