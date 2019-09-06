package com.crealytics.advertise.report.repository;

import com.crealytics.advertise.report.domain.ReportData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportDataRepository extends CrudRepository<ReportData, Long> {

    List<ReportData> findBySite(String site);

    List<ReportData> findByReportMonth(String site);

    List<ReportData> findBySiteAndReportMonth(String site, String month);

    List<ReportData> findBySiteOrReportMonth(String site, String month);


}