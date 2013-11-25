package com.gaslightgames.android.ouyautilsane.extensions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class OUYAUtilsANEExtension implements FREExtension
{
	public static FREContext extensionContext;
	
	public FREContext createContext( String contextType )
	{
		// Return a new OUYAControllerANEExtensionContext
		return new OUYAUtilsANEExtensionContext();
	}

	public void dispose()
	{
		
	}

	public void initialize()
	{
		
	}

}
