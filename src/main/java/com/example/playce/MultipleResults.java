package com.example.playce;

import java.util.Optional;
import lombok.Builder;

// goes from shortest to longest distance
@Builder
public class MultipleResults {

    private final Result[] results;
/*
    private final Result firstResult;
    @Builder.Default private final Optional<Result> secondResult = Optional.empty();
    @Builder.Default private final Optional<Result> thirdResult = Optional.empty();
    @Builder.Default private final Optional<Result> fourthResult = Optional.empty();
 
    @Builder.Default private final Optional<Result> fifthResult = Optional.empty();
*/
    public Result[] getResults() {
       return results;
    }
/*
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
*/
}
