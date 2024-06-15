package com.example.querizz_app.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.querizz_app.data.SumPagingSource
import com.example.querizz_app.data.api.config.ApiConfig
import com.example.querizz_app.data.api.service.ApiService
import com.example.querizz_app.data.api.service.AuthApiService
import com.example.querizz_app.data.pref.UserPreference
import com.example.querizz_app.data.response.DataItem
import com.example.querizz_app.data.response.UploadResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.withContext
import okhttp3.MultipartBody
import okhttp3.RequestBody

class Repository(
    private val apiService: ApiService,
    private val userPreference: UserPreference
) {

    fun getSession() = userPreference.getSession()

    suspend fun logout() = userPreference.logout()

//    fun getSummary(): LiveData<PagingData<DataItem>> = liveData {
//        val userSession = userPreference.getSession().firstOrNull()
//        if (userSession != null && userSession.token.isNotEmpty()) {
//            val token = userSession.token
//            val apiService = ApiConfig.getApiService(token)
//            val pager = Pager(
//                config = PagingConfig(
//                    pageSize = 5
//                ),
//                pagingSourceFactory = {
//                    SumPagingSource(apiService)
//                }
//            ).liveData
//            emitSource(pager)
//        } else {
//            emit(PagingData.empty())
//        }
//    }

    companion object {
        fun getInstance(apiService: ApiService, userPreference: UserPreference) =
            Repository(apiService, userPreference)
    }
}