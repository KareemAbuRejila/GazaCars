package ps.aio.gazacars.ui.dialogs

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ps.aio.gazacars.R
import ps.aio.gazacars.databinding.DialogChangePasswordBinding
import ps.aio.gazacars.databinding.DialogFilterBinding
import java.util.regex.Pattern


class FilterDialog : BottomSheetDialogFragment() {
    private lateinit var dialogFilterBinding: DialogFilterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.Theme_GazaCars_FilterDialog)
        setHasOptionsMenu(true)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        dialogFilterBinding= DialogFilterBinding.inflate(inflater, container, false)
        (requireActivity() as AppCompatActivity).setSupportActionBar(dialogFilterBinding.filterToolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayShowCustomEnabled(true)

        return dialogFilterBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId==android.R.id.home){
            dismiss()
            true
        }else
         super.onOptionsItemSelected(item)
    }
}