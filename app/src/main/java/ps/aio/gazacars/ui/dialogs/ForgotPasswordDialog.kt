package ps.aio.gazacars.ui.dialogs

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import ps.aio.gazacars.R
import ps.aio.gazacars.databinding.DialogForgotPasswordBinding
import java.util.regex.Pattern


class ForgotPasswordDialog : DialogFragment() {
    private lateinit var forgotPasswordBinding: DialogForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.Theme_GazaCars_CarDetailsDialogTheme)
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        forgotPasswordBinding= DialogForgotPasswordBinding.inflate(inflater, container, false)
        (requireActivity() as AppCompatActivity).setSupportActionBar(forgotPasswordBinding.forgotPasswordToolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayShowCustomEnabled(true)

        return forgotPasswordBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        forgotPasswordBinding.forgotPasswordBtnSend.setOnClickListener {
//            if (emailValidator(forgotPasswordBinding.edtEmail.toString().trim())){
//                Toast.makeText(forgotPasswordBinding.root.context,"valid email address", Toast.LENGTH_SHORT).show()
                sendEmail()

//            }else{
//                Toast.makeText(forgotPasswordBinding.root.context,"Invalid email address", Toast.LENGTH_SHORT).show()
//
//            }
        }
    }

    private fun sendEmail() {
//        val imageViewSent=layoutInflater.inflate()
//        AlertDialog.Builder(forgotPasswordBinding.root.context)
//            .setTitle(R.string.sent_done)
//            .setMessage(R.string.please_check_yout_email)
//            .setCancelable(false)
//            .setPositiveButton(R.string.ok){ dialog, which->
//                dialog.dismiss()
//            }.create().show()
        EnterCodeDialog().show(
            (requireActivity()).supportFragmentManager, EnterCodeDialog::class.simpleName
        )
    }

    private fun emailValidator(email: String): Boolean {
        val EMAIL_PATTERN =
            "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        val pattern = Pattern.compile(EMAIL_PATTERN)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId==android.R.id.home){
            dismiss()
            true
        }else
         super.onOptionsItemSelected(item)
    }
}