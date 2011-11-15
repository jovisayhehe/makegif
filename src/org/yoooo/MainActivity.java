package org.yoooo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button make_btn;
	private Bitmap[] bitmaps;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        bitmaps = new Bitmap[4];
        
        bitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.a);
        bitmaps[1] = BitmapFactory.decodeResource(getResources(), R.drawable.b);
        bitmaps[2] = BitmapFactory.decodeResource(getResources(), R.drawable.c);
        bitmaps[3] = BitmapFactory.decodeResource(getResources(), R.drawable.d);
        
        make_btn = (Button) findViewById(R.id.make_btn);
        make_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				GifUtil gifUtil = new GifUtil();
				
				
				gifUtil.Encode("/mnt/sdcard/test.gif", bitmaps, 50);
				
			}
		});
    }
}