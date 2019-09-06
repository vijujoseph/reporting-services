package com.crealytics.advertise.report.controller;

import com.crealytics.advertise.report.domain.ReportData;
import com.crealytics.advertise.report.service.AdvertiseReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdvertiseReportController {

    @Autowired
    AdvertiseReportService advertiseReportService;

    @RequestMapping(value = "/reports")
    public List<ReportData> reports(@RequestParam (name="month", required = false) String month,
                                   @RequestParam (value="site", required = false) String site) {
        List<ReportData> reports = advertiseReportService.findBySiteAndReportMonth(site,month);
        return reports;
    }

}
