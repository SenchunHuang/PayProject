package com.example.myapplication

import com.example.myapplication.db.DBManager
import com.example.myapplication.model.AdapterEntity
import com.example.myapplication.model.ConvertResponse
import com.example.myapplication.network.NetworkManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/*
* 数据存储
*/
object Repository {

    private val list = mutableListOf<AdapterEntity>()

    suspend fun getUSDAmount(project:String,amount:Double): Result<ConvertResponse> {
         val res = withContext(Dispatchers.IO){
            val response = NetworkManager.getUSDAmount(amount)
            if (response.success){
                DBManager.getInstance().insertProject(project,amount,response.result,response.date)
                Result.success(response)
            }else {
                Result.failure(RuntimeException("response error"))
            }
        }
        return res
    }

    suspend fun queryAllData():MutableList<AdapterEntity>{
          return withContext(Dispatchers.IO){
             val allData = DBManager.getInstance().queryAllProject()
             val data = allData.map {
                 AdapterEntity(
                     it.project,
                     it.feeCny.toString(),
                     it.feeUsd.toString(),
                     it.date
                 )
             }
              list.clear()
              list.addAll(data)
              list
         }
    }

}