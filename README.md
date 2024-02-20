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
