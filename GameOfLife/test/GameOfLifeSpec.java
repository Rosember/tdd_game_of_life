/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static com.sun.org.apache.regexp.internal.RETest.test;
import gameoflife.Board;
import gameoflife.Cell;
import gameoflife.Game;
import static jdk.nashorn.internal.objects.NativeRegExp.test;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rcarrasco
 */
public class GameOfLifeSpec {

    public GameOfLifeSpec() {
    }

    @Test
    public void aSingleCellShouldDieInNextIteration() {

        //given
        Board board = new Board();
        board.addCell(new Cell(0, 0));
        Game game = new Game(board);

        //when
        Board nextBoard = game.nextIteration();
        //then

        assertFalse(nextBoard.isAlive(new Cell(0, 0)));
    }

    @Test
    public void cellWithTwoNeighborsShouldLiveInNextIteration() {

        //given
        Board board = new Board();
        board.addCell(new Cell(0, 0));
        board.addCell(new Cell(1, 1));
        board.addCell(new Cell(1, 0));
        board.addCell(new Cell(0, 1));

        Game game = new Game(board);

        //when
        Board nextBoard = game.nextIteration();
        //then

        assertTrue(nextBoard.isAlive(new Cell(1, 1)));
    }
    
    @Test
    public void cellWithThreeNeighborsShouldLiveInNextIteration() {

        //given
        Board board = new Board();
        board.addCell(new Cell(0, 1));
        board.addCell(new Cell(1, 1));
        board.addCell(new Cell(1, 0));
        board.addCell(new Cell(0, 0));

        Game game = new Game(board);

        //when
        Board nextBoard = game.nextIteration();
        //then

        assertTrue(nextBoard.isAlive(new Cell(1, 1)));
    }
    
    
    @Test
    public void cellWithMoreThreeNeighborsShouldDieInNextIteration() {

        //given
        Board board =  BoardTest.createBlockBoard(3, 3);
        Game game = new Game(board);

        //when
        Board nextBoard = game.nextIteration();
        //then

        assertFalse(nextBoard.isAlive(new Cell(1, 1)));
    }
    
    @Test
    public void aDeadCellWithThreeNeighborsShouldBeRebornInNextIteration() {

        //given
        Board board = new Board();
        board.addCell(new Cell(0, 1));
        board.addCell(new Cell(1, 1));
        board.addCell(new Cell(1, 0));
        
        Game game = new Game(board);

        //when
        Board nextBoard = game.nextIteration();
        //then

        assertTrue(nextBoard.isAlive(new Cell(0, 0)));
    }
    
}
