package com.mumja.tetris.board.drawers

import com.mumja.tetris.board.Board
import com.mumja.tetris.board.drawers.swing.TetrisBoardComponent
import javax.swing.JFrame
import java.awt.Dimension
import javax.swing.JOptionPane


class BoardDrawerSwing: IBoardDrawer {
    private val frame = JFrame("Mumjotetris")
    private val block = TetrisBoardComponent()

    init{
        frame.minimumSize = Dimension(800, 400)
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.isVisible = true;
        frame.add(block)
    }

    override fun draw(board: Board) {
        block.setBoard(board)
        frame.repaint()
    }

    override fun gameOver() {
        JOptionPane.showMessageDialog(null, "GG medium", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        frame.dispose()
    }

}