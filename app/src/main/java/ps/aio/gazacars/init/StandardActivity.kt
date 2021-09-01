package ps.aio.gazacars.init

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import ps.aio.gazacars.R
import ps.aio.gazacars.utils.UIUtil


open class StandardActivity : AppCompatActivity() {
    override fun startActivityForResult(intent: Intent, requestCode: Int) {
        UIUtil.closeKeyboard(this)
        super.startActivityForResult(intent, requestCode)
        overridePendingTransition(R.anim.slide_left_out, R.anim.slide_left_in)
    }

    override fun finish() {
        UIUtil.closeKeyboard(this)
        super.finish()
        overridePendingTransition(R.anim.slide_right_out, R.anim.slide_right_in)
    }

    override fun onStop() {
        UIUtil.closeKeyboard(this)
        super.onStop()
        overridePendingTransition(R.anim.slide_right_out, R.anim.slide_right_in)
    }

    override fun onPause() {
        UIUtil.closeKeyboard(this)
        super.onPause()
        overridePendingTransition(R.anim.slide_right_out, R.anim.slide_right_in)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}