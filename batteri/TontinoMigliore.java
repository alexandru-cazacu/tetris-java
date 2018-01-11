/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batteri;

import static batteri.TontinoTest0.VIEW;
import java.awt.Color;
import java.util.Random;

/**
 * Classe d'esempio per la gara
 * @author Alessandro Bugatti &lt; alessandro.bugatti@gmail.com &gt;
 */

public class TontinoMigliore extends Batterio{
    private int VIEW = 10;
    private int WIDTH = 1024;
    private int HEIGHT = 700;
    
    public TontinoMigliore(int x, int y, Color c, Food f){
        super(x,y,c,f);
    }
    
    private void spostadaiMargini()
    {
        if(x<=VIEW) x += VIEW;
        if(x>WIDTH-VIEW) x -= VIEW;
        if(y<=VIEW) y += VIEW;
        if(y>HEIGHT-VIEW) y -= VIEW;
    }
    
    @Override
    protected void Sposta(){
        spostadaiMargini();
        
        for (int i=x-VIEW; i<x+VIEW; i++)
        for (int j=y-VIEW; j<y+VIEW; j++){
            if (ControllaCibo(i, j)){
                x=i;
                y=j;
                return;
            }
        }   
        int dx = (int)(Math.random()*3) - 1;
        int dy = (int)(Math.random()*3) - 1;
        if (x+dx >= 0 && x+dx<food.getWidth())
            x += dx; 
        if (y+dy >= 0 && y+dy<food.getHeight())
            y += dy;
        return;
                    
    }
    
    @Override
    public Batterio Clona(){
       return new TontinoMigliore(x,y,colore,food); 
    }
    
    @Override
    public String toString(){
        return "TontinoMigliore";
    }
}
