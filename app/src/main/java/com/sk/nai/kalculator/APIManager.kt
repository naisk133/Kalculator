package com.sk.nai.kalculator

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by naisk133 on 22/12/2559.
 */
object APIManager {
    private val retrofit = Retrofit.Builder()
            .baseUrl("https://simple-api-server-ecswrhooxn.now.sh/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build();

    val formulaService = retrofit.create(FormulaService::class.java);
}