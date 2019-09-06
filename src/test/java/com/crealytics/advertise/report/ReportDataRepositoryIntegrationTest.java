package com.crealytics.advertise.report;

import com.crealytics.advertise.report.domain.ReportData;
import com.crealytics.advertise.report.repository.ReportDataRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReportDataRepositoryIntegrationTest {

    @Autowired
    private ReportDataRepository reportDataRepository;

    @Test
    public void whenFindBySiteAndReportMonthVaildDataTest() {

        ReportData report = new ReportData("desktop web","11243875","10366355","40456","1456","15745.32","1");
        reportDataRepository.save(report);

        // when
        List<ReportData> found = reportDataRepository.findBySiteAndReportMonth("desktop web","1");

        // then
        Assert.assertEquals(found.get(0).getSite(), report.getSite());
    }

    @Test
    public void whenFindBySiteInvalidDataTest() {

        ReportData report = new ReportData("desktop_web","11243875","10366355","40456","1456","15745.32","1");
        reportDataRepository.save(report);

        // when
        List<ReportData> found = reportDataRepository.findBySiteAndReportMonth(report.getSite(),report.getReportMonth());

        // then
        Assert.assertEquals(found.size() > 0 ? found.get(0).getSite() : null, "desktop web");
    }

    @Test
    public void whenFindByMonthValidDataTest() {

        ReportData report = new ReportData("desktop web","11243875","10366355","40456","1456","15745.32","1");
        reportDataRepository.save(report);

        // when
        List<ReportData> found = reportDataRepository.findByReportMonth("1");

        // then
        Assert.assertEquals(found.size() > 0 ? found.get(0).getReportMonth() : null, "1");
        Assert.assertEquals(found.get(0).getSite(), report.getSite());

    }

    @Test
    public void whenFindBySiteValidDataTest() {

        ReportData report = new ReportData("desktop web","11243875","10366355","40456","1456","15745.32","1");
        reportDataRepository.save(report);

        // when
        List<ReportData> found = reportDataRepository.findBySite("desktop web");

        // then
        Assert.assertEquals(found.size() > 0 ? found.get(0).getReportMonth() : null, "1");
        Assert.assertEquals(found.get(0).getSite(), report.getSite());

    }


    @Test
    public void whenFindBySiteInValidDataTest() {

        ReportData report = new ReportData("desktop web","11243875","10366355","40456","1456","15745.32","1");
        reportDataRepository.save(report);

        // when
        List<ReportData> found = reportDataRepository.findBySite("desktop web1");

        // then
        Assert.assertNull(found.size() > 0 ? found.get(0).getSite() : null);
    }

    @Test
    public void whenFindBySiteOrReportMonthVaildDataTest() {

        ReportData report = new ReportData("desktop web","11243875","10366355","40456","1456","15745.32","1");
        reportDataRepository.save(report);

        // when
        List<ReportData> found = reportDataRepository.findBySiteOrReportMonth("desktop web","1");

        // then
        Assert.assertEquals(found.get(0).getSite(), report.getSite());
    }
}