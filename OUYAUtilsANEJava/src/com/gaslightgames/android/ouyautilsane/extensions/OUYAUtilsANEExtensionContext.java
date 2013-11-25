package com.gaslightgames.android.ouyautilsane.extensions;

import java.util.HashMap;
import java.util.Map;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

public class OUYAUtilsANEExtensionContext extends FREContext
{
	public OUYAUtilsANEBroadcastReceiver broadcast;
	
	@Override
	public void dispose()
	{
		if( null != broadcast )
		{
			this.getActivity().unregisterReceiver( broadcast );
		}
	}

	@Override
	public Map<String, FREFunction> getFunctions()
	{
		Map<String, FREFunction> functionMap = new HashMap<String, FREFunction>();
		
		functionMap.put( "initUtils", new OUYAUtilsANEInit() );
		functionMap.put( "testUtils", new OUYAUtilsANETest() );
		functionMap.put( "isUtilsSupported", new OUYAUtilsANESupported() );
		functionMap.put( "getAccounts", new OUYAUtilsANEGetAccounts() );

		return functionMap;
	}

}
