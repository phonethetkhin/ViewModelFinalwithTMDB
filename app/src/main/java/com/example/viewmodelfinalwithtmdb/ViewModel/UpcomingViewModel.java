package com.example.viewmodelfinalwithtmdb.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.viewmodelfinalwithtmdb.Models.MovieRespondModel;
import com.example.viewmodelfinalwithtmdb.Repositories.UpcomingRepository;
import com.example.viewmodelfinalwithtmdb.Retrofits.Apicalls;
import com.example.viewmodelfinalwithtmdb.Retrofits.RetrofitObj;

import retrofit2.Call;

public class UpcomingViewModel extends ViewModel {
    private LiveData<MovieRespondModel> movieRespondModelLiveData;

    private UpcomingRepository repository=new UpcomingRepository();
    public LiveData<MovieRespondModel> storeUpcoming()
    {
        if(movieRespondModelLiveData==null)
        {
            movieRespondModelLiveData=repository.getmovielivedata();
        }
        return movieRespondModelLiveData;
    }
}
