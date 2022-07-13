package com.relsellglobal.kotlinhiltdemo.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.relsellglobal.domainlib.appinterfaces.IGWeatherDataFetchUseCase
import com.relsellglobal.kotlinhiltdemo.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel
    @Inject constructor(val igWeatherDataFetchUseCase: IGWeatherDataFetchUseCase): ViewModel() {
    var response: MutableState<ApiState> =  mutableStateOf(ApiState.Empty)

    init {
        getBooksListFromApi("business")
    }

    fun getBooksListFromApi(queryString : String) = viewModelScope.launch {
        igWeatherDataFetchUseCase.getBooksListFromApi(queryString)
            .onStart {
                response.value = ApiState.Loading
            }.catch { it ->
                response.value = ApiState.Failure(it)
            }.map {
                 it.items
            }.collect {

                response.value  = ApiState.Success(it)
            }
    }


}