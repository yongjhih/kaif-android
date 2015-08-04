package io.kaif.mobile;

import retrofit.http.Retrofit.SimpleRequestInterceptor;
import io.kaif.mobile.model.oauth.AccessTokenInfo;
import io.kaif.mobile.model.oauth.AccessTokenManager;

public class AccessTokenInterceptor extends SimpleRequestInterceptor {
  @Override
  public void intercept(Object context, RequestFacade request) {
      final AccessTokenInfo accountTokenInfo = ((AccessTokenManager) context).findAccount();
      if (accountTokenInfo != null) {
        request.addHeader("Authorization", accountTokenInfo.getAuthorization());
      }
  }
}
