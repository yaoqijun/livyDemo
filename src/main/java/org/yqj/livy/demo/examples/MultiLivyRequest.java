package org.yqj.livy.demo.examples;

import com.cloudera.livy.LivyClient;
import com.cloudera.livy.LivyClientBuilder;
import com.cloudera.livy.shaded.jackson.databind.ser.std.StdArraySerializers;
import org.yqj.livy.demo.examples.hiveTest.HiveDatabaseSqlQuery;
import org.yqj.livy.demo.examples.hiveTest.HiveTableDataSelectTest;

import java.io.File;
import java.net.URI;
import java.util.Random;

/**
 * Created by yaoqijun.
 * Date:2016-07-15
 * Email:yaoqj@terminus.io
 * Descirbe: 测试对应的Livy 多线程操作方式
 */
public class MultiLivyRequest {

    public static void main(String[] args) throws Exception {

        System.out.println("test multi livy client");

        String livyUrl = "http://localhost:8998/";

        for(int i = 0; i<3; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    LivyClient client = null;
                    try{
                        client = new LivyClientBuilder()
                                .setURI(new URI(livyUrl))
                                .setConf("spark.app.name","testMasterAllSpark")
                                .build();

                        String piJar = "/Users/yaoqijun/github/livyDemo/jar/livy-demo-1.0-SNAPSHOT.jar";
                        client.uploadJar(new File(piJar)).get();

                        Random random = new Random();
                        Boolean b = random.nextBoolean();
                        String result = null;
                        if(b){
                            result = client.submit(new HiveDatabaseSqlQuery("use test", "select * from manager")).get();
                        }else {
                            result = client.submit(new HiveDatabaseSqlQuery("use testagain", "select * from content")).get();
                        }
                        System.out.println("**************** test condition");
                        System.out.println("boolean is "+b);
                        System.out.println("hive Context result is : " + result);
                    }catch (Exception e){
                        System.out.println("error **********");
                    }finally {
                        client.stop(true);
                    }
                }
            }
            ).start();
        }

    }

    class RunClientTest implements Runnable{

        private LivyClient livyClient;

        public RunClientTest(LivyClient livyClient){
            this.livyClient = livyClient;
        }

        @Override
        public void run() {
//            try{
//                String result = livyClient.submit(new HiveDatabaseSqlQuery("test", "select * from manager")).get();
//                System.out.println("**************** test condition");
//                System.out.println("hive Context result is : " + result);
//                Thread.sleep(10000);
//            }catch (Exception e){
//                System.out.println("error **********");
//            }finally {
//                livyClient.stop(true);
//            }
        }
    }

}
