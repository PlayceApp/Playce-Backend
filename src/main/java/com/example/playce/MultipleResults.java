package com.example.playce;

import java.util.Optional;

// goes from shortest to longest distance
public class MultipleResults {

    private final Result firstResult;
    private final Optional<Result> secondResult;
    private final Optional<Result> thirdResult;
    private final Optional<Result> fourthResult;
    private final Optional<Result> fifthResult;

    public MultipleResults(Result firstResult, Result secondResult, Result thirdResult, Result fourthResult, Result fifthResult) {
        this.firstResult = firstResult;
        this.secondResult = Optional.of(secondResult);
        this.thirdResult = Optional.of(thirdResult);
        this.fourthResult = Optional.of(fourthResult);
        this.fifthResult = Optional.of(fifthResult);
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
