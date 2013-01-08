package com.fedorvlasov.lazylist;

import java.io.IOException;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {

	private SurfaceHolder mSurfaceHolder;
	private Camera mCamera;
	
	
	SurfaceView mSurfaceView;
	SurfaceHolder mHolder;
	Size mPreviewSize;
	List<Size> mSupportedPreviewSizes;

	//Constructor that obtains context and camera
	public CameraPreview(Context context, Camera camera) {
		super(context);
		this.mCamera = camera;
		
		this.mSurfaceHolder = this.getHolder();
		this.mSurfaceHolder.addCallback(this); // we get notified when underlying surface is created and destroyed
		this.mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS); //this is a deprecated method, is not requierd after 3.0
		
	}
	
	
	
	
	@SuppressLint("NewApi")
	public void surfaceCreated(SurfaceHolder surfaceHolder) {
		
          /*  mCamera.setPreviewDisplay(surfaceHolder);
            mCamera.startPreview();*/
            mCamera = Camera.open();
            mCamera.setDisplayOrientation(90);
	}
	
	public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
		mCamera.stopPreview();
		mCamera.release();
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int w,
			int h)
	{
		// Now that the size is known, set up the camera parameters and
		// begin
		// the preview.
		if (mCamera != null)
		{
			requestLayout();
			Camera.Parameters parameters = mCamera.getParameters();
			if (parameters != null && mPreviewSize != null)
			{
				parameters.setPreviewSize(mPreviewSize.width, mPreviewSize.height);
				mCamera.setParameters(parameters);
			}
			
			try
			{
				mCamera.setPreviewDisplay(holder);
			} 
			catch (IOException e)
			{
				//Logger.error("Camera", e);
			}
			mCamera.startPreview();
		}
	}
	
}