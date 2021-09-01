package ps.aio.gazacars.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import ps.aio.gazacars.R
import ps.aio.gazacars.databinding.ActivityLoginBinding
import ps.aio.gazacars.init.StandardActivity
import ps.aio.gazacars.ui.dialogs.ForgotPasswordDialog

class LoginActivity : StandardActivity() {
    private lateinit var loginBinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding=DataBindingUtil.setContentView(this,R.layout.activity_login)
        setSupportActionBar(loginBinding.tbLogin)
    }

    fun goToRegisterActivity(view: View) {
        val registerIntent=Intent(this,RegisterActivity::class.java)
        startActivity(registerIntent)
    }

    fun login(view: View) {
        val homeIntent=Intent(this,MainActivity::class.java)
        startActivity(homeIntent)
    }

    fun openForgotDialog(view: View) {
        ForgotPasswordDialog().show(
            supportFragmentManager,ForgotPasswordDialog::class.simpleName
        )
    }
}