package com.example.wordskill02application

import android.content.Context

class Prefs(context:Context){

    private val storage = context.getSharedPreferences("app",0)

    fun saveName(name:String){
        storage.edit().putString("fullname",name).apply()
    }

    fun getName():String{
        return storage.getString("fullname","")!!
    }

    fun setAmount(amount:Int){
        storage.edit().putInt("amount",amount).apply()
    }

    fun getAmount():Int{
        return storage.getInt("amount",0)
    }

    fun setHome(amount:Boolean){
        storage.edit().putBoolean("home",amount).apply()
    }

    fun getHome():Boolean{
        return storage.getBoolean("home",false)
    }

    fun wipe(){
        storage.edit().clear().apply()
    }

}
