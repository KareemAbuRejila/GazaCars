package ps.aio.gazacars.ui.dialogs

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.google.android.material.tabs.TabLayoutMediator
import ps.aio.gazacars.R
import ps.aio.gazacars.databinding.DialogCarImagesBinding
import ps.aio.gazacars.databinding.DialogForgotPasswordBinding
import ps.aio.gazacars.ui.adapters.AdapterIntroViewPager2
import java.util.regex.Pattern


class CarImagesDialog : DialogFragment {
    private lateinit var dialogCarImagesBinding: DialogCarImagesBinding
    private var carImages:List<String>?=null

    constructor(carImages:List<String>):super(){
        this.carImages=carImages
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.Theme_MaterialComponents_Light_DialogWhenLarge)
//        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        dialogCarImagesBinding= DialogCarImagesBinding.inflate(inflater, container, false)
//        (requireActivity() as AppCompatActivity).setSupportActionBar(forgotPasswordBinding.forgotPasswordToolbar)
//        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayShowCustomEnabled(true)

        dialogCarImagesBinding.carImagesClose.setOnClickListener {
            dismiss()
        }
        return dialogCarImagesBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapterIntroViewPager2=AdapterIntroViewPager2(carImages!!)
//        dialogCarImagesBinding.adapter=adapterIntroViewPager2

        dialogCarImagesBinding.carImagesViewPager.adapter=adapterIntroViewPager2
        TabLayoutMediator(dialogCarImagesBinding.carImagesTabIndicator,
            dialogCarImagesBinding.carImagesViewPager) { tab, posstion ->

        }.attach()
    }

}