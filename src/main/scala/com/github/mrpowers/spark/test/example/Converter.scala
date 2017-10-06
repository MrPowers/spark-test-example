package com.github.mrpowers.spark.test.example

import org.apache.spark.sql.DataFrame

object Converter {

  def snakecaseify(s: String): String = {
    s.toLowerCase().replace(" ", "_")
  }

  def snakeCaseColumns(df: DataFrame): DataFrame = {
    df.columns.foldLeft(df) { (acc, cn) =>
      acc.withColumnRenamed(cn, snakecaseify(cn))
    }
  }

}
