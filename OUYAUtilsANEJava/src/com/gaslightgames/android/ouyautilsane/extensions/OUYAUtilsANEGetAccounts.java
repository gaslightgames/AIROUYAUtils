package com.gaslightgames.android.ouyautilsane.extensions;

import tv.ouya.console.api.OuyaAuthenticationHelper;
import android.accounts.Account;
import android.accounts.AccountManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREWrongThreadException;

public class OUYAUtilsANEGetAccounts implements FREFunction
{

	@Override
	public FREObject call( FREContext context, FREObject[] args )
	{
		FREObject result = null;
		
		// Get the Android System Account Manager
		AccountManager am = AccountManager.get( context.getActivity() );
		// Get accounts that match the OUYA Account Type
		Account[] accounts = am.getAccountsByType( OuyaAuthenticationHelper.OUYA_ACCOUNT_TYPE );
		
		// If multiple accounts are logged in...
		if( accounts.length > 1 )
		{
			try
			{
				result = FREObject.newObject( "accounts" );
			}
			catch ( FREWrongThreadException e )
			{
				e.printStackTrace();
			}
			
			int i = 0;
			while( i < accounts.length )
			{
				((OUYAUtilsANEExtensionContext)context).dispatchStatusEventAsync( "ACCOUNT", accounts[i].name );
				
				i++;
			}
		}
		// Or if there is only one account
		else if( accounts.length == 1 )
		{
			try
			{
				result = FREObject.newObject( accounts[0].name );
			}
			catch ( FREWrongThreadException e )
			{
				e.printStackTrace();
			}
		}
		// And if there are none
		else
		{
			try
			{
				result = FREObject.newObject( "0" );
			}
			catch ( FREWrongThreadException e )
			{
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
