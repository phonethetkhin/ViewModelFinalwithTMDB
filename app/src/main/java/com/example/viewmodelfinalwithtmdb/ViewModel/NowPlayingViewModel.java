package com.example.viewmodelfinalwithtmdb.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.viewmodelfinalwithtmdb.Models.MovieRespondModel;
import com.example.viewmodelfinalwithtmdb.Repositories.NowPlayingRepository;

public class NowPlayingViewModel extends ViewModel {
    private LiveData<MovieRespondModel> movieRespondModelLiveData;
    private NowPlayingRepository repository=new NowPlayingRepository();
    public LiveData<MovieRespondModel> getMovieRespondModelLiveData()
    {
       if(movieRespondModelLiveData==null) {
           movieRespondModelLiveData = repository.getNowPlaying();
       }
    return movieRespondModelLiveData;
    }

}
