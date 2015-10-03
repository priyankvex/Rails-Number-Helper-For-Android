# Rails-Number-Helper-For-Android
Rails or to be precise Ruby contains many interesting and useful modules. One of the high utlity modules is ```number_helper```

This library is port of ```number_helper``` module of Rails for Android.

<h3>Usage</h3>

Just include the ```numberHelper``` helper module in your application and include module dependency.

<h3>Samples</h3>

Samples and library usage is given in sample ```app```.

```java
  // Number to human converter
        NumberToHumanConverterBuilder builder2 = new NumberToHumanConverterBuilder(123456);
        NumberToHumanConverter converter2 = builder2.build();
        try {
            String humanNumber = converter2.convert();
            Log.d(Config.TAG, humanNumber);
        } catch (InvalidSeparatorException | InvalidDelimiterException
                | InvalidPrecisionException e) {
            e.printStackTrace();
        }
```

Output : ```123.456 Thousands``` 
