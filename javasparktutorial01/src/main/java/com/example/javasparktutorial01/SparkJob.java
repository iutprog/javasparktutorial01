package com.example.javasparktutorial01;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.stereotype.Component;

@Component
public class SparkJob {
public void runSparkJob() {
        SparkSession spark = SparkSession.builder()
                .appName("Hello World Spark")
                .master("local[*]")  // For testing, use local mode to avoid connecting to Spark master
                .getOrCreate();
    
        try (JavaSparkContext sc = new JavaSparkContext(spark.sparkContext())) {
            List<String> data = Arrays.asList("Test", "Spark", "Job");
            JavaRDD<String> rdd = sc.parallelize(data);
            System.out.println("------------------------------------------!!!");
            rdd.foreach(word -> System.out.println(word));
        } finally {
            spark.stop();
        }
    }
}
