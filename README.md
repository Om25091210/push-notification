# push-notification
build.gradle(Project)
-----------------------------------------
   ext.kotlin_version = '1.3.72'

 classpath 'com.google.gms:google-services:4.3.4'
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
=========================================
build.gradle(Module app)
------------------------------------------
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-android-extensions'


dependencies:

   implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    implementation 'androidx.core:core-ktx:1.2.0'

    // Coroutines
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.5'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.5'

    // Retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.6.2'
    implementation 'com.squareup.retrofit2:converter-gson:2.6.0'

Manifest file:
-----------------------------------

    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="com.google.android.c2dm.permission.RECEIVE" />


      <service android:name=".FirebaseService"
            android:permission="com.google.android.c2dm.permission.SEND">
            <intent-filter>
                <action android:name="com.google.firebase.MESSAGING_EVENT" />
                <action android:name="com.google.android.c2dm.intent.RECEIVE" />
            </intent-filter>

        </service>
