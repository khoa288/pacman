# Term Project - Pacman Game
[![Test](https://github.com/khoa288/pacman/actions/workflows/test.yml/badge.svg)](https://github.com/khoa288/pacman/actions/workflows/test.yml)
[![Build](https://github.com/khoa288/pacman/actions/workflows/build.yml/badge.svg)](https://github.com/khoa288/pacman/actions/workflows/build.yml)

## Getting started
### Prerequisite
- Java >= 17

### Contribute
This project was made with the [Gradle Build Tool](https://gradle.org/), which you can build with the follow command:
```shell
./gradlew build
```
...or on Windows with:
```
gradlew.bat build
```

When running `build`, Gradle will also runs `spotlessCheck`, which will run a check on the codebase for formatting. Therefore, you can also apply codebase format with:
```shell
./gradlew spotlessApply
```

Then, the project is ready to be run with:
```shell
./gradlew run
```

### Notes
Please follow [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/) specification while commit.
