package com.mumja.tetris.board.drawers

import com.mumja.tetris.GameStatus
import com.mumja.tetris.board.BlockType
import com.mumja.tetris.board.Board

class TetrisDrawerCli : ITetrisDrawer {
    override fun draw(gameStatus: GameStatus){
        clearScreen()
        drawBoard(gameStatus.board)
    }

    override fun gameOver(gameStatus: GameStatus){
        println("Game over")
    }

    private fun clearScreen(){
        for (i in 1..20){
            println()
        }
    }

    private fun drawBoard(board: Board){
        drawFirstLineOfBoard(board.sizeY)
        for (x  in 0 until board.sizeX){
            var line = String()
            for (y in 0 until board.sizeY){
                line += if (board.getLocation(x,y)?.blockType == BlockType.EMPTY){
                    ("o")
                } else{
                    ("*")
                }
            }
            drawMiddleLineOfBoard(line)
        }
        drawLastLineOfBoard(board.sizeY)
    }
    private fun drawFirstLineOfBoard(size: Int){
        for (i in 0 until size + 2){
            print("-")
        }
        println(" ")
    }

    private fun drawLastLineOfBoard(size: Int){
        drawFirstLineOfBoard(size)
    }

    private fun drawMiddleLineOfBoard(line: String){
        println("|$line|")
    }
}