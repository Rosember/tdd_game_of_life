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
public class Game {

private Board board ;
    
    public Game(Board board) {
        this.board = board;
    }

    public Board nextIteration() {
        Board nextBoard = board.nextIteration();
        board = nextBoard;
        
        return board;
    }
}
