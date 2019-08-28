/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author rcarrasco
 */
public class Board {
    
    private Set<Cell> cells = new HashSet<>(); 
    
    public void addCell (Cell cell){
        cells.add(cell);
    }

    public List<Cell> getNeighbors(Cell cell) {
        List<Cell>neighbors = new ArrayList<>();
        
        for (int dy = -1; dy <= 1; dy++) {
            Cell c = new Cell (cell.row,cell.column+dy);
            if (isAlive(c) && !c.equals(cell)) {
                neighbors.add(c);
            }
        }
        /*
        for (Cell c : cells) {
            if (!c.equals(cell)) {
                neighbors.add(c);
            }
        }
*/
        return neighbors;
    }
    
    private boolean isAlive (Cell c){
        return cells.contains(c);
    }
}
