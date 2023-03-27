package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Repository
import com.example.myapplication.model.ConvertResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.Response

class PayViewModel : ViewModel() {

    private val _resultLiveData = MutableLiveData<ConvertResponse>()
    val resultLiveData = _resultLiveData

    /*
    * 通过接口查询美元金额
    */
    fun getUSDAmount(project:String,amount:Double){
        viewModelScope.launch{
            val res = Repository.getUSDAmount(project,amount)
            res.getOrNull()?.let {
                _resultLiveData.postValue(it)
            }
        }
    }
}