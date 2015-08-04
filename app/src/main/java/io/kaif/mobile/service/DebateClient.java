package io.kaif.mobile.service;

import java.util.List;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import retrofit.http.Retrofit;
import rx.Observable;
import io.kaif.mobile.model.oauth.AccessTokenManager;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import retrofit.RestAdapter.LogLevel;
import retrofit.converter.Converter;
import retrofit.ErrorHandler;
import retrofit.RequestInterceptor;

@Retrofit("https://kaif.io")
//@Retrofit.RequestInterceptor(io.kaif.mobile.AccessTokenInterceptor.class)
//@Retrofit.Headers({"Authorization: Bearer XXX", "Content-Type: application/json;charset=UTF-8"})
@Retrofit.Headers("Content-Type: application/json;charset=UTF-8")
@Retrofit.Converter(io.kaif.mobile.service.ServiceModule.AutoGsonConverter.class)
@Retrofit.LogLevel(LogLevel.FULL)
@Retrofit.RetryHeaders("Cache-Control: max-age=640000")
public abstract class DebateClient implements DebateService {
  @Retrofit.Builder
  public abstract static class Builder {
    public abstract Builder baseUrl(String baseUrl);
    public abstract Builder converter(Converter converter);
    public abstract Builder requestInterceptor(RequestInterceptor requestInterceptor);
    public abstract Builder errorHandler(ErrorHandler errorHandler);
    public abstract Builder headers(String... headers);
    public abstract Builder retryHeaders(String... headers);
    public abstract Builder logLevel(LogLevel logLevel);
    public abstract Builder context(Object object);
    //public abstract Builder context(Class<T> type, T context);
    public abstract Builder cache(Cache cache); // if no OkHttpClient be set
    public abstract Builder okHttpClient(OkHttpClient client);
    public abstract DebateClient build();
  }

  public static Builder builder() {
    return new Retrofit_DebateClient.Builder();
  }

  public static DebateClient create() {
    return new Retrofit_DebateClient();
  }
}

