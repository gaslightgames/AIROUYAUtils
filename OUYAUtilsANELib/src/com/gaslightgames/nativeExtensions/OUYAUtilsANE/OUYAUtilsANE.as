package com.gaslightgames.nativeExtensions.OUYAUtilsANE
{
	import flash.events.Event;
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;
	
	public class OUYAUtilsANE extends EventDispatcher
	{
		public static var instance:OUYAUtilsANE;
		
		private static var extContext:ExtensionContext = null;
		
		private static var _isSupported:Boolean = false;
		private static var _isSupportedSet:Boolean = false;
		
		private static var _accountName:String;
		
		public static function getInstance():OUYAUtilsANE
		{
			if( null == instance )
			{
				instance = new OUYAUtilsANE( new SingletonEnforcer() );
			}
			return instance;
		}
		
		public function OUYAUtilsANE( enforcer:SingletonEnforcer, target:IEventDispatcher=null )
		{
			trace( "Building OUYA Utils ANE" );
			if( !extContext )
			{
				trace( "Building Extension Context" );
				extContext = ExtensionContext.createExtensionContext( "com.gaslightgames.OUYAUtilsANE", "OUYAUtilsANE" );
				
				extContext.call( "initUtils" );
				
				if( extContext )
				{
					trace( "OUYA Utils ANE Initialised." );
					
					extContext.addEventListener( StatusEvent.STATUS, onStatus );
				}
				else
				{
					trace( "OUYA Utils ANE Initiasation FAILED!" );
				}
			}
			
			super(target);
		}
		
		private function onStatus( statusEvent:StatusEvent ):void
		{
			//trace( "Status Event: " + statusEvent.level );
			//trace( "Status Event: " + statusEvent.code );
			
			if( "MENU" == statusEvent.code )
			{
				this.dispatchEvent( new OUYAUtilsANEEvent( OUYAUtilsANEEvent.MENU_UPDATE ) );
			}
		}
		
		public function test():void
		{
			if( null != extContext )
			{
				extContext.call( "testUtils" );
			}
		}
		
		public function get getAccount():String
		{
			if( _accountName == null )
			{
				var accountName:String;
			
				if( null != extContext )
				{
					accountName = extContext.call( "getAccounts" ) as String;
				}
				
				if( accountName == "0" )
				{
					trace( "No Account Found." );
				}
				
				if( accountName == "accounts" )
				{
					trace( "Multiple Accounts Found." );
					// we need to handle this differently.
				}
				
				_accountName = accountName;
			}
			
			return _accountName;
		}
		
		public static function get isSupported():Boolean
		{
			if( !_isSupportedSet )
			{
				try
				{
					_isSupportedSet = true;
					
					var testContext:ExtensionContext = ExtensionContext.createExtensionContext( "com.gaslightgames.OUYAUtilsANE", "OUYAUtilsANE" );
					_isSupported = testContext.call( "isUtilsSupported" );// as Boolean;
					testContext.dispose();
				}
				catch( error:Error )
				{
					trace( error.message, error.errorID );
					
					return _isSupported;
				}
			}
			
			return _isSupported;
		}
	}
}

internal class SingletonEnforcer{}