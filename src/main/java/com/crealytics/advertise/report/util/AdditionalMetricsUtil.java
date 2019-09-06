package com.crealytics.advertise.report.util;

import com.crealytics.advertise.report.domain.ReportData;

import java.util.List;

public final class AdditionalMetricsUtil {

    public static void populateAdditionalMetrics(List<ReportData> reportDataList) {
        reportDataList.forEach( reportData -> {
            // **CTR (%)**: Click-through rate.  Expressed as a percentage. -
            //  Literally, the ratio of users who click on a specific -
            //  link to the number of total users who view an advertisement
            // **CTR = (clicks ÷ impressions) × 100%**
            reportData.setClickThroughRate((Double.valueOf(reportData.getClick())/Double.valueOf(reportData.getImpressions()))*100);

            // **CR (%)**: Conversion rate. The ratio of conversions to the number of impressions
            // **CR = (conversions ÷ impressions) × 100%**
            reportData.setConversionRate((Double.valueOf(reportData.getConversions())/Double.valueOf(reportData.getImpressions()))*100);

            // **Fill Rate**: The ratio of impressions to the number of requests. It varies by inventory.
            // **Fill Rate = (impressions ÷ requests) × 100%**
            reportData.setFillRate((Double.valueOf(reportData.getImpressions())/Double.valueOf(reportData.getRequest()))*100);

            // **eCPM**: Effective Cost Per Thousand. A translation from CPM, expressed as such from a publisher's point of view.
            // **eCPM = (revenue × 1000) ÷ impressions**
            reportData.seteCPM((Double.valueOf(reportData.getRevenue())*1000)/100);
        });
    }
}
