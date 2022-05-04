package com.obyte.alcohol.Rest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServerService {
    @GET("15048755/v1/uddi:fec53d3a-2bef-4494-b50e-f4e566f403e0")
    Call<PageData> getData(@Query("page") int page,
                           @Query("perPage") int perPage,
                           @Query("serviceKey") String serviceKey);
}
