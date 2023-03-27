package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Repository
import com.example.myapplication.model.AdapterEntity
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _adapterLiveData = MutableLiveData<MutableList<AdapterEntity>>()
    val adapterLiveData = _adapterLiveData

    /*
    * 查询数据库所有数据
    */
    fun queryAllData(){
        viewModelScope.launch{
           val allData = Repository.queryAllData()
            _adapterLiveData.value = allData
        }
    }

}