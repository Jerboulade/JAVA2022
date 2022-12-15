package be.technifutur.sudoku;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static be.technifutur.sudoku.SudokuModel.EMPTY;
import static be.technifutur.sudoku.sudoSamourail.SudokuModelSamourail.isPositionValid1;


public class Cell {
    private char value = EMPTY;
    private boolean lock = false;
    private Map<String, Set<Character>> zone = new HashMap<>();

    public char getValue(){
        return value;
    }

    public boolean setValue(char val) throws SudokuException{
        boolean res = !lock && (value != val);

        if (lock)
            throw (new SudokuLockException("Cell is locked"));
        // System.out.printf("\nIn CELL::setValue(%c)\n---------------------\n", val);
        for (Map.Entry<String, Set<Character>> entry : zone.entrySet())
        {
            // System.out.print(entry.getKey()); //
            // System.out.println(" : " + entry.getValue()); //
            if (val != EMPTY && entry.getValue().contains(val))
            {
                System.out.println("--------DOUBLON-----------");
                res = false;
            }
        }
        if (res)
        {
            System.out.println(zone);
            for (Map.Entry<String, Set<Character>> entry : zone.entrySet())
            {
                if (val != EMPTY){
                    entry.getValue().add(val);
                    System.out.println("add '" + val + "' in " + entry.getKey());
                }
                if (value != EMPTY){
                    entry.getValue().remove(value);
                    System.out.println("remove '" + value + "' in " + entry.getKey());
                }
                System.out.print("new zone : " + entry.getKey()); //
                System.out.println(" : " + entry.getValue()); //
            }
            value = val;
        }
        return res;
    }

    public void lock(){
        lock = this.value != EMPTY;
    }

    public boolean isLock(){
        return lock;
    }

    public boolean isEmpty(){
        return (value == EMPTY);
    }

    public boolean clear() throws SudokuException{
        return (setValue(EMPTY));
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
        Set<Character> zone2 = cell.getZone("line");
        System.out.println(zoneli == cell.getZone("line"));
        System.out.println(zoneco == cell.getZone("column"));
    }
}
