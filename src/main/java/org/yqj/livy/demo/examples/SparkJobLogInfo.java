package org.yqj.livy.demo.examples;

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
public class SparkJobLogInfo implements Job<String>{

    @Override
    public String call(JobContext jobContext) throws Exception {

//        HiveContext hiveContext = jobContext.hivectx();
//
//        hiveContext.sql("use test").collect();
//
//        Row[] rows = hiveContext.sql("select * from testtest").collect();
//
//        System.out.println("*************** row datas content");
//        for(Row row : rows){
//            System.out.println("*** rowSize " + row.length());
//            System.out.println("*** row data : " + row.toString());
//        }
//        return "true";
        return null;
    }
}
