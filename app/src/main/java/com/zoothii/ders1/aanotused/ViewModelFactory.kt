package com.zoothii.ders1.aanotused/*
package com.zoothii.ders1


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zoothii.ders1.repository.BrandRepository

class ViewModelFactory(private val brandRepository: BrandRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BrandViewModel(brandRepository) as T
    }
}*/
