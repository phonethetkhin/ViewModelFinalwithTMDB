package com.example.viewmodelfinalwithtmdb.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.viewmodelfinalwithtmdb.Models.MovieRespondModel;
import com.example.viewmodelfinalwithtmdb.Repositories.TopRatedRepository;

public class TopRatedViewModel extends ViewModel {
    private LiveData<MovieRespondModel> movieRespondModelLiveData;
    private TopRatedRepository repository=new TopRatedRepository();

    public LiveData<MovieRespondModel> storeTopRated()
    {
        if(movieRespondModelLiveData==null)
        {
            movieRespondModelLiveData=repository.getLiveData();


        }
        return movieRespondModelLiveData;
    }
}
