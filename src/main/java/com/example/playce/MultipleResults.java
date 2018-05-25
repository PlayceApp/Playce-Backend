package com.example.playce;

import java.util.Optional;
import lombok.Builder;

// goes from shortest to longest distance
public class MultipleResults {

    private final Result firstResult;
    private final Optional<T> secondResult;
    private final Optional<T> thirdResult;
    private final Optional<T> fourthResult;
    private final Optional<T> fifthResult;

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
