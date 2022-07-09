package com.lkg.demo.spark;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;

public class javaSpark {

    public static void main(String[] args) throws InterruptedException {
        try {
            readData();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        SparkConf conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount");
//        JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(1));
//
//        JavaReceiverInputDStream<String> lines = jssc.socketTextStream("localhost", 9999);
//        JavaDStream<String> words = lines.flatMap(x -> Arrays.asList(x.split(" ")).iterator());
//        // Count each word in each batch
//        JavaPairDStream<String, Integer> pairs = words.mapToPair(s -> new Tuple2<>(s, 1));
//        JavaPairDStream<String, Integer> wordCounts = pairs.reduceByKey(Integer::sum);
//
//        // Print the first ten elements of each RDD generated in this DStream to the console
//        wordCounts.print();
//
//        jssc.start();              // Start the computation
//        jssc.awaitTermination();   // Wait for the computation to terminate

    }

    private void readCSV() throws IOException {
        String fileName = "D:\\01Work\\04微智日志分析\\SCA疑似URL\\judge_back\\judge_back";
        Reader in = new FileReader(fileName);
        Iterable<CSVRecord> records = CSVFormat.MYSQL.parse(in);
        for (CSVRecord record : records) {
            String columnOne = record.get(0);
            String columnTwo = record.get(1);
        }
    }

    private static void readData() throws IOException {
        long start = System.currentTimeMillis();
//        String fileName = "D:\\01Work\\04微智日志分析\\SCA疑似URL\\data\\LTE_240_YDLNG00137_S1U103_20190728002004_0000.txt";
        String fileName = "D:\\01Work\\04微智日志分析\\堡垒机日志\\北京中心业务系统近半年系统操作日志.csv";

        FileReader reader = new FileReader(fileName);
        BufferedReader br = new BufferedReader(reader, 1024*5*5);

        String line;
        int a = 0;
        while((line = br.readLine()) != null){
//            System.out.println(line);
            a++;
        }
        
        br.close();
        reader.close();
        System.out.println("totole num:"+a);
        System.out.println("spend time:"+(System.currentTimeMillis()-start));
        System.out.printf("spend time:%s", (System.currentTimeMillis()-start));
    }
}