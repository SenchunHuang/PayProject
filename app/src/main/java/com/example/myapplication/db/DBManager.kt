package com.example.myapplication.db


import com.example.myapplication.model.ProjectEntity

/*
* 数据库管理类
*/
class DBManager() {

    companion object{
        @Volatile
        private var instance:DBManager?=null
        @Synchronized
        fun getInstance():DBManager{
            if(instance == null){
                instance = DBManager()
            }
            return instance!!
        }
    }

    fun insertProject(project: String?, feeCny: Double,feeUsd: Double,date:String):ProjectEntity {
        val projectEntity = ProjectEntity(project = project, feeCny = feeCny, feeUsd = feeUsd, date = date)
        AppDatabase.getInstance().payProjectDao().insert(projectEntity)
        return projectEntity
    }

    fun queryAllProject():List<ProjectEntity>  {
        return AppDatabase.getInstance().payProjectDao().getAll()
    }

}