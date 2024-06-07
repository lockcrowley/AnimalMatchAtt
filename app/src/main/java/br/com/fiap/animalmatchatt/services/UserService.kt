package br.com.fiap.animalmatchatt.services

import br.com.fiap.animalmatchatt.model.EditResponse
import br.com.fiap.animalmatchatt.model.EditUser
import br.com.fiap.animalmatchatt.model.PasswordChangeRequest
import br.com.fiap.animalmatchatt.model.User
import retrofit2.Call
import retrofit2.http.*

interface UserService {
    @GET("users/list")
    fun getUsers(): Call<List<User>>

    @GET("users/list-by-email")
    fun getUserByEmail(@Query("email") email: String): Call<User>

    @PUT("users/edit")
    fun editProfile(
        @Header("Authorization") token: String ?,
        @Body user: EditUser
    ): Call<EditResponse>

    @PUT("users/change-password")
    fun changePassword(
        @Header("Authorization") token: String ?
        ,@Body passwordChangeRequest: PasswordChangeRequest
    ): Call<Void>

    @DELETE("users/delete")
    fun deleteUser(): Call<Void>
}
