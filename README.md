# reporting-services
**Solution for advertising reporting web services**

**Description:**
The RESTful web service that can offer reporting advertising data, part of which
is extracted from a csv file and the rest being calculated as additional metrics.

**Excluded scenarios**
1. Year is not considered in the solution (so you don't have to take the year 2018 into account.)

**Pre-requisite:**
1. JDK 1.8
    To check, run java -version:

        $ java -version
        java version "1.8.0_121"
2. Any IDE, preferably Intellij
3. Initial data load (CSV files data load) instructions
       
   As part of package, application is already loaded the csv files -  January [2018_01_report.csv](2018_01_report.csv) and February [2018_02_report.csv](2018_02_report.csv)
   To add new csv files, copy the files to folder (src/main/resources) and add the newly added file name
   to the file -> ParseExcelUtils.java -> filesNames[]
       
          e.g) String fileNames[] = {"2018_01_report.csv","2018_02_report.csv"};
      p.s: Ideal scenarios the above entry needs to be added in application.property files

**Installation and Setup:**
1. Go to the github url - https://github.com/vijujoseph/reporting-services
2. select 'Clone or download', copy the URL
3. Open intelliJ - File -> New -> Project From Version Control -> git
4. Enter URL - which was cloned in step 2 and click clone button
4. IntelliJ will show and option to Import gradle projects, choose the option and 
    refresh all gradle dependencies
5. Click build
6. Run bootRun

**Guidance - Api Specification:**

    localhost:8080/reports?month=*XXX&site=**XXXXXXX (hostname:<port>/path)
    Use chrome or any rest clients for REST request and response
    
    *month can be any valid format such as [1-12 or Jan-Dec or January-December]
    **site can be any valid format such as [desktop_web,mobile_web,android,iOS]
**Few Examples are below:**  
1. http://localhost:8080/reports?month=1&site=ios
    ```
    [
        {
        "dataId": 4,
        "site": "iOS",
        "request": " 2550165",
        "impressions": " 2419733",
        "click": " 6331",
        "conversions": " 1564",
        "revenue": " 4692.28",
        "reportMonth": "January",
        "clickThroughRate": 0.26164043718873115,
        "conversionRate": 0.06463523041591779,
        "fillRate": 94.88535055574835,
        "eCPM": 46922.8
        }
    ]
    ```
2. http://localhost:8080/reports?month=January&site=ios
    ```
    [
        {
        "dataId": 4,
        "site": "iOS",
        "request": " 2550165",
        "impressions": " 2419733",
        "click": " 6331",
        "conversions": " 1564",
        "revenue": " 4692.28",
        "reportMonth": "January",
        "clickThroughRate": 0.26164043718873115,
        "conversionRate": 0.06463523041591779,
        "fillRate": 94.88535055574835,
        "eCPM": 46922.8
        }
    ]
    ```
3. http://localhost:8080/reports?month=Jan&site=ios
   ```
    [
        {
        "dataId": 4,
        "site": "iOS",
        "request": " 2550165",
        "impressions": " 2419733",
        "click": " 6331",
        "conversions": " 1564",
        "revenue": " 4692.28",
        "reportMonth": "January",
        "clickThroughRate": 0.26164043718873115,
        "conversionRate": 0.06463523041591779,
        "fillRate": 94.88535055574835,
        "eCPM": 46922.8
        }
    ]
    ```
4. http://localhost:8080/reports?month=Jan

   ```
    [
        {
        "dataId": 1,
        "site": "desktop web",
        "request": " 12483775",
        "impressions": " 11866157",
        "click": " 30965",
        "conversions": " 7608",
        "revenue": " 23555.46",
        "reportMonth": "January",
        "clickThroughRate": 0.2609522189871582,
        "conversionRate": 0.06411511325865653,
        "fillRate": 95.05263431934651,
        "eCPM": 235554.6
        },
    -
    -
    ]
    ```
    
5. http://localhost:8080/reports?month=2
    ```
    [
        {
        "dataId": 5,
        "site": "desktop web",
        "request": " 11243875",
        "impressions": " 10366355",
        "click": " 40456",
        "conversions": " 1456",
        "revenue": " 15745.32",
        "reportMonth": "February",
        "clickThroughRate": 0.3902625368318951,
        "conversionRate": 0.01404543834356435,
        "fillRate": 92.19557314537916,
        "eCPM": 157453.2
        },
    -
    -
    ]
    ```
    
6. http://localhost:8080/reports?site=ios
    ```
    [
        {
        "dataId": 4,
        "site": "iOS",
        "request": " 2550165",
        "impressions": " 2419733",
        "click": " 6331",
        "conversions": " 1564",
        "revenue": " 4692.28",
        "reportMonth": "January",
        "clickThroughRate": 0.26164043718873115,
        "conversionRate": 0.06463523041591779,
        "fillRate": 94.88535055574835,
        "eCPM": 46922.8
        },
    -
    -
    ]
    ```
    
7. http://localhost:8080/reports?site=desktop_web
    ```
    [
        {
        "dataId": 1,
        "site": "desktop web",
        "request": " 12483775",
        "impressions": " 11866157",
        "click": " 30965",
        "conversions": " 7608",
        "revenue": " 23555.46",
        "reportMonth": "January",
        "clickThroughRate": 0.2609522189871582,
        "conversionRate": 0.06411511325865653,
        "fillRate": 95.05263431934651,
        "eCPM": 235554.6
        },
    -
    -
    ]
    ```