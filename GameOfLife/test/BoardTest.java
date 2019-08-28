/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import gameoflife.Board;
import gameoflife.Cell;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rcarrasco
 */
public class BoardTest {
    
    public BoardTest() {
    }
    
    /*
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
*/

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test 
    public void aSingleCellShouldHaveZeroNeighbors() {
        Board board = new Board ();
        board.addCell(new Cell(0,0));
        
        List<Cell> neighbors = board.getNeighbors(new Cell (0,0));
        
        assertEquals(0, neighbors.size());
    }
    
    @Test
    public void twoCellsNextToEachOtherShouldBeNeighbors(){
        Board board = new Board ();
        Cell first = new Cell(0,0);
        Cell second = new Cell(0,1);

        board.addCell(first);
        board.addCell(second);

        
        List<Cell> neighborsOfFirsCell = board.getNeighbors(first);
        List<Cell> neighborsOfSecondCell = board.getNeighbors(second);
        
        assertArrayEquals(new Cell[]{second}, neighborsOfFirsCell.toArray());
        assertArrayEquals(new Cell[]{first}, neighborsOfSecondCell.toArray());


    }
    
    
}
 
