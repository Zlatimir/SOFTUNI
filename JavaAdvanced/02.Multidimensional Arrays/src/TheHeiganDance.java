import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 22.12.2020 г..
 */

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int playerRow = 7;
        int playerCol = 7;

        int playerHP = 18500;
        double heiganHP = 3000000;
        double playerDamage = Double.parseDouble(sc.nextLine());
        String lastSpell = "";
        while (true) {
            if (playerHP >= 0) {
                heiganHP -= playerDamage;
            }
            if (lastSpell.equals("Cloud")) {
                playerHP -= 3500;
            }
            if (heiganHP <= 0 || playerHP <= 0) {
                break;
            }
            String[] line = sc.nextLine().split(" ");
            String currentSpell = line[0];
            int targetRow = Integer.parseInt(line[1]);
            int targetCol = Integer.parseInt(line[2]);
            if (isInDamageArea(targetRow, targetCol, playerRow, playerCol)) {
                if (!isInDamageArea(targetRow, targetCol, playerRow - 1, playerCol) && !isWall(playerRow - 1)) {
                    playerRow--;
                    lastSpell = "";
                } else if (!isInDamageArea(targetRow, targetCol, playerRow, playerCol + 1) && !isWall(playerCol + 1)) {
                    playerCol++;
                    lastSpell = "";
                } else if (!isInDamageArea(targetRow, targetCol, playerRow + 1, playerCol) && !isWall(playerRow + 1)) {
                    playerRow++;
                    lastSpell = "";
                } else if (!isInDamageArea(targetRow, targetCol, playerRow, playerCol - 1) && !isWall(playerCol - 1)) {
                    playerCol--;
                    lastSpell = "";
                } else {
                    if (currentSpell.equals("Cloud")) {
                        playerHP -= 3500;
                        lastSpell = "Cloud";
                    } else if (currentSpell.equals("Eruption")) {
                        playerHP -= 6000;
                        lastSpell = "Eruption";
                    }
                }
            }
        }
        if (lastSpell.equals("Cloud")) lastSpell = "Plague Cloud";
        else lastSpell = "Eruption";
        String heiganState = heiganHP <= 0 ? "Heigan: Defeated!" : String.format("Heigan: %.2f", heiganHP);
        String playerState = playerHP <= 0 ? String.format("Player: Killed by %s", lastSpell) :
                String.format("Player: %d", playerHP);
        String playerEndCoordinates = String.format("Final position: %d, %d", playerRow, playerCol);

        System.out.println(heiganState);
        System.out.println(playerState);
        System.out.println(playerEndCoordinates);
    }


    private static boolean isWall(int moveCell) {
        return moveCell < 0 || moveCell >= 15;
    }

    private static boolean isInDamageArea(int targetRow, int targetCol, int moveRow, int moveCol) {
        return ((targetRow - 1 <= moveRow && moveRow <= targetRow + 1)
                && (targetCol - 1 <= moveCol && moveCol <= targetCol + 1));
    }


}
