package com.info.util;

import java.time.LocalDateTime;

public class DataParserUtil {

    public LocalDateTime StringToLDT(String stringLocalDatetime) {
        String parsedDateTimeString = stringLocalDatetime.substring(0, 19);
        LocalDateTime localDateTime = LocalDateTime.parse(parsedDateTimeString);

        return localDateTime;
    }
}
