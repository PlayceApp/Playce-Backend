package com.example.playce;

import java.util.Optional;
import lombok.Builder;

// goes from shortest to longest distance
public class MultipleResults {

    private final Result firstResult;
    private final Optional<Result> secondResult;
    private final Optional<Result> thirdResult;
    private final Optional<Result> fourthResult;
    private final Optional<Result> fifthResult;

    public MultipleResults(Result firstResult, Optional<Result> secondResult, Optional<Result> thirdResult, Optional<Result> fourthResult) {
       this.firstResult = firstResult;
       this.secondResult = secondResult;
       this.thirdResult = thirdResult;
       this.fourthResult = fourthResult;
       this.fifthResult = Optional.empty();
    }

    @Builder
    public MultipleResults(Result firstResult, Result secondResult, Result thirdResult, Result fourthResult, Result fifthResult) {
        this(firstResult, Optional.ofNullable(secondResult), Optional.ofNullable(thirdResult), Optional.ofNullable(fourthResult), Optional.ofNullable(fifthResult));
    }

    public Result getFirstResult() {
        return firstResult;
    }

    public Result getSecondResult() {
        return secondResult.get();
    }

    public Result getThirdResult() {
        return thirdResult.get();
    }

    public Result getFourthResult() {
        return fourthResult.get();
    }

    public Result getFifthResult() {
        return fifthResult.get();
    }

}
