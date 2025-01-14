package foi.air.szokpt.reports.util;

import java.util.List;

public class ResponseCodeConstants {
    public static final List<String> SUCCESS_CODES = List.of("00", "08", "10", "11", "23");
    public static final List<String> REJECTED_CODES = List.of("05", "12", "14", "41", "43", "51", "54", "57", "59", "91", "96");
    public static final List<String> CANCELED_CODES = List.of("17", "22", "33", "34", "40");
}
