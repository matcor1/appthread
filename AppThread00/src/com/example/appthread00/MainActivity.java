/**
 * @author paolo
 * 
 * @version  00.2 - Risoluzione del problema con Handler
 * 
 */

package com.example.appthread00;

import com.example.appthread00.R;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

@SuppressLint("HandlerLeak")
public class MainActivity extends Activity  {


	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Handler mioHandler = new Handler(){
			  @Override
			  public void handleMessage(Message msg) {
				  
				  TextView t = (TextView) findViewById(R.id.testo1);
				  
				  CharSequence old = t.getText();
				  t.setText( old + "\n"+ (String) msg.obj);
			     }
			 };
		
		Button start= (Button) this.findViewById(R.id.start);
			
		Button stop=(Button) this.findViewById(R.id.stop);
		Button start2=(Button) this.findViewById(R.id.button1);
		Button stop2=(Button) this.findViewById(R.id.button2);
		
		final boolean p1=false;
		final boolean p2=false;
			 
		final SimpleThread t1=new SimpleThread("primoTask", mioHandler );
		final SimpleThread t2=new SimpleThread("secondoTask", mioHandler );
		
		start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {//azioni da eseguire al tocco
            
            	if(p1)
            		t1.resume();
            	else
            	{
            		t1.start();
            		p1=true;
            	}
            
            }
        });
		
		stop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {//azioni da eseguire al tocco
            
            	t1.stop();
            
            }
        });
	
	stop2.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View arg0) {//azioni da eseguire al tocco
        
        	t2.stop();
        
        }
    });

start2.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View arg0) {//azioni da eseguire al tocco
    
    	if(p2)
    		t2.resume();
    	else
    	{
    		t2.start();
    		p2=true;
    	}
    
    
    }
});
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
}
