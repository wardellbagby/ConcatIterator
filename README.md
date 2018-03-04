# ConcatIterator

A Kotlin library that provides a concatenating iterator.

## ConcatIterator?

A ConcatIterator is an iterator that takes in multiple child iterators and iterates through its children in order.

### Uh.....why?

It's pretty nice to be able to combine iterators.

## Getting Started

Simply check out this project and import it into Android Studio! Gradle and Android Studio should take care of the rest!

### As A Dependency

In your root `build.gradle`:

```
allprojects {
        repositories {
                ...
                maven { url 'https://jitpack.io' }
        }
}
```

In your app `build.gradle`:

```
dependencies {
        ...
        implementation 'com.github.wardellbagby:ConcatIterator:0.1.0'
}
```

### Using

```kotlin
        //Creates a ConcatIterator.
        val iterator = ConcatIterator((0..1000).iterator(), listOf(1, 5, 6).iterator())
        val otherIterator = iterator + (5 downTo 0).iterator()
        val thirdIterator = otherIterator + (0 until 10)
```

### Building

You can build this lib using:

```
./gradlew build
```

## Running the tests

Unit tests can be run with:

```
./gradlew check
```

### Code Style

This app uses [ktlint](https://ktlint.github.io/) for enforcing style constraints. Most ktlint errors can be fixed by running

```
./gradlew ktlintFormat
```

but not all. ktlint will output to console any errors it encounters.

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for the process for submitting pull requests to this project.

## License

This project is licensed under the LGPL-3.0 License - see the [LICENSE](LICENSE) file for details
