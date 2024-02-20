# Surviving Unit Tests

This is a Java project for our WiseStart Academy.

It is all about Unit Testing and has different branches for different samples of unit testing.

### Presentation

The repository contains a presentation that you can find [here](https://docs.google.com/presentation/d/17Zqp4cAZWybeCDhVk2WMQyAiNDqCXl2X_JfWMjikrRQ).

### Branches

- `main`: Paired with Slide 11. It has some basic unit tests as a simple example.
- `api`: Paired with Slide 17. This is to demonstrate bad practices.
- `get-by`: Paired with Slide 19. This is for writing some unit tests.
- `tdd`: Paired with Slide 29. This is for a test first approach to Pokédex.
- `pingpong`: Paired with Slide 31. This is for Ping-Pong Pairing.

### How to run

```shell
git clone git@github.com:rickyclegg/surviving-unit-tests.git
cd surviving-unit-tests
./gradlew --refresh-dependencies
./gradlew build
./gradlew test
```

### Ping Pong Pairing

Your job is to implement the EvolveDecision business logic.  
The `EvolveDecision` should decide if a `Pokemon` should evolve or not based on the `BattleResult`.

The requirements are as follows:
* The `BattleResult` contains the winner and the xp gained in the battle.
* The `EvolveDecision` should be provided an instance of `BattleResult`.
* The `EvolveDecision` contains the business logic to make the decision.

A Pokemon should evolve if:
* The `xpGained` in the battle, plus the `xp` of the `Pokemon`, is greater than the `Pokemon`'s `xpToEvolve`.
  * An instance of `EvolveStatus` should be returned.
    * With a property `pokemon` which is a new instance of the `Pokemon` with the `xp` set to the last `xpToEvolve` and the `level` incremented by 1. The `xpToEvolve` should be set to the `xpToEvolve` times 2.
    * With a `boolean` `hasEvolved` set to `true`.

A Pokemon should not evolve if:
* If the `xpGained` plus the `xp` of the `Pokemon` is less than the `Pokemon`'s `xpToEvolve`.
  * An instance of `EvolveStatus` should be returned.
    * With a property `pokemon` which is the same instance of the `Pokemon`.
    * With a `boolean` `hasEvolved` set to `false`.

You'll find the function `testReplaceMe` in the `EvolveDecisionTest` class. This is where you should start.
