package com.gaslightgames.nativeExtensions.OUYAUtilsANE
{
	import flash.events.Event;
	
	public class OUYAUtilsANEEvent extends Event
	{
		public static const MENU_UPDATE:String 				= "menuupdate";
		
		public function OUYAUtilsANEEvent( type:String, bubbles:Boolean = false, cancelable:Boolean = false )
		{
			super( type, bubbles, cancelable );
		}
	}
}