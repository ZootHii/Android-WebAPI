package com.zoothii.ders1.aanotused/*
package com.zoothii.ders1

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zoothii.ders1.model.Brand
import com.zoothii.ders1.model.DataResponse
import com.zoothii.ders1.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import kotlin.system.exitProcess

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<DataResponse<Brand>> = MutableLiveData()

    fun getAllBrands(){
        viewModelScope.launch {
            try {
                val response = repository.getAllBrands()
                myResponse.value = response
            }
            catch (ex: HttpException){
                Log.d("ERROR", ex.message())
            }
        }
    }
}*/
