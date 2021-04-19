package com.zoothii.ders1.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.zoothii.ders1.helper.ErrorHandler
import com.zoothii.ders1.model.Brand
import com.zoothii.ders1.model.DataResponseModel
import com.zoothii.ders1.model.ResponseModel
import com.zoothii.ders1.model.SingleDataResponseModel
import com.zoothii.ders1.remote.IBrandsApi
import com.zoothii.ders1.remote.RetrofitService
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BrandRepository : IRepository {

    companion object Factory {
        fun create(): BrandRepository = BrandRepository()
    }

    private val brandApi: IBrandsApi by lazy {
        RetrofitService.buildService(IBrandsApi::class.java)
    }

    val brandDataResponse: MutableLiveData<DataResponseModel<Brand>> = MutableLiveData()
    val brandSingleDataResponse: MutableLiveData<SingleDataResponseModel<Brand>> = MutableLiveData()
    val brandResponse: MutableLiveData<ResponseModel> = MutableLiveData()

    fun getAllBrands(): MutableLiveData<DataResponseModel<Brand>> {
        brandApi.getAllBrands().enqueue(object : Callback<DataResponseModel<Brand>> {
            override fun onResponse(
                call: Call<DataResponseModel<Brand>>,
                response: Response<DataResponseModel<Brand>>
            ) {
                if (response.isSuccessful) {
                    brandDataResponse.value = response.body();
                } else {
                    ErrorHandler.handleError(response.errorBody()!!.string())
                }
            }

            override fun onFailure(call: Call<DataResponseModel<Brand>>, t: Throwable) {
                Log.d("Failure", t.message.toString())
                // brandResponse.value = null // not sure maybe needed
            }
        })
        return brandDataResponse
    }

    fun getBrandById(id: Int): MutableLiveData<SingleDataResponseModel<Brand>> {
        brandApi.getBrandById(id).enqueue(object : Callback<SingleDataResponseModel<Brand>> {
            override fun onResponse(
                call: Call<SingleDataResponseModel<Brand>>,
                response: Response<SingleDataResponseModel<Brand>>
            ) {
                if (response.isSuccessful) {
                    brandSingleDataResponse.value = response.body();
                } else {
                    ErrorHandler.handleError(response.errorBody()!!.string())
                }
            }

            override fun onFailure(call: Call<SingleDataResponseModel<Brand>>, t: Throwable) {
                Log.d("Failure", t.message.toString())
                // brandResponse.value = null // not sure maybe needed
            }
        })
        return brandSingleDataResponse
    }

    fun addBrand(brand: Brand): MutableLiveData<ResponseModel> {
        brandApi.addBrand(brand).enqueue(object : Callback<ResponseModel> {
            override fun onResponse(
                call: Call<ResponseModel>,
                response: Response<ResponseModel>
            ) {
                if (response.isSuccessful) {
                    brandResponse.value = response.body();
                } else {
                    ErrorHandler.handleError(response.errorBody()!!.string())
                }
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Log.d("Failure", t.message.toString())
                // brandResponse.value = null // not sure maybe needed
            }
        })
        return brandResponse
    }

}