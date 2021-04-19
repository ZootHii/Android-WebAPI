package com.zoothii.ders1.util

class Constants {
    companion object{
        // 192.168.1.33
        // One important note here is that we won’t be running our APIs on IIS Express,
        // we will run it on the default hosting of ASP.NET Core Web API, why?
        // Because we will run our Android App on an emulator and the emulator must connect to IP Address 10.0.2.2
        // which is another alias for 127.0.0.1 but not localhost, therefore,
        // the emulator won’t be able to connect to IIS Express but it will connect to the default host of ASP.NET Core Web API.

        const val BASE_URL = "http://10.0.2.2:5000/"
    }
}