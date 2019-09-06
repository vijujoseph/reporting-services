package com.crealytics.advertise.report.util;

import com.crealytics.advertise.report.domain.ReportData;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public final class ParseExcelUtils {

    private static final Logger log = LoggerFactory.getLogger(ParseExcelUtils.class);
    private static final int MONTH_BEGIN_INDEX = 6;
    private static final int MONTH_END_INDEX = 7;
    public static List<ReportData> parseFile() throws IOException, InvalidFormatException {

        String line = "";
        String cvsSplitBy = ",";
        List<ReportData> list = new ArrayList<>();

        //fileNames - The names of the publisher advertising reporting data
        String fileNames[] = {"2018_01_report.csv","2018_02_report.csv"};

        for(String file : fileNames) {
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(new ClassPathResource(file).getInputStream()));) {
                int count = 0;
                while ((line = br.readLine()) != null) {
                    // ignore headers
                    if (count == 0) {
                        count++;
                        continue;
                    }

                    // use comma as separator
                    String[] data = line.split(cvsSplitBy);
                    list.add(new ReportData(data[0], data[1], data[2], data[3], data[4], data[5], file.substring(MONTH_BEGIN_INDEX,MONTH_END_INDEX)));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
