# Catcho

![](https://img.shields.io/badge/Platform-Android-brightgreen.svg)
![](https://img.shields.io/crates/l/rustc-serialize.svg)
![](https://img.shields.io/badge/version-0.1.0_beta-blue.svg)

---
<p align="center">
  <img src="https://cloud.githubusercontent.com/assets/4659608/14591472/b33d5f8a-051a-11e6-9601-807371433097.png" width="500"></p>

All android developer must have faced force close issue while developing an application.
Here is a library to catch that error and treat it elegantly.

Catcho will create an error page kind of mechanism in your android application.So whenever your application is crashed user will not able to see that irritating pop up dialog. Instead of that app will display a predefined view to the user.

You can report any issue on issues page. **Note: If you speak Arabic, you can submit issues with Arabic language and I will check them. :)**

##Installation
**Maven**
```xml
<dependency>
<groupId>net.alhazmy13.catcho</groupId>
<artifactId>library</artifactId>
<version>0.1.0-beta</version>
</dependency>
```

**Gradle**
```gradle
dependencies {
	compile 'net.alhazmy13.catcho:library:0.1.0-beta'
}
```



# Usage
Though it is very simple. Copy following line of code in your each (Activity or Application) class just after the call of super method in your overriden onCreate method.

```java
Thread.setDefaultUncaughtExceptionHandler(new Catcho.Builder(this).build());
```

Your Activity may look something like this…

```java
public class AnyActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Thread.setDefaultUncaughtExceptionHandler(new Catcho.Builder(this).build());

        setContentView(R.layout.main);

        // Your mechanism is ready now.. In this activity from anywhere 
        // if you get force close error it will be redirected to the Catcho.
    }
}
```

### Additional Options


### Credits 



## License

    Copyright 2016 alhazmy

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
    
