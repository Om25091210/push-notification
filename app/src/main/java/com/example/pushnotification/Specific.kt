package com.example.pushnotification

import android.util.Log
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import java.lang.Exception

class Specific {
    val TAG="send"

    fun noti(name:String,phone:String,token:String){

        val title=name
        val message=phone

        if(message!=null){
            if(title!=null){
                if(title.isNotEmpty() && message.isNotEmpty()){
                    PushNotification(
                            NotificationData(title,message),
                            token
                    ).also {
                        sendNotification(it)
                    }
                }
            }
        }
    }

    private fun sendNotification(notification: PushNotification)= CoroutineScope(Dispatchers.IO).launch {

        try{
            val response=RetrofirInstance.api.postNotification(notification)
            if(response.isSuccessful){
                Log.d(TAG,"Response:${Gson().toJson(response)}")
            }else{
                Log.e(TAG,response.errorBody().toString())
            }

        }catch (e:Exception){
            Log.e(TAG,e.toString())
        }

    }

}