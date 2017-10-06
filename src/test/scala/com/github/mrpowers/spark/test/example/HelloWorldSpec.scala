package com.github.mrpowers.spark.test.example

import com.github.mrpowers.spark.fast.tests.DataFrameComparer
import org.apache.spark.sql.Row
import org.apache.spark.sql.types._
import org.scalatest.FunSpec

class HelloWorldSpec
    extends FunSpec
    with DataFrameComparer
    with SparkSessionTestWrapper {

  import spark.implicits._

  it("appends a greeting column to a Dataframe") {

    val sourceDF = Seq(
      ("miguel"),
      ("luisa")
    ).toDF("name")

    val actualDF = HelloWorld.withGreeting(sourceDF)

    val expectedSchema = List(
      StructField("name", StringType, true),
      StructField("greeting", StringType, false)
    )

    val expectedData = Seq(
      Row("miguel", "hello world"),
      Row("luisa", "hello world")
    )

    val expectedDF = spark.createDataFrame(
      spark.sparkContext.parallelize(expectedData),
      StructType(expectedSchema)
    )

    assertSmallDataFrameEquality(actualDF, expectedDF)

  }

}
