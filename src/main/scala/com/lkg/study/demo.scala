package com.lkg.study

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

object demo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("mySpark").setMaster("local[*]")
    val sparkContext =new SparkContext(conf)

    Logger.getLogger("org.apache").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.OFF)

    val rdd =sparkContext.parallelize(List(1,2,3,4,5,6)).map(_*3)
    val mappedRDD=rdd.filter(_>10).collect()
    //对集合求和
    println(rdd.reduce(_+_))


  }
}
