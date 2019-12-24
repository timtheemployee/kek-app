package kek.foundation.terrorhistory

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.IllegalArgumentException

class SimpleResponse<T>(
) : Callback<T> {
    override fun onFailure(call: Call<T>, t: Throwable) {
        Log.e("Failure", "Fail to log")
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        Log.e("Success", "Success to log with code ${response.code()}")
    }
}