package com.fedorvlasov.lazylist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class ViewGalleryActivity extends Activity {
    
    ListView list;
    LazyAdapter adapter;
    Files f = new Files();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    	
        setContentView(R.layout.main);        
        
        list=(ListView)findViewById(R.id.list);
        adapter=new LazyAdapter(this, f.getListOfFiles("/storage/sdcard0/Pictures/Screenshots/"));
        list.setAdapter(adapter);
//      
        Button b=(Button)findViewById(R.id.buttonReload);
        b.setOnClickListener(listener);
    }
    
    @Override
    public void onDestroy()
    {
        adapter.imageLoader.stopThread();
        list.setAdapter(null);
        super.onDestroy();
    }
    
    public OnClickListener listener=new OnClickListener(){
        public void onClick(View arg0) {
            adapter.imageLoader.clearCache();
            adapter.notifyDataSetChanged();
        }
    };
    
 /*   private String[] mStrings={
            "/sdcard/MyPhotos/1.jpg", "/sdcard/MyPhotos/2.jpg", "/sdcard/MyPhotos/3.jpg", "/sdcard/MyPhotos/4.jpg", "/sdcard/MyPhotos/5.jpg", 
            "/sdcard/MyPhotos/6.jpg", "/sdcard/MyPhotos/7.jpg","/sdcard/MyPhotos/8.jpg"
    };*/
}