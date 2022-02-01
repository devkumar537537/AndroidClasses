package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.usermodels.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.StringBuilder

@SuppressLint("SetTextI18n")
class MainActivity : AppCompatActivity() {
//lateinit var textview:TextView
lateinit var apiServices: ApiServices
lateinit var progressbar:ProgressBar
lateinit var recyclerView: RecyclerView
    lateinit var userlist: ArrayList<UserModel>
    lateinit var imagleist:ArrayList<ImageModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // textview =findViewById(R.id.textviewdata)
        recyclerView = findViewById(R.id.userrecyclerview)
        var linearLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = linearLayoutManager
        progressbar= findViewById(R.id.progressbar)
        apiServices = ApiClient.getretrofitlbuilder().create(ApiServices::class.java)


//getpostlist()
        progressbar.visibility= View.VISIBLE
    // getpostwithid(3)
       // getcommentlistwithpostid(3)
getusers()
       // createresource("Testing","This android texting ",45)
    }

    private fun getusers() {

        var list = apiServices.getusers();
        list.enqueue(object : Callback<ArrayList<UserModel>>{
            override fun onResponse(
                call: Call<ArrayList<UserModel>>,
                response: Response<ArrayList<UserModel>>
            ) {
                progressbar.visibility = View.GONE
                if(!response.isSuccessful)
                {
                 //   textview.text = "no response"
                    return
                }


                 userlist = response.body()!!

              //  var stringBuilder = StringBuilder()
               var llist = apiServices.getphotos()
                llist.enqueue(object : Callback<ArrayList<ImageModel>>{
                    override fun onResponse(
                        call: Call<ArrayList<ImageModel>>,
                        response: Response<ArrayList<ImageModel>>
                    ) {
                        progressbar.visibility = View.GONE
                        if(!response.isSuccessful)
                        {
                            //   textview.text = "no response"
                            return
                        }


                        imagleist = response.body()!!


                        var customadapter = CustomUserADapter(userlist,applicationContext,imagleist)
                        recyclerView.adapter = customadapter
                    }

                    override fun onFailure(call: Call<ArrayList<ImageModel>>, t: Throwable) {
                        progressbar.visibility = View.GONE
                    }

                })

                //textview.text = stringBuilder
            }

            override fun onFailure(call: Call<ArrayList<UserModel>>, t: Throwable) {
                progressbar.visibility = View.GONE
               // textview.text ="error ${t.message}"
            }

        })
    }

//    private fun createresource(title: String, body: String, userId: Int) {
//        var  resourccall = apiServices.createresourc(title,userId,body)
//
//        resourccall.enqueue(object : Callback<PostModel>{
//            override fun onResponse(call: Call<PostModel>, response: Response<PostModel>) {
//                progressbar.visibility = View.GONE
//                if(!response.isSuccessful)
//                {
//                    textview.text = "no response"
//                    return
//                }
//
//
//                var item: PostModel? = response.body()
//
//                var stringBuilder = StringBuilder()
//
//               stringBuilder.append(" ID => ${item!!.id}  \n")
//                    stringBuilder.append(" UserId => ${item.title}  \n")
//                    stringBuilder.append(" body => ${item.body}  \n")
//                    stringBuilder.append(" title => ${item.userId}  \n\n")
//
//                textview.text = stringBuilder
//            }
//
//            override fun onFailure(call: Call<PostModel>, t: Throwable) {
//
//
//            }
//
//
//        })
//
//    }

//    private fun getcommentlistwithpostid(postid: Int) {
//        var list = apiServices.getcommentquery(postid)
//        list.enqueue(object : Callback<ArrayList<CommentModel>>{
//            override fun onResponse(
//                call: Call<ArrayList<CommentModel>>,
//                response: Response<ArrayList<CommentModel>>
//            ) {
//
//              progressbar.visibility = View.GONE
//                if(!response.isSuccessful)
//                {
//                    textview.text = "no response"
//                    return
//                }
//
//
//                var userlist: ArrayList<CommentModel>? = response.body()
//
//                var stringBuilder = StringBuilder()
//
//                for(item in userlist!!)
//                {
//                    stringBuilder.append(" ID => ${item.id}  \n")
//                    stringBuilder.append(" UserId => ${item.email}  \n")
//                    stringBuilder.append(" body => ${item.body}  \n")
//                    stringBuilder.append(" title => ${item.name}  \n\n")
//                }
//                textview.text = stringBuilder
//            }
//
//            override fun onFailure(call: Call<ArrayList<CommentModel>>, t: Throwable) {
//
//                progressbar.visibility = View.GONE
//                textview.text ="error ${t.message}"
//            }
//
//        })
//
//    }

//    private fun getpostwithid(id:Int) {
//        var postcall=  apiServices.getpostwithid(id)
//        postcall.enqueue(object :Callback<PostModel>{
//            override fun onResponse(call: Call<PostModel>, response: Response<PostModel>) {
//                progressbar.visibility= View.GONE
//                if(!response.isSuccessful)
//                {
//                    textview.text = "no response"
//                    return
//                }
//
//
//                var item:PostModel? = response.body()
//
//                var stringBuilder = StringBuilder()
//
//
//                    stringBuilder.append(" ID => ${item!!.id}  \n")
//                    stringBuilder.append(" UserId => ${item.userId}  \n")
//                    stringBuilder.append(" body => ${item.body}  \n")
//                    stringBuilder.append(" title => ${item.title}  \n\n")
//
//                textview.text = stringBuilder
//            }
//
//            override fun onFailure(call: Call<PostModel>, t: Throwable) {
//progressbar.visibility = View.GONE
//                textview.text ="error ${t.message}"
//            }
//
//        })
//    }

//    private fun getpostlist() {
//
//        var arraylistcall = apiServices.getpostlist()
//        arraylistcall.enqueue(object :Callback<ArrayList<PostModel>>{
//            override fun onResponse(
//                call: Call<ArrayList<PostModel>>,
//                response: Response<ArrayList<PostModel>>
//            ) {
//                if(!response.isSuccessful)
//                {
//                    textview.text = "no response"
//                    return
//                }
//
//
//                var userlist: ArrayList<PostModel>? = response.body()
//
//                var stringBuilder = StringBuilder()
//
//                for(item in userlist!!)
//                {
//                    stringBuilder.append(" ID => ${item.id}  \n")
//                    stringBuilder.append(" UserId => ${item.userId}  \n")
//                    stringBuilder.append(" body => ${item.body}  \n")
//                    stringBuilder.append(" title => ${item.title}  \n\n")
//                }
//                textview.text = stringBuilder
//            }
//
//
//            override fun onFailure(call: Call<ArrayList<PostModel>>, t: Throwable) {
//                textview.text ="error ${t.message}"
//            }
//
//
//        })
//    }
}