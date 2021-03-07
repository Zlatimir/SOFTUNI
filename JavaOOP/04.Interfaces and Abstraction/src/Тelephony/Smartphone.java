package Тelephony;

import java.util.List;

/**
 * Created by Zlatimir Ivanov on 7.3.2021 г..
 */

public class Smartphone implements Callable, Browsable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
           if (number.matches("[0-9]+")) {
               sb.append("Calling... ").append(number).append(System.lineSeparator());
           } else {
               sb.append("Invalid number!").append(System.lineSeparator());
           }
        }
        return sb.toString().trim();
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            if (url.matches("[^0-9]+")) {
                sb.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            } else {
                sb.append("Invalid URL!").append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
