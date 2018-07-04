Android Devices
===============
There is some problem with Build.MODEL and device marketing name. So the main point is to get some bridge between these values. 

Credits (based on):
 
 * This is a fork, please check base source
 * https://github.com/meetup/android-device-names/ For parsing I used this java [file](https://gist.github.com/maxml/7452b03e1fd30be56a6eed38eaf46d83)
 * Me, I got for Build.MODEL from [Amazon](https://www.amazon.com/s/ref=nb_sb_noss_2/140-7302758-2462514?url=search-alias%3Dmobile&field-keywords=oneplus+6+&sprefix=oneplu%2Cmobile%2C235&crid=3SGL5DMQKLOB6), in titles you can see a cypher, I think it's similar to real Build.MODEL. 

Searching BUILD.Model csv
-------------------------

I've written a ruby script which can search the models CSV for one or more given phone names. The following are valid and print out the matches
For using this script you need to install ruby on your computer. For Ubuntu, please, use this [tutorial](https://www.digitalocean.com/community/tutorials/how-to-install-ruby-and-set-up-a-local-programming-environment-on-ubuntu-16-04). 
For Windows please find the way to open Ubuntu inside your Windows. It's built-in feature for Windows 10. 

    ruby search-models.rb "Galaxy S III"
    ruby search-models.rb "Galaxy S III" "Nexus S" "Galaxy S4"

Another materials 
-------------------------
Old spreadsheet versions:

 * [FROM ORIGIN: Build.Model values for different phones](https://docs.google.com/spreadsheet/ccc?key=0Argh_eVbu2eZdE5uRmtISXJuSk5MT1FvTmNMWkxlX1E)
 * [Another source for Build.Model value](https://github.com/meetup/android-device-names/blob/master/android_models.properties)

Everybody is welcome to contribute!

