package com.example.playce;

import java.util.Optional;
import lombok.Builder;

// goes from shortest to longest distance
@Builder
public class MultipleResults {

    private final Result firstResult;
/*
    private final Optional<Result> secondResult;
    private final Optional<Result> thirdResult;
    private final Optional<Result> fourthResult;
 */ @Builder.Default private final Optional<Result> secondResult = Optional.empty();
    @Builder.Default private final Optional<Result> thirdResult = Optional.empty();
    @Builder.Default private final Optional<Result> fourthResult = Optional.empty();
 
    @Builder.Default private final Optional<Result> fifthResult = Optional.empty();
/*
    @Builder
    public MultipleResults(Result firstResult, Result secondResult, Result thirdResult, Result fourthResult, Result fifthResult) {
        this(firstResult, 
            (Optional<Result>) Optional.ofNullable(secondResult),
            (Optional<Result>) Optional.ofNullable(thirdResult),
            (Optional<Result>) Optional.ofNullable(fourthResult),
            (Optional<Result>) Optional.ofNullable(fifthResult));
    }
*/

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
