Android Devices: Main point
===============
There is some problem with Build.MODEL and device marketing name. So the main point is to get some bridge between these values. 

Searching (for developers)
-------------------------
If you are developer, you can find java project _model-finder_ for checking device info availability. 
This project is created in InteliJ IDEA, I need jlsx library for reading excel files, so I need real Java project for simple working with all needed dependencies. 
In _model-finder_ project please find _ModelParser.java_ class. After you running it, you can see first field called *foundRequest*. Use it if you want to find some devices, add/change devices/names/manufacturer/models in this variable. 
The project compiled by Java 9, min - Java 8. Please, note this when you will import this project. 

If you aren't developer please open Build.MODEL.xls file and use "Find" feature inside Microsoft Excel/OpenOffice Calc/another viewer. 

Materials 
-------------------------
Credits (based on):
 
 * [Base source](https://github.com/mataanin/android-devices)
 * Second part of old devices I get [here](https://github.com/meetup/android-device-names/). For parsing I used _DeviceNameParser.java_ class from code. You can see this list in *model-finder\input_old_devices.txt*
 * Me, I created first worksheet called "Snapdragon" from:
  	- [Amazon](https://www.amazon.com/s/ref=nb_sb_noss_2/140-7302758-2462514?url=search-alias%3Dmobile&field-keywords=oneplus+6+&sprefix=oneplu%2Cmobile%2C235&crid=3SGL5DMQKLOB6) 
	- [Aliexpress](https://www.aliexpress.com/wholesale?catId=0&initiative_id=SB_20180705054125&isPremium=y&SearchText=android+Oppo+Find+X)
In titles you can see a cypher, I hope it's similar to real Build.MODEL. 

Old spreadsheet versions:

 * [FROM ORIGIN: Build.Model values for different phones](https://docs.google.com/spreadsheet/ccc?key=0Argh_eVbu2eZdE5uRmtISXJuSk5MT1FvTmNMWkxlX1E)
 * [Another source for Build.Model value](https://github.com/meetup/android-device-names/blob/master/android_models.properties)

Everybody is welcome to contribute!