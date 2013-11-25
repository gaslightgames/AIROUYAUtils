package com.gaslightgames.android.ouyautilsane.extensions;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class OUYAUtilsANEBroadcastReceiver extends BroadcastReceiver
{
	OUYAUtilsANEExtensionContext parent;
	
	public OUYAUtilsANEBroadcastReceiver( OUYAUtilsANEExtensionContext parent )
	{
		super();
		
		this.parent = parent;
	}
	
	@Override
	public void onReceive( Context context, Intent service )
	{
		// We only receive tv.ouya.metrics.action.UPDATE events - when the Menu is appearing/disappearing
		this.parent.dispatchStatusEventAsync( "MENU", "update" );
	}

}
