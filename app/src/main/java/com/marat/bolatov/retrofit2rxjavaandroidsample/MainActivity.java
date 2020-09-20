package com.marat.bolatov.retrofit2rxjavaandroidsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

import android.os.Bundle;

import com.marat.bolatov.retrofit2rxjavaandroidsample.adapter.UserAdapter;
import com.marat.bolatov.retrofit2rxjavaandroidsample.model.UserPojo;
import com.marat.bolatov.retrofit2rxjavaandroidsample.retrofit.RetrofitClient;
import com.marat.bolatov.retrofit2rxjavaandroidsample.retrofit.UserApi;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private UserApi userApi;
    private RecyclerView recyclerView;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initApi();
    }

    @Override
    protected void onStop() {
        super.onStop();
        compositeDisposable.clear();
    }

    private void initApi() {
        Retrofit retrofit = RetrofitClient.getRetrofitInstance();
        userApi = retrofit.create(UserApi.class);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_user);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fetchData();
    }

    private void fetchData() {
        compositeDisposable.add(userApi.getUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::displayData));
    }

    private void displayData(List<UserPojo> userPojos) {
        UserAdapter adapter = new UserAdapter(this, userPojos);
        recyclerView.setAdapter(adapter);
    }
}