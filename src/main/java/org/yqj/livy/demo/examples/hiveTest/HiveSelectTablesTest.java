package org.yqj.livy.demo.examples.hiveTest;

import com.cloudera.livy.Job;
import com.cloudera.livy.JobContext;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.hive.HiveContext;

/**
 * Created by yaoqijun.
 * Date:2016-07-12
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class HiveSelectTablesTest implements Job<String> {

    @Override
    public String call(JobContext jobContext) throws Exception {
        HiveContext hiveContext = jobContext.hivectx();

        Row[] rowUseTest = hiveContext.sql("use test").collect();
        System.out.println("************** hive use test content");

        Row[] rows = hiveContext.sql("show tables").collect();

        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("******************** result");
        for (Row row : rows){
            System.out.println("***** "+ row.toString());
            stringBuilder.append(row.toString());
        }

        return stringBuilder.toString();
    }
}
