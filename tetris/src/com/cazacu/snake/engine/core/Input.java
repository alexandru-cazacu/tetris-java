package com.cazacu.snake.engine.core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Input implements KeyListener, MouseListener, MouseMotionListener {

    private Game gc;
    
    private static boolean[] keys = new boolean[256];
    private static boolean[] keysLast = new boolean[256];
    private static boolean[] buttons = new boolean[5];
    private static boolean[] buttonsLast = new boolean[5];
    
    
    //--------------------------------------------------------------------------
    public Input(Game gc) {
        this.gc = gc;
        gc.getRenderer().getCanvas().addKeyListener(this);
        gc.getRenderer().getCanvas().addMouseListener(this);
        gc.getRenderer().getCanvas().addMouseMotionListener(this);
    }
    
    
    //--------------------------------------------------------------------------
    public void update() {
        keysLast = keys.clone();
        buttonsLast = buttons.clone();
    }
    
    //--------------------------------------------------------------------------
    public static boolean isKey(int keyCode) {
        return keys[keyCode];
    }
    
    //--------------------------------------------------------------------------
    public static boolean isKeyPressed(int keyCode) {
        return keys[keyCode] && !keysLast[keyCode];
    }
     
    //--------------------------------------------------------------------------
    public static boolean isKeyReleased(int keyCode) {
        return !keys[keyCode] && keysLast[keyCode];
    }
    
    //--------------------------------------------------------------------------
    public static boolean isButton(int button) {
        return buttons[button];
    }
    
    //--------------------------------------------------------------------------
    public static boolean isButtonPressed(int button) {
        return buttons[button] && !buttonsLast[button];
    }
    
    //--------------------------------------------------------------------------
    public static boolean isButtonReleased(int button) {
        return !buttons[button] && buttonsLast[button];
    }
    

    
    @Override
    public void mouseDragged(MouseEvent me) {
        
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
        buttons[me.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        buttons[me.getButton()] = false;
    }
    
    @Override
    public void keyPressed(KeyEvent ke) {
        keys[ke.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        keys[ke.getKeyCode()] = false;
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }



    
}
