package org.yqj.livy.demo.examples;

import com.cloudera.livy.LivyClient;
import com.cloudera.livy.LivyClientBuilder;
import org.yqj.livy.demo.examples.hiveTest.HiveContextTest;
import org.yqj.livy.demo.examples.hiveTest.HiveTableDataSelectTest;
import org.yqj.livy.demo.examples.job.PiJob;

import java.io.File;
import java.net.URI;

/**
 * Created by yaoqijun.
 * Date:2016-06-30
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class LivyDemoExample {
//    public static void main(String[] args) throws Exception{
//
//        String livyUrl = "http://localhost:8998/";
//
//        LivyClient client = new LivyClientBuilder()
//                .setURI(new URI(livyUrl))
//                .setConf("spark.app.name","testSparkAppName")
//                .setConf("spark.cores.max", "1")
//                .build();
//
//        try {
//            String piJar = "/Users/yaoqijun/github/livyDemo/jar/livy-demo-1.0-SNAPSHOT.jar";
//            client.uploadJar(new File(piJar)).get();
//
//            String result = client.submit(new HiveTableDataSelectTest()).get();
//
//            System.out.println("**************** test condition");
//            System.out.println("hive Context result is : " + result);
//        }catch (Exception e){
//            System.out.println(e);
//        }finally {
//            client.stop(true);
//        }
//    }
}
