package com.zoothii.ders1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zoothii.ders1.model.Brand
import com.zoothii.ders1.model.DataResponseModel
import com.zoothii.ders1.model.ResponseModel
import com.zoothii.ders1.model.SingleDataResponseModel
import com.zoothii.ders1.repository.BrandRepository
import kotlinx.coroutines.launch

class BrandViewModel(private val brandRepository: BrandRepository) : ViewModel() {
/*    private lateinit var brandResponse: MutableLiveData<DataResponse<Brand>>

    init {
        viewModelScope.launch {
            brandResponse.value = brandRepository.getAllBrands().value
        }
    }

    fun getAllBrands(): LiveData<DataResponse<Brand>>{
        return brandResponse
    }*/

    lateinit var brandDataResponse: MutableLiveData<DataResponseModel<Brand>>
    lateinit var brandSingleDataResponse: MutableLiveData<SingleDataResponseModel<Brand>>
    lateinit var brandResponse: MutableLiveData<ResponseModel>

    fun getAllBrands(){
        viewModelScope.launch {
            brandDataResponse = brandRepository.getAllBrands()
        }
    }

    fun getBrandById(id: Int){
        viewModelScope.launch {
            brandSingleDataResponse = brandRepository.getBrandById(id)
        }
    }

    fun addBrand(brand: Brand){
        viewModelScope.launch {
            brandResponse = brandRepository.addBrand(brand)
        }
    }

}