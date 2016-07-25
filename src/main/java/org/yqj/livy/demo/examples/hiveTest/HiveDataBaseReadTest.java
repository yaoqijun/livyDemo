package org.yqj.livy.demo.examples.hiveTest;

import com.cloudera.livy.Job;
import com.cloudera.livy.JobContext;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.hive.HiveContext;

/**
 * Created by yaoqijun.
 * Date:2016-07-12
 * Email:yaoqj@terminus.io
 * Descirbe: 测试数据库信息的获取方式
 */
public class HiveDataBaseReadTest implements Job<String> {

    @Override
    public String call(JobContext jobContext) throws Exception {
        SparkConf sparkConf = jobContext.sc().getConf();
        sparkConf.setAppName("livyHiveSqlTest");
        sparkConf.setMaster("spark://yaoqijuns-MacBook-Pro.local:7077");
        HiveContext hiveContext = jobContext.hivectx();
        DataFrame dataFrame = hiveContext.sql("show databases");
        StringBuilder sb = new StringBuilder();

        sb.append("columns : ");
        String[] columnsArray = dataFrame.columns();
        if(columnsArray == null){
            System.out.println("*********************** columns is empty");
        }

        for (String s : dataFrame.columns()){
            sb.append(s);
            sb.append(",");
        }

        sb.append("count :");
        sb.append(String.valueOf(dataFrame.count()));

        Row[] rows = dataFrame.collect();
        for (Row row : rows){
            sb.append(row.toString());
            sb.append(",");
        }
        sb.append("over");
        return sb.toString();
    }
}
