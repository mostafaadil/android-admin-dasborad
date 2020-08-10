package io.nasna.app.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import io.nasna.app.R
import io.nasna.app.R.id.login
import io.nasna.app.R.id.register
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject




class AuthenticationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

    }

    fun showLiginUi(view: View) {

    }

    fun showRegisterUi(view: View) {
       // login.setVisibility(View.GONE)
        //register.setVisibility(View.VISIBLE)


    }

    fun getLocation(view: View) {

       // startActivityForResult(intent)
        val intent = Intent(this, MapActivity::class.java)
        startActivity(intent)
    }
    fun LoginMeIn(view: View){
        val s="[{\"id\":98952534,\"name\":\"mostafa\",\"password\":\"09090\",\"phone\":\"09090\",\"created_at\":\"2020-08-07 08:00:41\",\"updated_at\":\"2020-08-07 08:00:41\"}]"
        var  r=JSONArray()

        for (i in 0 until r.length()) {

            try {
                val `object` = r.getJSONObject(i)
                val arr = JSONArray(s)
                val jObj = arr.getJSONObject(0)
                val date = jObj.getString("id")
                if (date!=" "){
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            } catch (e: JSONException) {
                Toast.makeText(this, "" + e, Toast.LENGTH_SHORT).show()
            }

        }

    }


}