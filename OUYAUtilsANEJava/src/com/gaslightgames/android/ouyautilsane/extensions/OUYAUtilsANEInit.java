package com.gaslightgames.android.ouyautilsane.extensions;

import android.content.IntentFilter;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class OUYAUtilsANEInit implements FREFunction
{

	public FREObject call( FREContext context, FREObject[] passedArgs )
	{
		// Initialisation stuff...
		
		// Setup the Broadcast Receiver for the UPDATE event. -MENU_APPEARING-
		Log.i( "OUYA_UTILS_ANE_INIT", "Building and Registering Broadcast Receiver." );
		((OUYAUtilsANEExtensionContext)context).broadcast = new OUYAUtilsANEBroadcastReceiver( (OUYAUtilsANEExtensionContext)context );
		String intentString = "tv.ouya.metrics.action.UPDATE";// "tv.ouya.intent.action.MENU_APPEARING";
		context.getActivity().registerReceiver( ((OUYAUtilsANEExtensionContext)context).broadcast, new IntentFilter(intentString) );
		
		return null;
	}

}
