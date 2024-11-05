package corejava;

public class MinimumElement {
    public static void main(String[] args) {
        System.out.println(finalCoordinates(0, 0, "UUU"));
        System.out.println(finalCoordinates(0, 0, "URRDDL"));
        System.out.println(finalCoordinates(0, 0, "DOWN UP 2xRIGHT DOWN 3xLEFT"));
    }

    public static String finalCoordinates(int x, int y, String directions) {
        String[] commands = directions.split(" ");
        for (String command : commands) {
            if (command.equals("U")) {
                y++;
            } else if (command.equals("D")) {
                y--;
            } else if (command.equals("L")) {
                x--;
            } else if (command.equals("R")) {
                x++;
            } else if (command.contains("x")) {
                String[] parts = command.split("x");
                int multiplier = Integer.parseInt(parts[0]);
                String direction = parts[1];
                for (int i = 0; i < multiplier; i++) {
                    if (direction.equals("UP")) {
                        y++;
                    } else if (direction.equals("DOWN")) {
                        y--;
                    } else if (direction.equals("LEFT")) {
                        x--;
                    } else if (direction.equals("RIGHT")) {
                        x++;
                    }
                }
            }
        }
        return "(" + x + "," + y + ")";
    }
}
