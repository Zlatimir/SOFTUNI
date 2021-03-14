package controllers;

import enums.ReportLevel;
import interfaces.Appender;
import interfaces.Layout;

/**
 * Created by Zlatimir Ivanov on 14.3.2021 г..
 */

public class ConsoleAppender implements Appender {
    private Layout layout;

    public ConsoleAppender(Layout layout) {
        this.layout = layout;
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        System.out.println(this.layout.format(date, reportLevel, message));
    }
}
