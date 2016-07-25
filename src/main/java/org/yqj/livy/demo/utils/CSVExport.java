package org.yqj.livy.demo.utils;

import com.google.common.base.Throwables;
import com.google.common.collect.Iterables;
import com.google.common.io.Files;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

/**
 * Created by yaoqijun.
 * Date:2016-07-19
 * Email:yaoqj@terminus.io
 * Descirbe: csv 文件导出Tool
 */
@Slf4j
public class CSVExport {

    private static final String NEW_LINE_SEPARATOR = "\n";

    /**
     * Output 对应的文件信息
     * @param fileName 文件名称
     * @param titles    输出文件标题 可以为空
     * @param data  数据内容
     */
    public static OutputStream exportCsv(String fileName, List<String> titles, List<List<String>> data) throws IOException {

        FileOutputStream fileStream = new FileOutputStream(fileName);

        CSVPrinter csvFilePrinter = null;

        //Create the CSVFormat object with "\n" as a record delimiter
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);

        log.info("start to export csv file content, fileName :{}", fileName);

        try {

            //initialize CSVPrinter object
            csvFilePrinter = new CSVPrinter(new OutputStreamWriter(fileStream), csvFileFormat);

            //Create CSV file header
            if(!isNull(titles) && Iterables.isEmpty(titles)){
                csvFilePrinter.printRecord(titles);
            }

            //Write a new student object list to the CSV file
            for (List<String> dataLine : data) {
                csvFilePrinter.printRecord(dataLine);
            }

            log.info("success print output file, fileName :{}",fileName);

        } catch (Exception e) {
            log.info("error output stream csv content, cause:{}", Throwables.getStackTraceAsString(e));
        } finally {
            try {
                csvFilePrinter.close();
            } catch (IOException e) {
                log.info("close output stream fail, cause:{}", Throwables.getStackTraceAsString(e));
            }
        }
        // out stream
        return fileStream;
    }

}