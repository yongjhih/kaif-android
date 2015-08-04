package io.kaif.mobile.service;

import io.kaif.mobile.model.oauth.AccessTokenInfo;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import retrofit.http.Retrofit;
import rx.Observable;

@Retrofit("https://kaif.io")
@Retrofit.Headers("Content-Type: application/json;charset=UTF-8")
@Retrofit.Converter(io.kaif.mobile.service.ServiceModule.AutoGsonConverter.class)
public abstract class Oauth implements OauthService {
    public static Oauth create() {
        return new Retrofit_Oauth();
    }
}
