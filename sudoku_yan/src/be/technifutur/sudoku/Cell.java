package be.technifutur.sudoku;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Cell {
    private char value = SudokuModel.EMPTY;
    private boolean lock = false;
    private Map<String, Set<Character>> zone = new HashMap<>();

    public char getValue(){
        return value;
    }

    public boolean setValue(char val){
        boolean res = !lock && (value != val);

        if (res)
            value = val;
        return res;
    }

    public void lock(){
        lock = false;
    }

    public boolean isLock(){
        return lock;
    }

    public boolean isEmpty(){
        return (value == SudokuModel.EMPTY);
    }

    public boolean clear(){
        return (setValue(SudokuModel.EMPTY));
    }

    public void addZone(String name, Set<Character> set){
        zone.put(name, set);
    }

    public Set<Character> getZone(String name){
        return (zone.get(name));
    }

    public static void main(String[] args) {
        Cell cell = new Cell();
        Set<Character> zoneli = new HashSet<>();
        Set<Character> zoneco = new HashSet<>();


        cell.addZone("line", zoneli);
        cell.addZone("column", zoneco);
        Set<Character> zone2 = cell.getZone("ligne");
        System.out.println(zoneli == cell.getZone("line"));
        System.out.println(zoneco == cell.getZone("column"));
    }
}
