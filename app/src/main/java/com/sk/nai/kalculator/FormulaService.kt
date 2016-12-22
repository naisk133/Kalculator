package com.sk.nai.kalculator

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by naisk133 on 22/12/2559.
 */
interface FormulaService {

    @GET("get")
    fun listFormulas(): Call<List<Formula>>

    @GET("get/{idx}")
    fun getFormula(@Path("idx") index: Int): Call<Formula>

}