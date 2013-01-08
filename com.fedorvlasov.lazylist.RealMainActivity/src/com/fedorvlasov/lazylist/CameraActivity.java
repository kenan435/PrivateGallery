package com.fedorvlasov.lazylist;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.widget.FrameLayout;

public class CameraActivity extends Activity {
	
	
	private Camera mCamera;
	private CameraPreview mCameraPreview;
    
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        
        mCamera = getCameraInstance();
        mCameraPreview = new CameraPreview(this, mCamera);
        
        FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
        preview.addView(mCameraPreview);
        
    }

    /**
     * Helper method to access the camera returns null if
     * it cannot get the camera or does not exist
     * @return
     */
	private Camera getCameraInstance() {
		Camera camera = null;

		try {
			camera = Camera.open();
		} catch (Exception e) {
			// cannot get camera or does not exist
		}
		return camera;
	}
	
}
