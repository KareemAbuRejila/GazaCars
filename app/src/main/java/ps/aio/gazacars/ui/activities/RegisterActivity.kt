package ps.aio.gazacars.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import ps.aio.gazacars.R
import ps.aio.gazacars.databinding.ActivityRegisterBinding
import ps.aio.gazacars.init.StandardActivity

class RegisterActivity : StandardActivity() {
    private val TAG=RegisterActivity::class.simpleName
    private lateinit var activityRegisterBinding: ActivityRegisterBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityRegisterBinding=DataBindingUtil.setContentView(this,R.layout.activity_register)
        setSupportActionBar(activityRegisterBinding.tbRegistration)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar?.setDisplayShowHomeEnabled(true)


    }

    fun goToLoginActivity(view: View) {
        val loginIntent= Intent(this,LoginActivity::class.java)
        startActivity(loginIntent)
    }

}