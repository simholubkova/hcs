# Pattern Lock View 
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-PatternLockView-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/6988) 

## Changes made by the HCS team:
The changes are visible on the branches "background" and "no-backgroud".
The DEFAULT mode has been replaced with custom 4x4 pattern with either visible or invisible pattern points and a custom background.
Changes were made for an experiment by Team S for the course Human Centered Security, University of Glasgow 2023.
The .APK files have been compiled and released under relases.
The Team S thanks itsxtt - the original author of this code for creation of the bases and used this source in accordance with the Licence.

### Original README continues below

Awesome pattern lock view for android written in kotlin.

[demo](https://github.com/itsxtt/pattern-lock/tree/master/apk)

## Features

* easy to use
* beautiful built-in styles
* fully customizable
* tiny size around 35 KB

## Preview

<ul style="float:left">
    <img src="./screenshots/default.gif" width="150"/>
    <img src="./screenshots/indicator.gif" width="150"/>
    <img src="./screenshots/jdstyle.gif" width="150"/>
    <img src="./screenshots/nine.gif" width="150"/>
</ul>

## Usage

### Gradle
Top level build file:
``` gradle
allprojects {
    repositories {
        mavenCentral()
    }
}
```
In your application build file:
``` gradle
implementation 'io.github.itsxtt:pattern-lock:0.2.0'
```

### XML

``` xml
<com.itsxtt.patternlock.PatternLockView
    android:id="@+id/patternLockView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"/>
```

### Kotlin

``` Kotlin
patternLockView.setOnPatternListener(object : PatternLockView.OnPatternListener {
    override fun onStarted() {
        super.onStarted()
    }

    override fun onProgress(ids: ArrayList<Int>) {
        super.onProgress(ids)
    }

    override fun onComplete(ids: ArrayList<Int>): Boolean {
        /*
         * A return value required
         * if the pattern is not correct and you'd like change the pattern to error state, return false
         * otherwise return true
         */
        return isPatternCorrect()
    }
})
```

### Java

``` Java
patternLockView.setOnPatternListener(new PatternLockView.OnPatternListener() {
    @Override
    public void onStarted() {

    }

    @Override
    public void onProgress(ArrayList<Integer> ids) {

    }

    @Override
    public boolean onComplete(ArrayList<Integer> ids) {
        /*
         * A return value required
         * if the pattern is not correct and you'd like change the pattern to error state, return false
         * otherwise return true
         */
        return isPatternCorrect();
    }
});
```

### Customization

#### Built-in Styles

[preview](https://github.com/itsxtt/pattern-lock/blob/master/screenshots/jdstyle.gif)

```
style="@style/PatternLockView.JDStyle"
```


[preview](https://github.com/itsxtt/pattern-lock/blob/master/screenshots/indicator.gif)

```
style="@style/PatternLockView.WithIndicator"
```

#### Custom Attributes

name | format | default value | description
---|---|---|---
plv_regularCellBackground | color\|reference | null |
plv_regularDotColor | color | #d8dbe9 |
plv_regularDotRadiusRatio | float | 0.3 |
plv_selectedCellBackground | color\|reference | null |
plv_selectedDotColor | color | #587bf4 |
plv_selectedDotRadiusRatio | float | 0.3 |
plv_errorCellBackground | color\|reference | null |
plv_errorDotColor | color | #ea4954 |
plv_errorDotRadiusRatio | float | 0.3 |
plv_lineStyle | enum | common | two values: [common](https://github.com/itsxtt/pattern-lock/blob/master/screenshots/default.gif), [indicator](https://github.com/itsxtt/pattern-lock/blob/master/screenshots/indicator.gif)
plv_lineWidth | dimension | 2dp |  
plv_regularLineColor | color | #587bf4 |
plv_errorLineColor | color | #ea4954 |
plv_spacing | dimension | 24dp |
plv_rowCount | integer | 3 |
plv_columnCount | integer | 3 |
plv_errorDuration | integer | 400 | millisecond
plv_hitAreaPaddingRatio | float | 0.2 |
plv_indicatorSizeRatio | float | 0.2 |

#### Secure Mode

You can turn the secure mode on or off via call ```enableSecureMode()``` and ```disableSecureMode()```.


## Change Log

### 0.2.0 (2021-10-08)
* migrate to androidx
* migrate to mavenCentral

### 0.1.0 (2018-05-31)
* first release

## License

    Copyright 2018 itsxtt
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
    http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.








