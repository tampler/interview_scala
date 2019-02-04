# Matchine Engine for a Blockchain powered crypto currency exchange 

This repository contains a full, commercial, production-ready code example, written as a home work for a **Senior Scala Developer** position in a Blockchain company.

This task mimics a simplistic virtual exchange, where multiple traders exchange multiple securities in real time.

Main requirements:

- High speed, highly parallel operation
- High code quality. Exchange should operate correctly and prove to be bug free 
- High type safety
- High level of abstraction to guarantee a long product life time and a low mainteinance cost
- High quality of implementation with modern libraries and abstractions
- High code coverage. Should be > 99%

[Task Spec Ru](https://github.com/tampler/interview_scala/blob/master/doc/task0_ru.md)

[Task Spec En](https://github.com/tampler/interview_scala/blob/master/doc/task0_en.md)

## Implementation details
I decided to build around [ScalaZ](https://scalaz.github.io/7/), due to its extra type safety, performance, a wide number of type classes and a wide community support.

Each trade can be abstracted as a **Monoid with Ordering**, since the customer ballance may be zero and the only operation is |+| (adding) either positive (sell side) or negative (buy side).

## Usage

1. Copy input data to /tmp 
```bash
> cp ./src/main/resources/*.txt /tmp
```
2. Explore all options 
```bash 
make
```
3. Run all unit tests
```bash 
> make test
```
4. Run linter
``` bash 
> make lint
```

5. Collect code coverage
``` bash
> make cov
```

TBD

