package interfaces;

import enums.ReportLevel;

/**
 * Created by Zlatimir Ivanov on 14.3.2021 г..
 */

public interface Appender {
     void append(String date, ReportLevel reportLevel, String message);
}
