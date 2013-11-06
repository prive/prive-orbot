package ru.dtlbox.custom;

import org.torproject.android.service.TorService;
import org.torproject.android.service.TorServiceConstants;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class CustomTorService extends TorService {
    
    private final static String LOG_TAG = "CustomTorService";
    private boolean isStarted = false;
    
    private final IBinder binder = new LocalBinder();
    
    @Override
    public void onCreate(){
        super.onCreate();
        Log.i(LOG_TAG, LOG_TAG + " create");
    }
    
    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    public final class LocalBinder extends Binder {
    	CustomTorService getService() {
            // Return this instance of LocalService so clients can call public methods
            return CustomTorService.this;
        }
    }
    
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.i(LOG_TAG, LOG_TAG + " start");
        setTorProfile(TorServiceConstants.PROFILE_ON);
        isStarted = true;
    }
    
    @Override
    public IBinder onBind(Intent intent){
    	Log.i("fdnad", "try to bind bitch");
    	return binder;
    }
    
    //check whether the service is running
    public boolean isStarted(){
        return isStarted;
    }
    
    @Override
    public void logMessage(String msg)
    {
        Log.i(LOG_TAG,msg);
        super.logMessage(msg);
    }
    
    @Override
    public void logException(String msg, Exception e)
    {
        Log.e(LOG_TAG,msg,e);
        super.logException(msg, e);
    }
    
}
