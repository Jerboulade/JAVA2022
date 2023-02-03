package be.technifutur.BattleShip;

import java.util.*;
import java.util.regex.Pattern;

public class Grid {

    private Map<String, ShipType> grid = new HashMap<>();
    private List<Ship> shipList = new ArrayList<>();
    private List<String> posList = new ArrayList<>();

    private static final Pattern posPattern = Pattern.compile("[A-J](10|[1-9])");
    public int width() {
        return 10;
    }

    public int height() {
        return 10;
    }

    public boolean isEmpty(String pos) {
        if (isValid(pos) && grid.containsKey(pos))
            return false;
        return true;
    }

    public boolean isValid(String pos) {
        return posPattern.matcher(pos).matches();
    }

    public boolean add(ShipType shipType, String pos, Direction direction) {

        for (int i = 0; i < shipType.size(); i++){
            if (!isValid(pos))
                return false;
            if (!isEmpty(pos))
                return false;
            grid.put(pos, shipType);
            pos = createPosition(pos, direction);
        }
        return true;
    }

    private static String createPosition(String position, Direction direction){
        char col = position.charAt(0);
        int  line = Integer.parseInt(position.substring(1));
        return (direction == Direction.HORIZONTAL) ? ("" + (char)(col + 1) + line) : ("" + col + (line + 1));
    }
    public Optional<ShipType> get(String pos) {
        //System.out.println(pos);
        return Optional.ofNullable(grid.get(pos));
    }
}
