/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

/**
 *
 * @author rcarrasco
 */
public class GameOfLife {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //given
        Board board = new Board();
        board.addCell(new Cell(0, 0));
        Game game = new Game(board);
        
        //when
        Board nextBoard = game.nextIteration();
        //then
        
        if (nextBoard.isAlive(new Cell(0, 0))) {
            System.out.println("ok");
        }else{
            System.out.println("no");
        }
    }
    
}
