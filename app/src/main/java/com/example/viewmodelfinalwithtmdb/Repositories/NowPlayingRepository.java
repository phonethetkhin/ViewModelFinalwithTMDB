package com.example.viewmodelfinalwithtmdb.Repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.viewmodelfinalwithtmdb.Models.MovieRespondModel;
import com.example.viewmodelfinalwithtmdb.Retrofits.Apicalls;
import com.example.viewmodelfinalwithtmdb.Retrofits.RetrofitObj;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NowPlayingRepository {
    public LiveData<MovieRespondModel> getNowPlaying()
    {
        final MutableLiveData<MovieRespondModel> movieRespondModelMutableLiveData=new MutableLiveData<>();
        Apicalls apicalls= RetrofitObj.getRetrofit().create(Apicalls.class);
        Call<MovieRespondModel> respondModelCall=apicalls.getNowPlaying("f17a830b443f5f3c5bcc8c13863083b1",1);

        respondModelCall.enqueue(new Callback<MovieRespondModel>() {
            @Override
            public void onResponse(Call<MovieRespondModel> call, Response<MovieRespondModel> response) {
                MovieRespondModel movieRespondModel=response.body();
                movieRespondModelMutableLiveData.setValue(movieRespondModel);
            }

            @Override
            public void onFailure(Call<MovieRespondModel> call, Throwable t) {

            }
        });

return movieRespondModelMutableLiveData;
    }
}
