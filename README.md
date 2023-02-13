# spark-test-example

Spark DataFrame transformation and UDF test examples.

Run the test suite with `sbt test`.

Making sure to use sbt with Java 8.*

## \* Controlling java version (for sbt)
For example by installing Java 8 somewhere:
```
brew install openjdk@8
```
(Use a different package manager or release as appropriate for your machine.)

... and then [point to it when you start sbt][sbt-java-home]:
```
sbt -java-home /usr/local/Cellar/openjdk@8/1.8.0+362/libexec/openjdk.jdk/Contents/Home/
```
(Your path will look different.)

[sbt-java-home]: https://users.scala-lang.org/t/telling-sbt-to-use-different-jdk-version/4608/5
