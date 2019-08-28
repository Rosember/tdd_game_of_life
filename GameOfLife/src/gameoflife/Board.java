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

    public Board() {
    }

    private Set<Cell> cells = new HashSet<>();

    public void addCell(Cell cell) {
        cells.add(cell);
    }

    public Set<Cell> getNeighbors(Cell cell) {
        //if (isAlive(c) && !c.equals(cell)) {
        Set<Cell> neighborhood = getNeighborhood(cell);
        Set<Cell> neighbors = new HashSet<>();

        for (Cell c : neighborhood) {
            if (isAlive(c)) {
                neighbors.add(c);
            }
        }
        neighbors.remove(cell);
        return neighbors;
    }

    /**
     * *
     * Vecindario
     *
     * @param cell
     * @return
     */
    private Set<Cell> getNeighborhood(Cell cell) {
        Set<Cell> neighborhood = new HashSet<>();

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                Cell c = new Cell(cell.row + dx, cell.column + dy);
                neighborhood.add(c);
            }
        }

        return neighborhood;
    }

    public boolean isAlive(Cell c) {
        return cells.contains(c);
    }

    public Board nextIteration() {
        Board board = new Board();
        Set<Cell> potentialCellsToBeReborn = new HashSet<>();
        for (Cell c : cells) {
            if (shouldBeAliveInNextIteration(c)) {
                board.addCell(c);
            }
            potentialCellsToBeReborn.addAll(getNeighborhood(c));
        }
        
        for (Cell c : potentialCellsToBeReborn) {
            if (shouldBeReborn(c)) {
                board.addCell(c);
            }
        }
        return board;
    }

    private boolean shouldBeAliveInNextIteration(Cell c) {
        return (getNeighbors(c).size() == 2 || getNeighbors(c).size() == 3);
    }

    private boolean shouldBeReborn(Cell c) {
        return !isAlive(c)&& getNeighbors(c).size()==3;
    }
}
