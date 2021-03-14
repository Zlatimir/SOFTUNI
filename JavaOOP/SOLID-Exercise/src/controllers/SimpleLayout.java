package controllers;

import enums.ReportLevel;
import interfaces.Layout;

/**
 * Created by Zlatimir Ivanov on 14.3.2021 г..
 */

public class SimpleLayout implements Layout {
    @Override
    public String format(String date, ReportLevel reportLevel, String message) {
        return String.format("%s - %s - %s", date, reportLevel, message);
    }
}
