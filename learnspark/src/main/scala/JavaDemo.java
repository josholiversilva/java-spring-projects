import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.ArrayList;
import java.util.List;

// Spark fundamentals

// Data is processed from HDFS (via Yarn), HBase, Cassandra, Hive..
// Recommendation: Spark-SQL > RDD to bring schema/structure to data (every row = dataset)

// 1. JavaSparkContext (sc) -> main spark object for processing
// 2. RDD (resilient distributed dataset) -> immutable blocks of RAM
// 3. Yarn -> main resource manager for Hadoop clusters: HDD <-> RDD <-> Executor communication
// 4. Executors -> ~54% of resource go into yarn/system resource & JVM/DB resources
// 5. .coalesce(Integer) -> pass number of partitions to reduce
// 6. .collect() -> tells spark to see final output as array at driver using RDD
// 7. .cache() -> Can CACHE an RDD in RAM, HDD, RAM+HDD but gets deleted after spark execution
// 8. sc._conf.getAll() -> gets all executor resource information

public class JavaDemo {
    public static void main(String[] args) {
        List<Double> inputData = new ArrayList<Double>();
        inputData.add(35.5);
        inputData.add(111.1);
        inputData.add(12.11);
        inputData.add(20.32);

        // Filter out all apache level logging
        Logger.getLogger("org.apache").setLevel(Level.WARN);

        // set master to local & use all resources available
        // without [*] runs on single thread
        SparkConf conf = new SparkConf().setAppName("startingSpark").setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        // JavaRDD - java rep allowing java method syntax to rdd
        // Under hood -> java rdd communicates to scala rdd class
        // Returns our list (collection) as a RDD
        // Resilient Distributed Dataset - fundamental immutable collection
        // data structure which computes on different nodes on cluster
        JavaRDD<Double> myRdd = sc.parallelize(inputData);

        // close spark context when done
        // fine loop lock -> similar to socket close
        sc.close();
    }
}
