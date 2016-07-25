package org.yqj.livy.demo.examples.job;

import com.cloudera.livy.Job;
import com.cloudera.livy.JobContext;
import lombok.Data;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

import java.io.Serializable;

/**
 * Created by yaoqijun.
 * Date:2016-07-04
 * Email:yaoqj@terminus.io
 * Descirbe: 测试通过Sql 统计对应的数据信息内容
 */
public class SqlContextTest implements Job<String>{


    public String call(JobContext jobContext) throws Exception {

        //upload persons content
        JavaSparkContext javaSparkContext = jobContext.sc();
        SparkConf sparkConf = javaSparkContext.getConf().setAppName("testSqlContextTest");
        sparkConf.setMaster("spark://yaoqijuns-MacBook-Pro.local:7077");

        JavaRDD<Person> personJavaRDD = javaSparkContext.textFile("persons.txt").map(s->{
            String []personStr = s.split(",");
            Person p = new Person();
            p.setName(personStr[0]);
            p.setAge(Integer.valueOf(personStr[1]));
            return p;
        });

        SQLContext sqlContext = jobContext.sqlctx();
        DataFrame dataFrame = sqlContext.createDataFrame(personJavaRDD, Person.class);
        dataFrame.registerTempTable("person");

        System.out.println("********************************************** print person context");
        DataFrame teenagers = sqlContext.sql("select name from person where age >= 13 and age <= 19");
        teenagers.toJavaRDD().map(row->"Name is :"+row.getString(0)).collect().forEach(System.out::println);

        return "success";
    }

    @Data
    public static class Person implements Serializable {

        private static final long serialVersionUID = 6506978660566683955L;

        private String name;

        private Integer age;

    }
}
