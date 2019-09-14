package com.crealytics.advertise.report;

import com.crealytics.advertise.report.domain.ReportData;
import com.crealytics.advertise.report.service.AdvertiseReportService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdvertiseReportServiceTest.class, webEnvironment = WebEnvironment.NONE)
@ComponentScan({"com.crealytics.advertise.report"})
public class AdvertiseReportServiceTest {

    @Autowired()
    private AdvertiseReportService advertiseService;

    @Test
    public void findBySiteAndReportMonthValidDataTest() {
        List<ReportData> result = advertiseService.findBySiteAndReportMonth("ios", "2");
        assertNotNull(result);
    }

    @Test
    public void findBySiteAndReportMonthInValidDataTest() {
        List<ReportData> result = advertiseService.findBySiteAndReportMonth("iii", "2");
        assertEquals(result.size(), 0);
    }

    @Test
    public void findBySiteOnlyValidDataTest() {
        List<ReportData> result = advertiseService.findBySiteAndReportMonth("iOs", "");
        assertEquals(result.size(), 4);
        assertEquals(String.valueOf(result.get(0).getReportMonth()), "January");
        assertEquals(String.valueOf(result.get(0).getClickThroughRate()), "0.26");
        assertEquals(String.valueOf(result.get(0).getConversionRate()), "0.06");
        assertEquals(String.valueOf(result.get(0).getFillRate()), "94.89");
        assertEquals(String.valueOf(result.get(0).geteCPM()), "46922.8");
    }

    @Test
    public void findBySiteAndReportMonthInValidData1Test() {
        List<ReportData> result = advertiseService.findBySiteAndReportMonth("", "");
        assertEquals(result.size(), 0);
    }

}