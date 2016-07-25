package org.yqj.livy.demo.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaoqijun.
 * Date:2016-07-19
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class CSVReaderTest {
    public static void main(String[] args) {
        //CSV file header
        String [] FILE_HEADER_MAPPING = {"id","firstName","lastName","gender","age"};

        //Student attributes
        String STUDENT_ID = "id";
        String STUDENT_FNAME = "firstName";
        String STUDENT_LNAME = "lastName";
        String STUDENT_GENDER = "gender";
        String STUDENT_AGE = "age";

        FileReader fileReader = null;

        CSVParser csvFileParser = null;

            //Create the CSVFormat object with the header mapping
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);

        try {

            //Create a new list of student to be filled by CSV file data
            List<Student> students = new ArrayList();

            //initialize FileReader object
            fileReader = new FileReader("students.csv");

            //initialize CSVParser object
            csvFileParser = new CSVParser(fileReader, csvFileFormat);

            //Get a list of CSV file records
            List<CSVRecord> csvRecords = csvFileParser.getRecords();

            //Read the CSV file records starting from the second record to skip the header
            for (int i = 1; i < csvRecords.size(); i++) {
                CSVRecord record = csvRecords.get(i);
                //Create a new student object and fill his data
                Student student = new Student(Long.parseLong(record.get(STUDENT_ID)), record.get(STUDENT_FNAME), record.get(STUDENT_LNAME), record.get(STUDENT_GENDER), Integer.parseInt(record.get(STUDENT_AGE)));
                students.add(student);
            }

            //Print the new student list
            for (Student student : students) {
                System.out.println(student.toString());
            }
        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                csvFileParser.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader/csvFileParser !!!");
                e.printStackTrace();
            }
        }

    }
}
