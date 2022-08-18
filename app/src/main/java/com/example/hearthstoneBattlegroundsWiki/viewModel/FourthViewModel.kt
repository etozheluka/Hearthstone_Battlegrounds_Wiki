package com.example.dota2herowiki.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dota2herowiki.dataHolder.DataModel
import com.example.dota2herowiki.network.RetrofitClient
import com.example.dota2herowiki.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FourthViewModel : ViewModel() {
    private val _apiResponse = MutableStateFlow<Resource<List<DataModel.Card?>>>(Resource.Loading(true))
    val apiResponse = _apiResponse.asStateFlow()

    fun getContent(){
        viewModelScope.launch {
            val response = RetrofitClient.getInformation().getFourthTavernTier()
            if (response.isSuccessful){

                val body: DataModel? = response.body()
                _apiResponse.emit(Resource.Success(body?.cards ?: emptyList()))
                Log.d("response", "$body ")
            }else{
                val error = response.errorBody()
                _apiResponse.emit(Resource.Error(error.toString()))
                Log.d("responseError", "$error")
            }
        }
    }
}