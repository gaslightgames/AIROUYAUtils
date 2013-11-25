package com.gaslightgames.android.ouyautilsane.extensions;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class OUYAUtilsANETest implements FREFunction
{

	@Override
	public FREObject call( FREContext context, FREObject[] args )
	{
		Log.i( "OUYA_UTILS_ANE_TEST", "Test Successful." );
		
		return null;
	}

}
