package Exercises;

import java.util.Scanner;

public class E08_TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int playerRow = 7;
        int playerCol = 7;

        int playerHP = 18500;
        double heiganHP = 3_000_000;
        double playerDamage = Double.parseDouble(scanner.nextLine());
        String lastSpell = "";

        while (true) {
            if (playerHP >= 0) {
                heiganHP -= playerDamage;
            }
            if (lastSpell.equals("Plague Cloud")) {
                playerHP -= 3500;
            }
            if (heiganHP <= 0 || playerHP <= 0) {
                break;
            }
            String[] tokens = scanner.nextLine().split("\\s+");
            String currentSpell = tokens[0];
            int castRow = Integer.parseInt(tokens[1]);
            int castCol = Integer.parseInt(tokens[2]);
            if (isInDamageArea(castRow, castCol, playerRow, playerCol)) {
                if (!isInDamageArea(castRow, castCol, playerRow - 1, playerCol) && isWall(playerRow - 1)) {
                    playerRow--;
                    lastSpell = "";
                } else if (!isInDamageArea(castRow, castCol, playerRow, playerCol + 1) && isWall(playerCol + 1)) {
                    playerCol++;
                    lastSpell = "";
                } else if (!isInDamageArea(castRow, castCol, playerRow + 1, playerCol) && isWall(playerRow + 1)) {
                    playerRow++;
                    lastSpell = "";
                } else if (!isInDamageArea(castRow, castCol, playerRow, playerCol - 1) && isWall(playerCol - 1)) {
                    playerCol--;
                    lastSpell = "";
                } else {
                    if (currentSpell.equals("Cloud")) {
                        playerHP -= 3500;
                        lastSpell = "Plague Cloud";
                    } else if (currentSpell.equals("Eruption")) {
                        playerHP -= 6000;
                        lastSpell = "Eruption";
                    }
                }
            }
        }
        System.out.println(heiganHP <= 0 ? "Heigan: Defeated!" : String.format("Heigan: %.2f", heiganHP));
        System.out.println(playerHP <= 0 ?
                String.format("Player: Killed by %s", lastSpell) :
                String.format("Player: %d", playerHP));
        System.out.printf("Final position: %d, %d", playerRow, playerCol);
    }

    private static boolean isWall(int playerMovedPos) {
        return playerMovedPos >= 0 && playerMovedPos < 15;
    }

    private static boolean isInDamageArea(int castRow, int castCol, int playerRow, int playerCol) {
        return ((castRow - 1 <= playerRow && playerRow <= castRow + 1)
                && (castCol - 1 <= playerCol && playerCol <= castCol + 1));
    }
}
