package
{
	import com.gaslightgames.nativeExtensions.OUYAUtilsANE.OUYAUtilsANE;
	import com.gaslightgames.nativeExtensions.OUYAUtilsANE.OUYAUtilsANEEvent;
	
	import flash.display.Sprite;
	import flash.display.StageAlign;
	import flash.display.StageScaleMode;
	
	public class OUYAUtilsANETest extends Sprite
	{
		private var ouyaUtils:OUYAUtilsANE;
		
		public function OUYAUtilsANETest()
		{
			super();
			
			// support autoOrients
			stage.align = StageAlign.TOP_LEFT;
			stage.scaleMode = StageScaleMode.NO_SCALE;
			
			this.init();
		}
		
		private function init():void
		{
			if( OUYAUtilsANE.isSupported )
			{
				trace( "ANE isSupported." );
				this.ouyaUtils = OUYAUtilsANE.getInstance();
				this.ouyaUtils.addEventListener( OUYAUtilsANEEvent.MENU_UPDATE, OUYAMenuUpdate );
				this.ouyaUtils.test();
				var account:String = this.ouyaUtils.getAccount;
				trace( "Account: " + account );
			}
			else
			{
				trace( "ANE is NOT supported." );
			}
		}
		
		private function OUYAMenuUpdate( utilsEvent:OUYAUtilsANEEvent ):void
		{
			trace( "OUYA Menu Event!" );
		}
	}
}