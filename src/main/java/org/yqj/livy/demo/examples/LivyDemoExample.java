package org.yqj.livy.demo.examples;

import com.cloudera.livy.LivyClient;
import com.cloudera.livy.LivyClientBuilder;

import java.io.File;
import java.net.URI;

/**
 * Created by yaoqijun.
 * Date:2016-06-30
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class LivyDemoExample {
    public static void main(String[] args) throws Exception{

        String livyUrl = "http://localhost:8998/";

        LivyClient client = new LivyClientBuilder()
                .setURI(new URI(livyUrl))
                .build();

        try {
            int samples = 100000;
            String piJar = "/Users/yaoqijun/github/livyDemo/jar/livy-demo-1.0-SNAPSHOT.jar";
//            System.err.printf("Uploading %s to the Spark context...\n", piJar);
            client.uploadJar(new File(piJar)).get();

//            System.err.printf("Running PiJob with %d samples...\n", samples);
            double pi = client.submit(new PiJob()).get();

            System.out.println("Pi is roughly: " + pi);
        }catch (Exception e){
            System.out.println(e);
        }finally {
            client.stop(true);
        }
    }
}
