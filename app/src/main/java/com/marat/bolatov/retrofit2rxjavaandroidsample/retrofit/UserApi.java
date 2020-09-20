package com.marat.bolatov.retrofit2rxjavaandroidsample.retrofit;

import com.marat.bolatov.retrofit2rxjavaandroidsample.model.UserPojo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface UserApi {

    @GET("/posts")
    Observable<List<UserPojo>> getUser();
}
