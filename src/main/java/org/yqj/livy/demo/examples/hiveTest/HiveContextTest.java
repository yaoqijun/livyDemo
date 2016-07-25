package org.yqj.livy.demo.examples.hiveTest;

import com.cloudera.livy.Job;
import com.cloudera.livy.JobContext;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.hive.HiveContext;

/**
 * Created by yaoqijun.
 * Date:2016-07-04
 * Email:yaoqj@terminus.io
 * Descirbe: 测试通过hive ， 后去对应的数据内容
 */
public class HiveContextTest implements Job<String> {

    @Override
    public String call(JobContext jobContext) throws Exception {

        SparkConf sparkConf = jobContext.sc().getConf();
        HiveContext hiveContext = jobContext.hivectx();

        System.out.println("************** start output context **********");
        Row[] rows = hiveContext.sql("select * from test").collect();
        for (Row row : rows){
            System.out.println("*** "+ row.toString());
        }
        return "hehe";
    }
}
