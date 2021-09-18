package com.example.demonsoulswiki.networking

import dagger.Module
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import java.io.IOException
import javax.inject.Inject


@InstallIn(SingletonComponent::class)
@Module
class ErrorUtils {

    @Inject
    lateinit var retrofit: Retrofit

    fun parseError(exception: HttpException): APIError {

        val converter: Converter<ResponseBody, APIError> = retrofit.responseBodyConverter(APIError::class.java, arrayOfNulls<Annotation>(0))

        val error: APIError

        error = try {
            converter.convert(exception.response()!!.errorBody()!!)!!
        } catch (e: IOException) {
            return APIError("")
        }

        return error
    }

    fun parseErrorResponse(response: Response<*>): APIError {

        val converter: Converter<ResponseBody, APIError> = retrofit.responseBodyConverter(APIError::class.java, arrayOfNulls<Annotation>(0))

        val error: APIError

        error = try {
            converter.convert(response.errorBody())!!
        } catch (e: IOException) {
            return APIError("")
        }

        return error
    }
}
