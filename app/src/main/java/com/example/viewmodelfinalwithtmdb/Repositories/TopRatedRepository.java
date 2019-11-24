package com.example.viewmodelfinalwithtmdb.Repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.viewmodelfinalwithtmdb.Models.MovieRespondModel;
import com.example.viewmodelfinalwithtmdb.Retrofits.Apicalls;
import com.example.viewmodelfinalwithtmdb.Retrofits.RetrofitObj;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopRatedRepository {
    public LiveData<MovieRespondModel> getLiveData()
    {
        final MutableLiveData<MovieRespondModel> movieRespondModelMutableLiveData=new MutableLiveData<>();
        Apicalls apicalls= RetrofitObj.getRetrofit().create(Apicalls.class);
        Call<MovieRespondModel> movieRespondModelCall=apicalls.getTopRated("f17a830b443f5f3c5bcc8c13863083b1",1);
        movieRespondModelCall.enqueue(new Callback<MovieRespondModel>() {
            @Override
            public void onResponse(Call<MovieRespondModel> call, Response<MovieRespondModel> response) {
                movieRespondModelMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<MovieRespondModel> call, Throwable t) {

            }
        });
        return movieRespondModelMutableLiveData;
    }
}
