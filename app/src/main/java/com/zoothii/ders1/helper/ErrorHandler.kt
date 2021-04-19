package com.zoothii.ders1.helper

import android.util.Log
import org.json.JSONObject

class ErrorHandler {

    companion object{
        fun handleError(errorBody: String){
            val jObjError = JSONObject(errorBody)
            if (!jObjError.isNull("Type")) {
                val str = jObjError.getString("Message")
                Log.d("Error TYPE", str.toString())
            } else {
                val str = jObjError.getString("message")
                Log.d("Error", str.toString())
            }
        }
    }
}