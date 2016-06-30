package org.yqj.livy.demo.examples;

import akka.japi.Function2;
import org.apache.spark.api.java.function.Function;

/**
 * Created by yaoqijun.
 * Date:2016-06-30
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class PiJob implements
        Function<Integer, Integer>,
        Function2<Integer, Integer, Integer>{



        public Integer call(Integer v1) throws Exception {
                return null;
        }

        public Integer apply(Integer arg1, Integer arg2) throws Exception {
                return null;
        }
}
