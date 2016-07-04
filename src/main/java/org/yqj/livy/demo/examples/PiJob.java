package org.yqj.livy.demo.examples;

import com.cloudera.livy.Job;
import com.cloudera.livy.JobContext;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaoqijun.
 * Date:2016-06-30
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class PiJob implements Job<Double>,
        Function<Integer, Integer>,
        Function2<Integer, Integer, Integer> {

    private final int samples = 2000000;

    public Integer call(Integer v1) throws Exception {
        double x = Math.random();
        double y = Math.random();
        return (x*x + y*y < 1) ? 1 : 0;
    }

    public Integer call(Integer v1, Integer v2) throws Exception {
        return v1 + v2;
    }

    public Double call(JobContext jobContext) throws Exception {
        List<Integer> sampleList = new ArrayList<Integer>();
        for (int i = 0; i < samples; i++) {
            sampleList.add(i + 1);
        }

        JavaSparkContext context = jobContext.sc();
        SparkConf sparkConf = context.getConf().setAppName("livyTestSparkFuck");
        sparkConf.setMaster("spark://yaoqijuns-MacBook-Pro.local:7077");
        return 4.0d * context.parallelize(sampleList).map(this).reduce(this) / samples;
    }
}
