package com.zoothii.ders1.model

class SingleDataResponseModel<T> (success: Boolean, message: Boolean, val data: T) : ResponseModel(success, message)