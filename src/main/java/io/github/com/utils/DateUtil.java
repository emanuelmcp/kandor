package io.github.com.utils;

import java.time.Instant;
import java.util.Date;

public class DateUtil {
    public static Date getZuluDate() {
        return Date.from(Instant.now());
    }
}
