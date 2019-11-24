package com.example.viewmodelfinalwithtmdb.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.viewmodelfinalwithtmdb.Models.MovieRespondModel;
import com.example.viewmodelfinalwithtmdb.Repositories.PopularRepository;

public class PopularViewModel extends ViewModel {
    private LiveData<MovieRespondModel> movieRespondModel;
    private PopularRepository repository=new PopularRepository();
    public LiveData<MovieRespondModel> storepopular()
    {
        if(movieRespondModel==null)
        {
            movieRespondModel=repository.getPopularLiveData();

        }
        return movieRespondModel;
    }

}
