package com.crealytics.advertise.report.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ReportDataConst {

    public static final Map<String, String> MONTH_TO_NUMERIC_MAPPER =
            Collections.unmodifiableMap(new HashMap<String, String>() {{
                put("jan", "1");
                put("feb", "2");
                put("mar", "3");
                put("apr", "4");
                put("may", "5");
                put("jun", "6");
                put("jul", "7");
                put("aug", "8");
                put("sep", "9");
                put("oct", "10");
                put("nov", "11");
                put("dec", "12");
            }});

    public static final Map<String, String> MONTH_TO_ALFA_MAPPER =
            Collections.unmodifiableMap(new HashMap<String, String>() {{
                put("1", "January");
                put("2", "February");
                put("3", "March");
                put("4", "April");
                put("5", "May");
                put("6", "June");
                put("7", "July");
                put("8", "August");
                put("9", "Sept");
                put("10", "October");
                put("11", "November");
                put("12", "December");
            }});

    public static final Map<String, String> SITE_MAPPER =
            Collections.unmodifiableMap(new HashMap<String, String>() {{
                put("desktop_web", "desktop web");
                put("mobile_web", "mobile web");
                put("ios","iOS");
            }});

}
