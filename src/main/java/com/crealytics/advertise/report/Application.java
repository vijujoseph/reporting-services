package com.crealytics.advertise.report;

import com.crealytics.advertise.report.domain.ReportData;
import com.crealytics.advertise.report.repository.ReportDataRepository;
import com.crealytics.advertise.report.util.AdditionalMetricsUtil;
import com.crealytics.advertise.report.util.ParseExcelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner startUp(ReportDataRepository reportDataRepository) {
        return (args) -> {
            //Parsing the CSV files(publisher advertising reporting data) and saving data
            List<ReportData> reportDataList = ParseExcelUtils.parseFile();

            /*Populate additional data metrics from the CSV file:
                * CTR
                * CR
                * Fill Rate
                * eCPM*/
            AdditionalMetricsUtil.populateAdditionalMetrics(reportDataList);
            reportDataRepository.saveAll(reportDataList);


            log.info("ReportData found with findAll():");
            log.info("-------------------------------");
            for (ReportData reportData : reportDataRepository.findAll()) {
                log.info(reportData.toString());
            }
        };
    }

}