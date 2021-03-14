package interfaces;

import enums.ReportLevel;

/**
 * Created by Zlatimir Ivanov on 14.3.2021 г..
 */

public interface Layout {
    String format(String date, ReportLevel reportLevel, String message);
}
