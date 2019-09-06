package com.crealytics.advertise.report.service;

import com.crealytics.advertise.report.domain.ReportData;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdvertiseReportService {

    List<ReportData> findBySiteAndReportMonth(String site, String month);
}
