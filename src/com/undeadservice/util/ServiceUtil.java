package com.undeadservice.util;

import com.undeadservice.service.LocalService;
import com.undeadservice.service.RemoteService;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;

public class ServiceUtil {
	public static void startLocalService(Context context) {
		boolean isRunning = false; 
		ActivityManager manager = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE); 
		for (RunningServiceInfo service :manager.getRunningServices(Integer.MAX_VALUE)) 
		{ 
			if("com.undeadservice.service.LocalService".toUpperCase().equals(service.service.getClassName().toUpperCase()))        	
			{ 
				isRunning = true; 
			}    
		} 
		if (!isRunning) 
		{ 
			context.startService(new Intent(context, LocalService.class)); 
		}
	}
	
	public static void startRemoteService(Context context) {
		boolean isRunning = false; 
		ActivityManager manager = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE); 
		for (RunningServiceInfo service :manager.getRunningServices(Integer.MAX_VALUE)) 
		{ 
			if("com.undeadservice.service.RemoteService".toUpperCase().equals(service.service.getClassName().toUpperCase()))        	
			{ 
				isRunning = true; 
			}    
		} 
		if (!isRunning) 
		{ 
			context.startService(new Intent(context, RemoteService.class)); 
		}
	}
}
