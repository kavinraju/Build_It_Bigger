# This project was created as a part of Android Developer Nanodegree - Gradle for Android and Java Final Project

This project consists of an app with multiple flavors that uses
multiple libraries and Google Cloud Endpoints. The final app will consist
of four modules. A Java library that provides jokes, a Google Cloud Endpoints
(GCE) project that serves those jokes, an Android Library containing an
activity for displaying jokes, and an Android app that fetches jokes from the
GCE module and passes them to the Android Library for display.

# Features implemented in this app

* Has a Java library which supplies Jokes.
* Has Android library which has an Activity to display the Jokes passed to it as intent extras..
* Added free & paid flavors.
* Configured a multi project build to compile the libraries and app.
* Used the Gradle App Engine plugin to deploy a backend (locally).
* Configured an integration test suite that runs against the local App Engine development server.
* Displays Interstitial Ad after the user hits the button. (Only in Free Version).
* Configured Gradle Task to,<br>
       <b>1.</b> Launch the GCE local development server.<br>
       <b>2.</b> Run all tests.<br>
       <b>3.</b> Shut the server down again.<br>

## Start or stop your local server by using the gradle tasks as shown in the following screenshot.

<img src="https://user-images.githubusercontent.com/24537737/46172002-e4533300-c2bf-11e8-9585-2c2be61532fd.png" height="500">

## Screenshots
<img src="https://user-images.githubusercontent.com/24537737/46246811-f4365880-c420-11e8-8c6a-502ad40deeb9.png" height="500">
<img src="https://user-images.githubusercontent.com/24537737/46246812-f4ceef00-c420-11e8-96ea-b1a899782963.png" height="500">
<img src="https://user-images.githubusercontent.com/24537737/46246813-f4ceef00-c420-11e8-896e-d26935b41f42.png" height="500">
<img src="https://user-images.githubusercontent.com/24537737/46246814-f4ceef00-c420-11e8-93be-2811d140bbad.png" height="500">
<img src="https://user-images.githubusercontent.com/24537737/46246815-f5678580-c420-11e8-8996-f673d00a01b8.png" height="500">
