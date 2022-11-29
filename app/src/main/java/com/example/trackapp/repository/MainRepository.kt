package com.example.trackapp.repository

import com.example.trackapp.db.Run
import com.example.trackapp.db.RunDao
import javax.inject.Inject

class MainRepository @Inject constructor(val runDao: RunDao){

    suspend fun insertRun(run: Run) = runDao.insertRun(run)

    suspend fun deleteRun(run: Run) = runDao.deleteRun(run)

    fun getAllRunsSortedByDate() = runDao.getAllRunsSortedByDate()

    fun getAllRunsSortedByTimeInMillis() = runDao.getAllRunsSortedByTimeInMillis()

    fun getAllRunsSortedByDistance() = runDao.getAllRunsSortedByDistance()


    fun getAllRunsSortedByAvgSpeed() = runDao.getAllRunsSortedByAvgSpeed()

}