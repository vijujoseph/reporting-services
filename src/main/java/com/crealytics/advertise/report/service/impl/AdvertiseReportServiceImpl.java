package com.crealytics.advertise.report.service.impl;

import com.crealytics.advertise.report.domain.ReportData;
import com.crealytics.advertise.report.repository.ReportDataRepository;
import com.crealytics.advertise.report.service.AdvertiseReportService;
import com.crealytics.advertise.report.util.ReportDataConst;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdvertiseReportServiceImpl implements AdvertiseReportService {

    private static final Logger log = LoggerFactory.getLogger(AdvertiseReportServiceImpl.class);

    @Autowired
    ReportDataRepository reportDataRepository;

    @Override
    public List<ReportData> findBySiteAndReportMonth(String site, String month) {
        site = validateAndFilterSite(site);
        month = validateAndFilterMonth(month);

        List<ReportData> reports = new ArrayList<>();
        if (StringUtils.isNotBlank(site) && StringUtils.isNotBlank(month)) {
            reports = reportDataRepository.findBySiteAndReportMonth(site, month);
        } else if (StringUtils.isNotBlank(site)) {
            reports = reportDataRepository.findBySite(site);
        } else if (StringUtils.isNotBlank(month)) {
            reports = reportDataRepository.findByReportMonth(month);
        }
        mapAdvertiseReportResponse(reports);
        return reports;
    }

    /*
        Mapper which converts months in numerics (1-12) to Alpha format (January - December)
     */
    private void mapAdvertiseReportResponse(List<ReportData> reports) {
        reports.forEach(reportData -> {
                    reportData.setReportMonth(ReportDataConst.MONTH_TO_ALFA_MAPPER.get(reportData.getReportMonth()));
                    reportData.setClickThroughRate(twoDigitPrecisionConversion(reportData.getClickThroughRate()));
                    reportData.setConversionRate(twoDigitPrecisionConversion(reportData.getConversionRate()));
                    reportData.setFillRate(twoDigitPrecisionConversion(reportData.getFillRate()));
                    reportData.seteCPM(twoDigitPrecisionConversion(reportData.geteCPM()));
                }
        );
    }

    /*  input: @Month
        Month - can be in below format:
         * numeric (ranging from 1-12) that map to the corresponding months (`1` for `January`, `2` for `February` etc)
         * first 3 letters of the month (`Jan` for `January`, `Feb` for `February` etc)
         * full name of the month (case insensitive)
    */
    private String validateAndFilterMonth(String month) throws NumberFormatException {
        if (StringUtils.isNotBlank(month)) {
            if (month.length() <= 2) {
                if (!month.matches("-?(0|[1-9]\\d*)") || Integer.valueOf(month) > 12) {
                    log.error("Invalid month format : " + month + ". The month format should be with-in range 1-12 (Jan - Dec)");
                }
            } else {
                if (month.length() >= 3) {
                    month = ReportDataConst.MONTH_TO_NUMERIC_MAPPER.get(month.toLowerCase().substring(0, 3));

                }
            }
        }
        return month;
    }

    /*
    input: @Site
    Site - can be in the following form - desktop_web, desktop web, mobile_web, mobile web, android
    */
    private String validateAndFilterSite(String site) {
        if (StringUtils.isNotBlank(site)) {
            site = site.toLowerCase();
            if (StringUtils.equals(site, "desktop_web") || StringUtils.equals(site, "mobile_web") || StringUtils.equals(site, "ios")) {
                site = ReportDataConst.SITE_MAPPER.get(site);
            }
        }
        return site;
    }

    /*
       Also used for 2-digit precision for all double values.
     */
    private double twoDigitPrecisionConversion(double input) {
        BigDecimal bd = new BigDecimal(input).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}