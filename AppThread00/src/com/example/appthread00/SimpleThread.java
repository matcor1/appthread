/**
 * @author paolo
 * 
 * @version  00.2 - Risoluzione del problema con Handler
 * 
 *                  
 */

package com.example.appthread00;

import android.os.Handler;
import android.os.Message;


public class SimpleThread extends Thread {
	
	Handler h ;
	
	
    public SimpleThread(String threadName, Handler h ) {
		super(threadName);
		this.h = h;
	}


    public void run() 
    {	
    	for (int i = 0; i < 10; i++) 
    	{
			// System.out.println(this.getName()+" "+ i ); 
    		
    		Message messaggio = Message.obtain();
    		messaggio.obj = new String(this.getName()+" "+ i);
    		h.sendMessage(messaggio);
    		
           
    		try 
		    {
		    	sleep((int)(Math.random() * 1000));
		    } 
		    catch (InterruptedException e) {}
    	}
    	// System.out.println( getName()+ " ha FINITO");
    	
    	Message messaggio = Message.obtain();
		messaggio.obj = new String(this.getName()+" ha FINITO");
		h.sendMessage(messaggio);
		
    	
    }
    
}
