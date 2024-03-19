import com.example.ainnovatask.UserRequest
import com.example.ainnovatask.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("auth/login")
    fun postData(@Body dataModel: UserRequest?): Call<UserResponse>
}
