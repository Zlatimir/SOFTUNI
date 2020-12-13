package JavaFundExam04042020Practice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Zlatimir Ivanov on 25.11.2020 г..
 */

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //regexr.com/5h0vs - mathes valid barcodes
        Pattern patternValidBarcode = Pattern.compile("@#+[A-Z][A-Z0-9a-z]{4,}[A-Z]@#+");

        Pattern patternDigits = Pattern.compile("[0-9]");

        int n = Integer.parseInt(sc.nextLine());
        String product = "";
        for (int i = 0; i < n; i++) {
            String barcode = sc.nextLine();
            Matcher matcherBarcode = patternValidBarcode.matcher(barcode);
            if (!matcherBarcode.find()){
                System.out.println("Invalid barcode");
            } else {
                Matcher matcherDigit = patternDigits.matcher(barcode);
                while (matcherDigit.find()){
                    product = product + matcherDigit.group(0);
                }
                if (product.equals("")){
                    product = "00";
                }
                System.out.println("Product group: " + product);
            }
            product = "";
        }
    }
}
