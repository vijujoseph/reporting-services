package com.crealytics.advertise.report.domain;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReportData {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long dataId;

    private String site;
    private String request;
    private String impressions;
    private String click;
    private String conversions;
    private String revenue;
    private String reportMonth;
    private double clickThroughRate;
    private double conversionRate;
    private double fillRate;
    private double eCPM;

    public ReportData() {
    }

    public ReportData(String site, String request, String impressions, String click, String conversions, String revenue,String reportMonth) {
        this.site = site;
        this.request = request;
        this.impressions = impressions;
        this.click = click;
        this.conversions = conversions;
        this.revenue = revenue;

        //Intentionally ignoring year, since the requirement say's to consider only the month(1-12, jan-dec)
        this.reportMonth = reportMonth;
    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public String getSite() {
        return StringUtils.isNotBlank(site) ? site.replace("_"," ") : "";
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getImpressions() {
        return impressions;
    }

    public void setImpressions(String impressions) {
        this.impressions = impressions;
    }

    public String getClick() {
        return click;
    }

    public void setClick(String click) {
        this.click = click;
    }

    public String getConversions() {
        return conversions;
    }

    public void setConversions(String conversions) {
        this.conversions = conversions;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public String getReportMonth() {
        return reportMonth;
    }

    public void setReportMonth(String reportMonth) {
        this.reportMonth = reportMonth;
    }

    public double getClickThroughRate() {
        return clickThroughRate;
    }

    public void setClickThroughRate(double clickThroughRate) {
        this.clickThroughRate = clickThroughRate;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public double getFillRate() {
        return fillRate;
    }

    public void setFillRate(double fillRate) {
        this.fillRate = fillRate;
    }

    public double geteCPM() {
        return eCPM;
    }

    public void seteCPM(double eCPM) {
        this.eCPM = eCPM;
    }

    @Override
    public String toString() {
        return "ReportData{" +
                "dataId=" + dataId +
                ", site='" + site + '\'' +
                ", request='" + request + '\'' +
                ", impressions='" + impressions + '\'' +
                ", click='" + click + '\'' +
                ", conversions='" + conversions + '\'' +
                ", revenue='" + revenue + '\'' +
                ", reportMonth='" + reportMonth + '\'' +
                ", clickThroughRate=" + clickThroughRate +
                ", conversionRate=" + conversionRate +
                ", fillRate=" + fillRate +
                ", eCPM=" + eCPM +
                '}';
    }
}
