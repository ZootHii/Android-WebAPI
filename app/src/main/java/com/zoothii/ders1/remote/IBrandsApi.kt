package com.zoothii.ders1.remote

import com.zoothii.ders1.model.Brand
import com.zoothii.ders1.model.DataResponseModel
import com.zoothii.ders1.model.ResponseModel
import com.zoothii.ders1.model.SingleDataResponseModel
import retrofit2.Call;
import retrofit2.http.*

interface IBrandsApi {


    @GET("Brands/get/all")
    fun getAllBrands(): Call<DataResponseModel<Brand>>

    @GET("Brands/get/by/id")
    fun getBrandById(@Query("id") id: Int): Call<SingleDataResponseModel<Brand>>

/*    @FormUrlEncoded
    @POST("Brands/add")
    fun addBrand(
        @Field("id") id: Int,
        @Field("brandName") brandName: String,
    ): Call<ResponseModel>*/

    @POST("Brands/add")
    fun addBrand(@Body brand: Brand): Call<ResponseModel>
}