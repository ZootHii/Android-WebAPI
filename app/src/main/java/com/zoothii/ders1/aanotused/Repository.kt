/*
package com.zoothii.ders1.repository

import com.zoothii.ders1.notused.api.RetrofitInstance
import com.zoothii.ders1.model.Brand
import com.zoothii.ders1.model.DataResponse
import com.zoothii.ders1.remote.RetrofitService

class Repository {

*/
/*    suspend fun getAllBrands(): DataResponse<Brand>{
        return RetrofitInstance.api.getAllBrands()
    }*//*

    suspend fun getAllBrands(): DataResponse<Brand>{
        return RetrofitService.buildService()
    }
}*/
