# PdfWebView

1. Add it in your root build.gradle at the end of repositories:
```kotlin
allprojects {
  repositories {
  ...
  maven { url 'https://jitpack.io' }
  }
}
```
2. Add the dependency
```kotlin
dependencies {
  implementation 'com.github.slaviboy:PdfWebView:0.0.1'
}
```

----

Errors:
If you get the error: **Message: Failed to fetch**:

1) Dont forget to allow intranet in your app manifedt file
```xml
<uses-permission android:name="android.permission.INTERNET" />
```
2) Check if phone is connected to intenet
