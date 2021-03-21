package exercise.harvestingFields.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Class<RichSoilLand> clazz = RichSoilLand.class;

        Field[] fields = clazz.getDeclaredFields();

//	•	private - print all private fields - 2
//•	protected - print all protected fields - 4
//•	public - print all public fields - 1
//•	all - print ALL declared fields
//•	HARVEST - end the input


        String line = sc.nextLine();

        while (!"HARVEST".equals(line)) {
            Field[] filteredFields = new Field[]{};
            String finalLine = line;
            if (!finalLine.equals("all")) {
                filteredFields = Arrays.stream(fields).filter(f -> Modifier.toString(f.getModifiers())
                        .equals(finalLine)).toArray(Field[]::new);
            }
            if (line.equals("all")) {
                printFields(fields);
            } else {
                printFields(filteredFields);
            }

            line = sc.nextLine();
        }

    }

    private static void printFields(Field[] fields) {
        Arrays.stream(fields).forEach(f -> System.out.printf("%s %s %s%n",
                Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName()));
    }
}
