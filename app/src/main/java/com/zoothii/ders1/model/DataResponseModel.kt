package com.zoothii.ders1.model

class DataResponseModel<T> (success: Boolean, message: Boolean, val data: Array<T>) : ResponseModel(success, message)