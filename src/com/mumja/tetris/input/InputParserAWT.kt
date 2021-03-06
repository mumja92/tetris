package com.mumja.tetris.input

import java.awt.AWTEvent
import java.awt.Toolkit
import java.awt.event.AWTEventListener
import java.awt.event.KeyEvent
import java.lang.Exception

class InputParserAWT: IInputParser{
    private var asyncInput: String?

    init{
        asyncInput = null
        val listener = AWTEventListener { event ->
            try {
                val evt = event as KeyEvent
                if (evt.id == KeyEvent.KEY_PRESSED && evt.keyCode == KeyEvent.VK_LEFT) {
                    if (asyncInput == null){
                        asyncInput = "a"
                    }
                }
                if (evt.id == KeyEvent.KEY_PRESSED && evt.keyCode == KeyEvent.VK_RIGHT) {
                    if (asyncInput == null){
                        asyncInput = "d"
                    }
                }
                if (evt.id == KeyEvent.KEY_PRESSED && evt.keyCode == KeyEvent.VK_DOWN) {
                    if (asyncInput == null){
                        asyncInput = "s"
                    }
                }
                if (evt.id == KeyEvent.KEY_PRESSED && evt.keyCode == KeyEvent.VK_R) {
                    if (asyncInput == null){
                        asyncInput = "r"
                    }
                }
                if (evt.id == KeyEvent.KEY_PRESSED && evt.keyCode == KeyEvent.VK_ESCAPE) {
                    if (asyncInput == null){
                        asyncInput = "q"
                    }
                }
                if (evt.id == KeyEvent.KEY_PRESSED && evt.keyCode == KeyEvent.VK_UP) {
                    if (asyncInput == null){
                        asyncInput = "w"
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        Toolkit.getDefaultToolkit().addAWTEventListener(listener, AWTEvent.KEY_EVENT_MASK)
    }
    override fun getInput() : InputCommand {
        val userInput = getAWTInput()
        return if (userInput == null){
            InputCommand.NONE
        } else{
            parseInput(userInput)
        }
    }

    private fun getAWTInput(): String?{
        if (asyncInput != null){
            val returnValue = asyncInput
            asyncInput = null
            return returnValue
        }
        return null
    }
}