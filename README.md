AIROUYAUtils
============

Utilities Native Extension for the OUYA Console when developing with Adobe AIR.

Four Folders:
1: OUYAUtilsANEJava - contains the native side of the code.
2: OUYAUtilsANELib - contains the library interface between the Java and AS3 sides.
3: OUYAUtilsANEDefaultLib - contains a library implementation so the same project can be run (and tested) on multiple platforms.  (the project will NOT return any values on anything but an OUYA)
4: OUYAUtilsANETest - a very simple project to test the ANE functionality.

Things to Note:
============

1) With the update to ODK 1.0.10, it appears that the MENU_APPEARING Broadcast event no longer exists.  Instead, the Java side listens for an UPDATE event.
2) Again, with update 1.0.10, there is a neater way of accessing the Gamer Info.  But as this is tied to the OUYA Facade, it would mean you could NOT use this ANE in conjunction with the IAP ANE.  Instead, this uses a simpler approach to get the Gamer tag.
3) With the limitation mentioned in #2, both the IAP and this ANE will be merged at a later date.

License
============

The code, packages and anything in this project are provided "as is". You are free to do what you like, modify, update etc - if you like, send a pull/push request if you have any fixes or suggestions. And if in doubt, follow Whetons Law: http://knowyourmeme.com/memes/wheatons-law