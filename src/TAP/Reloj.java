/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAP;

import java.time.LocalTime;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alemu
 */
public class Reloj extends Observable implements Runnable {
    
    private int horas, minutos, segundos;

    
    public Reloj(int horas,int minutos, int segundos){
        this.minutos=minutos;
        this.segundos=segundos;
        this.horas= horas;
    }
    @Override
    public void run() {
        
                String tiempo="";
                try{
                while(true){
                    
                   
               //horas 
                    tiempo="";
                    if(horas <10){
                        tiempo+="0" + horas;
                    } else{
                        tiempo += horas;
                        
                        
                    }
                    tiempo+=":";
              //minutos      
                     tiempo="";
                    if(minutos <10){
                        tiempo+="0" + minutos;
                    } else{
                        tiempo += minutos;
                        
                        
                    }
                     tiempo+=":";
              //segundos      
                    tiempo="";
                    if(segundos <10){
                        tiempo+="0" + segundos;
                    } else{
                        tiempo += segundos;
                        
                        
                    }
     this.setChanged();
     this.notifyObservers(tiempo);
     this.clearChanged();
     Thread.sleep(1000);
     
            segundos++;
            if(segundos==60){
                minutos ++;
                segundos = 0;
                if (minutos ==60){
                    minutos =0;
                    horas++;
                    if(horas==24){
                        horas=0;
                    }
                }
            }
                    
                    
                }
    }   catch (InterruptedException ex) {
            Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}

   
}
