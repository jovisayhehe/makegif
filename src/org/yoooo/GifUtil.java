package org.yoooo;

import android.graphics.Bitmap;
import android.util.Log;

public class GifUtil {

	private final String TAG=this.getClass().getName();
	static
	{
		System.loadLibrary("gifflen");
	}

	/**
	 * Init the gif file
	 * @param gifName name
	 * @param w width
	 * @param h height
	 * @param numColors colors
	 * @param quality
	 * @param frameDelay times
	 * @return
	 */
	public native int Init(String gifName, int w, int h, int numColors, int quality,
            int frameDelay);

	/*
	 * close
	 *
	 */
	public native void Close();

	public native int AddFrame(int[] pixels);

	/**
	 * encode the bitmaps to gif
	 * @param fileName
	 * @param bitmaps
	 * @param delay
	 */
	public void Encode(String fileName,Bitmap[] bitmaps,int delay)
	{
		if(bitmaps==null||bitmaps.length==0)
		{
			throw new NullPointerException("Bitmaps should have content!!!");

		}
		int width=bitmaps[0].getWidth();
		int height=bitmaps[0].getHeight();
		int re = Init(fileName,width,height,256,100,delay);
		if(re!=0)
		{
			Log.e(TAG, "GifUtil init failed"+String.valueOf(re));
			return;
		}

		for(Bitmap bp:bitmaps)
		{

			int pixels[]=new int[width*height];	

			bp.getPixels(pixels, 0, width, 0, 0, width, height);
			AddFrame(pixels);
		}

		Close();

	}

}