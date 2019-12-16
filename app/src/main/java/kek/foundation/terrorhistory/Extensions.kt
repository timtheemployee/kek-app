package kek.foundation.terrorhistory

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.IllegalArgumentException

class SimpleResponse<T>(
    private val success: (T) -> Unit,
    private val error: (Throwable) -> Unit
) : Callback<T> {
    override fun onFailure(call: Call<T>, t: Throwable) {
        error(t)
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        if (response.isSuccessful) {
            val body = response.body()

            require(body != null) { error(IllegalArgumentException("Empty response")) }

            success(body)
        } else {
            error(IllegalArgumentException("Error with code -> ${response.code()}"))
        }
    }
}