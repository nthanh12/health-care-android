package com.example.healthcare2.data.api;

import androidx.annotation.Nullable;

import com.example.healthcare2.data.model.Comment;
import com.example.healthcare2.data.model.Doctor;
import com.example.healthcare2.data.model.Like;
import com.example.healthcare2.data.model.Medicine;
import com.example.healthcare2.data.model.Post;
import com.example.healthcare2.data.model.Rating;
import com.example.healthcare2.data.model.User;
import com.example.healthcare2.data.model.Work;

import java.util.Date;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RestApiService {
    @GET("userList")
    Call<List<User>> getUserList();

    @GET("doctor/{idUser}")
    Call<Doctor> getDoctor(@Path("idUser") int idUser);
//  Detail Medicine
    @GET("medicine/{idMedicine}")
    Call<Medicine> getMedicine(@Path("idMedicine") int idMedicine);
    @GET("numAllCommentMedicine/{idMedicine}")
    Call<Integer> getNumAllCommentMedicine(@Path("idMedicine") int idMedicine);
    @GET("commentMedicine/{idMedicine}")
    Call<List<Comment>> getCommentMedicine(@Path("idMedicine") int idMedicine);
    @GET("ratingCommentMedicine/{idMedicine}")
    Call<List<Rating>> getRatingCommentMedicine(@Path("idMedicine") int idMedicine);

    @POST("addCommentMedicine")
    Call<ResponseBody> addCommentMedicine(@Body Comment comment);
    @POST("addRatingMedicine")
    Call<ResponseBody> addRatingMedicine(@Body Rating rating);
    @GET("isCommentMedicine/{idMedicine}/{idUser}")
    Call<Integer> getIsCommentMedicine(@Path("idMedicine") int idMedicine, @Path("idUser") int idUser);
//  Medicine
    @GET("medicineList")
    Call<List<Medicine>> getMedicineList();
//  User
    @POST("/addUser")
    Call<ResponseBody> addUser(@Body User user);
    @GET("getUser/{email}")
    Call<User> getUser(@Path("email") String email);
//  Post
    @GET("/numPostUser/{idUser}")
    Call<Integer> getNumPostUser(@Path("idUser") int idUser);
    @GET("listNumPostDoctor")
    Call<List<Integer>> getListNumPostDoctor();
    @GET("listPost")
    Call<List<Post>> getListPost();
//  Like
    @GET("likeMedicine/{idMedicine}/{email}")
    Call<Integer> getIsLikeMedicine(@Path("idMedicine") int idMedicine, @Path("email") String email);
    @POST("addLike")
    Call<ResponseBody> addLike(@Body Like like);
    @POST("deleteLike")
    Call<ResponseBody> deleteLike(@Body Like like);
//  Notification
    @GET("listCommentNotification/{idUser}")
    Call<List<Comment>> getListCommentNotification(@Path("idUser") int idUser);
//  Doctor
    @GET("listDoctor")
    Call<List<Doctor>> getListDoctor();
//  Work
    @GET("listWorkByDate/{date}")
    Call<List<Work>> getListWorkByDate(@Path("date") String date);
    @GET("listWorkToday")
    Call<List<Work>> getListWorkToday();
    @POST("updateIsCheckWork")
    Call<ResponseBody> updateIsCheckWork(@Body Work work);
}
