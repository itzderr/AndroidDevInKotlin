package com.derrick.park.recyclerviewdemo

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

class Data(val count: Int, val results: Array<SWChar>) {
    class Deserializer : ResponseDeserializable<Data> {
        override fun deserialize(content: String): Data
                = Gson().fromJson(content, Data::class.java)
    }
}

data class SWChar(var name: String,
                  var height: Int,
                  var mass: Int,
                  var eye_color: String,
                  var gender: String) {
    class Deserializer : ResponseDeserializable<SWChar> {
        override fun deserialize(content: String): SWChar
                = Gson().fromJson(content, SWChar::class.java)
    }
}

