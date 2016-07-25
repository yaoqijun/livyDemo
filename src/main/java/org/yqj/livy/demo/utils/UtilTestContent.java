package org.yqj.livy.demo.utils;

import com.clearspring.analytics.util.Lists;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.*;

import java.io.*;
import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * Created by yaoqijun.
 * Date:2016-07-19
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class UtilTestContent {
    public static void main(String[] args) throws IOException {
        List<String> s = Lists.newArrayList();
        s.add("1");s.add("2");s.add("3");s.add("4");
        List<List<String>> data = Lists.newArrayList();
        data.add(s);

        OutputStream out = CSVExport.exportCsv("test.txt", null, data);
        out.flush();
        out.close();
    }
}
