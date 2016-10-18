# Qualify Device Cloud Sample App for Android
This is a sample native Android app that contains many of the stock Android components and elements.

## Getting Started
In order to run this app on device lab, you will first need to create a local copy of this repository, [open](https://github.com/dogriffiths/HeadFirstAndroid/wiki/How-to-open-a-project-in-Android-Studio) the project, and then [build](https://developer.android.com/training/basics/firstapp/index.html) the APK from the source.

### Building the App and Test APK to Run on Device Lab
You will need the app APK

#### Step 1: Go to your project directory
Open your terminal/command prompt and change your directory to your project folder.

#### Step 2: Build the project
***Linux and OSX***

* Enter the following command inside the terminal prompt to build the project and test apks:  

	```
	./gradlew cC
	```

***Windows***

* Enter the following command inside the command prompt to build the project and test apks:  

	```
	gradlew.bat cC
	```

#### Step 3: Find the APKS

The app APK is called **app-debug.apk**.

#### Notes
* This project uses [Butterknife](http://jakewharton.github.io/butterknife/) in order to create Android views and view listeners through annotations.

* Your app's package name must match your app's applicationId that is defined in your gradle file. If the two names do not match tests will not run. 
