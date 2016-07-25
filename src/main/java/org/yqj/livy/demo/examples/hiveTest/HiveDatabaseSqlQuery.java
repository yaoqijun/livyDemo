package org.yqj.livy.demo.examples.hiveTest;

import com.cloudera.livy.Job;
import com.cloudera.livy.JobContext;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.hive.HiveContext;

/**
 * Created by yaoqijun.
 * Date:2016-07-15
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class HiveDatabaseSqlQuery implements Job<String>{

    private String databaseName;

    private String sql;

    public HiveDatabaseSqlQuery(String databaseName, String sql){
        this.databaseName = databaseName;
        this.sql = sql;
    }

    @Override
    public String call(JobContext jobContext) throws Exception {
        HiveContext hiveContext = jobContext.hivectx();

        System.out.println("execute use database");
        hiveContext.sql(databaseName).collect();

        System.out.println("to collect all data");
        Row[] rows = hiveContext.sql(sql).collect();
        StringBuilder sb = new StringBuilder();
        for(Row row : rows){
            sb.append("-");
            for(int i=0; i<row.length(); i++){
                sb.append(row.get(i).toString());
            }
            sb.append("-");
        }
        return sb.toString();
    }
}
