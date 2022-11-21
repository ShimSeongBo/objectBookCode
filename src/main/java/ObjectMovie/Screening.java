package ObjectMovie;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public Reservation reservation(Customer customer, int audienceCount){
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }

    public Money calculateFee(int audienceCount) {
        switch (movie.getMovieType()) {
            case AMOUNT_DISCOUNT -> {
                if (movie.isDiscountable(whenScreened, sequence)) {
                    return movie.calculateAmountDiscountedFee().times(audienceCount);
                }
            }

            case PERCENT_DISCOUNT -> {
                if (movie.isDiscountable(whenScreened, sequence)) {
                    return movie.calculatePercentDiscountedFee().times(audienceCount);
                }
            }

            case NONE_DISCOUNT -> {
                return movie.calculateNondiscountedFee().times(audienceCount);
            }

        }
        return movie.calculateNondiscountedFee().times(audienceCount);
    }


//
//    public LocalDateTime getStartTime() {
//        return whenScreened;
//    }
//
//    public boolean isSequence(int sequence) {
//        return this.sequence == sequence;
//    }
//
//    public Reservation reservation(Customer customer, int audienceCount) {
//        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
//    }
//
//    public Money getMovieFee() {
//        return movie.getFee(); //안보고 movie.getFee()를 예상함.
//        // why? 가격은 영화가 가지고 있어야함. 미리 생각해봄.
//        // Map을 사용할것인가?
//        // 가지고 있는 정보가 2개를 초과하기 때문에 불가능 그럼 어떤 자료형으로 객체를 만들 것인가? 이것이 객체지향인가?
//        // List
//    }
}
