package com.github.mrpowers.spark.test.example

import com.github.mrpowers.spark.fast.tests.DataFrameComparer
import org.scalatest.FunSpec

class ConverterSpec
    extends FunSpec
    with DataFrameComparer
    with SparkSessionTestWrapper {

  import spark.implicits._

  describe(".snakecaseify") {

    it("downcases uppercase letters") {
      assert(Converter.snakecaseify("HeLlO") === "hello")
    }

    it("converts spaces to underscores") {
      assert(Converter.snakecaseify("Hi There") === "hi_there")
    }

  }

  describe(".snakeCaseColumns") {

    it("snake_cases the column names of a DataFrame") {

      val sourceDF = Seq(
        ("funny", "joke")
      ).toDF("A b C", "de F")

      val actualDF = Converter.snakeCaseColumns(sourceDF)

      val expectedDF = Seq(
        ("funny", "joke")
      ).toDF("a_b_c", "de_f")

      assertSmallDataFrameEquality(actualDF, expectedDF)

    }

  }

}
