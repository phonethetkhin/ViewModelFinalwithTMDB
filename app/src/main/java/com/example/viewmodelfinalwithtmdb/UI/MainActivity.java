package com.example.viewmodelfinalwithtmdb.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.viewmodelfinalwithtmdb.Adapters.VerticalAdapter;
import com.example.viewmodelfinalwithtmdb.Models.HorizontalModels;
import com.example.viewmodelfinalwithtmdb.Models.MovieRespondModel;
import com.example.viewmodelfinalwithtmdb.Models.VerticalModels;
import com.example.viewmodelfinalwithtmdb.R;
import com.example.viewmodelfinalwithtmdb.ViewModel.NowPlayingViewModel;
import com.example.viewmodelfinalwithtmdb.ViewModel.PopularViewModel;
import com.example.viewmodelfinalwithtmdb.ViewModel.TopRatedViewModel;
import com.example.viewmodelfinalwithtmdb.ViewModel.UpcomingViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView rvVertical;
List<VerticalModels> verticalModelsList=new ArrayList<>();
List<MovieRespondModel.MovieModel> movieModelslist=new ArrayList<>();
List<HorizontalModels> Nowplaying=new ArrayList<>();
List<HorizontalModels> Popular=new ArrayList<>();
List<HorizontalModels> Upcoming=new ArrayList<>();
List<HorizontalModels> TopRated=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvVertical=findViewById(R.id.rvVertical);
        rvVertical.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false));
        rvVertical.setHasFixedSize(true);

getNowPlaying();



    }
    public void getNowPlaying()
    {
        NowPlayingViewModel nowPlayingViewModel= ViewModelProviders.of(this).get(NowPlayingViewModel.class);
        nowPlayingViewModel.getMovieRespondModelLiveData().observe(this, new Observer<MovieRespondModel>() {
            @Override
            public void onChanged(MovieRespondModel movieRespondModel) {
                MovieRespondModel model=movieRespondModel;
                movieModelslist=model.getResults();
                for(int i=0;i<movieModelslist.size();i++)
                {
                    Nowplaying.add(new HorizontalModels(movieModelslist.get(i).getPoster_path(),movieModelslist.get(i).getTitle(),movieModelslist.get(i).getVote_average()));

                }
                verticalModelsList.add(new VerticalModels("Now Playing",Nowplaying));

                rvVertical.setAdapter(new VerticalAdapter(MainActivity.this,verticalModelsList));
                Popular();

            }
        });
    }
    public void Popular()
    {
        PopularViewModel popularViewModel=ViewModelProviders.of(this).get(PopularViewModel.class);
        popularViewModel.storepopular().observe(this, new Observer<MovieRespondModel>() {
            @Override
            public void onChanged(MovieRespondModel movieRespondModel) {
                MovieRespondModel movieRespondModel2=movieRespondModel;
                movieModelslist=movieRespondModel2.getResults();
                for(int i=0;i<movieModelslist.size();i++)
                {
                Popular.add(new HorizontalModels(movieModelslist.get(i).getPoster_path(),movieModelslist.get(i).getTitle(),movieModelslist.get(i).getVote_average()));

                }
                verticalModelsList.add(new VerticalModels("Popular",Popular));
                rvVertical.setAdapter(new VerticalAdapter(MainActivity.this,verticalModelsList));
                Upcoming();

            }
        });
    }
    public void Upcoming()
    {
        UpcomingViewModel upcomingViewModel=ViewModelProviders.of(this).get(UpcomingViewModel.class);
        upcomingViewModel.storeUpcoming().observe(this, new Observer<MovieRespondModel>() {
            @Override
            public void onChanged(MovieRespondModel movieRespondModel) {
                MovieRespondModel movieRespondModel3=movieRespondModel;
                movieModelslist=movieRespondModel3.getResults();
                for(int i=0;i<movieModelslist.size();i++)
                {
                    Upcoming.add(new HorizontalModels(movieModelslist.get(i).getPoster_path(),movieModelslist.get(i).getTitle(),movieModelslist.get(i).getVote_average()));
                }
                verticalModelsList.add(new VerticalModels("Upcoming",Upcoming));
                rvVertical.setAdapter(new VerticalAdapter(MainActivity.this,verticalModelsList));
                TopRated();
            }
        });
    }
    public void TopRated()
    {
        TopRatedViewModel topRatedViewModel=ViewModelProviders.of(this).get(TopRatedViewModel.class);
        topRatedViewModel.storeTopRated().observe(this, new Observer<MovieRespondModel>() {
            @Override
            public void onChanged(MovieRespondModel movieRespondModel) {
                MovieRespondModel movieRespondModel4=movieRespondModel;
                movieModelslist=movieRespondModel4.getResults();
                for(int i=0; i<movieModelslist.size();i++)
                {
                    TopRated.add(new HorizontalModels(movieModelslist.get(i).getPoster_path(),movieModelslist.get(i).getTitle(),movieModelslist.get(i).getVote_average()));
                }
                verticalModelsList.add(new VerticalModels("Top Rated",TopRated));
                rvVertical.setAdapter(new VerticalAdapter(MainActivity.this,verticalModelsList));
            }
        });
    }

}
