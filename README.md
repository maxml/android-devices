Android Devices
===============

Android UI statistics for designers, product managers and developers.

Google Dashboards doesn't provide information on the following:

1. What are the popular/existing dp resolutions?
2. What devices could be best used for UI testing for specific generalized size/density bucket combination?
3. What devices could support width configuration introduced with Android 3.2

Besides, this information provides a sneak peak into Android devices market and trends. 

Everybody is welcome to contribute!

Spreadsheet-friendly versions:

 * [Phones](https://docs.google.com/spreadsheet/ccc?key=0Argh_eVbu2eZdDNCTVB6VmpxWEVKR1VqNE9zQzRHUGc)
 * [Tablets](https://docs.google.com/spreadsheet/ccc?key=0Argh_eVbu2eZdDBXdmpld1dvckl6RUlHamJjMzVaQXc#gid=2)
 * [Build.Model values for different phones](https://docs.google.com/spreadsheet/ccc?key=0Argh_eVbu2eZdE5uRmtISXJuSk5MT1FvTmNMWkxlX1E)

Credits (based on):
 
 * [Blundell's list of devices](http://blog.blundell-apps.com/list-of-android-devices-with-pixel-density-buckets/)
 * [Wikipedia List of Android devices](http://en.wikipedia.org/wiki/List_of_displays_by_pixel_density)
 * https://www.amazon.com/s/ref=nb_sb_noss_2/140-7302758-2462514?url=search-alias%3Dmobile&field-keywords=oneplus+6+&sprefix=oneplu%2Cmobile%2C235&crid=3SGL5DMQKLOB6
 * https://github.com/meetup/android-device-names/blob/master/android_models.properties

Searching BUILD.Model csv
-------------------------

I've written a ruby script which can search the models CSV for one or more given phone names. The following are valid and print out the matches

    ruby search-models.rb "Galaxy S III"
    ruby search-models.rb "Galaxy S III" "Nexus S" "Galaxy S4"
