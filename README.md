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

PS: When working with a **really Bleeding Edge technology**, be ready to debug library bugs as well. Submitted [an issue](https://github.com/scalaz/scalaz-zio/issues/567) in the [ZIO lib](https://scalaz.github.io/scalaz-zio), related to Stack Overflow in an Async Queue

## Implementation details
I decided to build around [ScalaZ](https://scalaz.github.io/7/), due to its extra type safety, performance, a wide number of type classes and a wide community support. The latest ScalaZ spinoff, the [ZIO library](https://scalaz.github.io/scalaz-zio/) by John De Goes, was chosen to implement effectful IO and concurrency model, building [Fibers](https://scalaz.github.io/scalaz-zio/datatypes/fiber.html) around ScalaZ type classes

Each trade can be abstracted as a **Monoid with Ordering**, since the customer ballance may be zero and the only operation is |+| (adding) either positive (sell side) or negative (buy side).

On every incoming order, the Matchine Engine should parse its input and fire a two separate execution **Fibers** in parallel. 

The first **Fiber** executes a matching context optimistically, assuming that the input order is valid and the customer has enough funds/equity to submit this order. I call this an **Execution fiber**

The secod **Fiber** fires in parallel to check input order details and validate the customer eligibility to perform the trade. I call this a **Control fiber**

If checks are OK, the **Control fiber** joins and allows the **Execution fiber** to join and commit its results, too.

If for some reason the **Control fiber** fails, the **Matching Engine** tries to perform a **partial matching** to fullfil the buy/sell order to the maximum possible extent. The Matching Engine fires a **Partial Execution fiber** to do that job. 

The **Matching Engine** handles input requsts from the **Transactor** and responds via an async [ZIO Queue](https://scalaz.github.io/scalaz-zio/datatypes/queue.html). If the **Control fiber** fails, it terminates a worker fiber immediately, tries to recover from the error via partial matching, and sends an update to the Response Queue with the matching result for the current order.

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

