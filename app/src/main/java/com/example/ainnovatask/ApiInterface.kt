import com.example.ainnovatask.ProductResponse
import com.example.ainnovatask.UserRequest
import com.example.ainnovatask.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.GET

interface ApiInterface {
    @POST("auth/login")
    fun requestLogin(@Body dataModel: UserRequest?): Call<UserResponse>

    @GET("products")
    fun getProducts() : Call<ProductResponse>
}
