package com.github.mrpowers.spark.test.example

import org.scalatest.FunSpec
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.Row
import com.github.mrpowers.spark.fast.tests.DataFrameComparer

class NumberFunSpec
    extends FunSpec
    with DataFrameComparer
    with SparkSessionTestWrapper {

  import spark.implicits._

  it("appends an is_even column to a Dataframe") {

    val sourceDF = Seq(
      (1),
      (8),
      (12)
    ).toDF("number")

    val actualDF = sourceDF
      .withColumn("is_even", NumberFun.isEvenUDF(col("number")))

    val expectedSchema = List(
      StructField("number", IntegerType, false),
      StructField("is_even", BooleanType, true)
    )

    val expectedData = Seq(
      Row(1, false),
      Row(8, true),
      Row(12, true)
    )

    val expectedDF = spark.createDataFrame(
      spark.sparkContext.parallelize(expectedData),
      StructType(expectedSchema)
    )

    assertSmallDataFrameEquality(actualDF, expectedDF)

  }

  describe(".isEven") {
    it("returns true for even numbers") {
      assert(NumberFun.isEven(4) === true)
    }

    it("returns false for odd numbers") {
      assert(NumberFun.isEven(3) === false)
    }

  //  it("returns false for null values") {
  //    assert(NumberFun.isEven(null) === false)
  //  }
  }

}
