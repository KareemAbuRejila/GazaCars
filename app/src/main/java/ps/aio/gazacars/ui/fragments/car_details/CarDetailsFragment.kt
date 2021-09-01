package ps.aio.gazacars.ui.fragments.car_details

import android.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import ps.aio.gazacars.R
import ps.aio.gazacars.databinding.FragmentCarDetailsBinding
import ps.aio.gazacars.models.CarModel
import ps.aio.gazacars.ui.adapters.AdapterIntroViewPager2
import ps.aio.gazacars.ui.dialogs.CarImagesDialog

class CarDetailsFragment : DialogFragment {

    private lateinit var carDetailsFragmentBinding: FragmentCarDetailsBinding
    private val TAG=CarDetailsFragment::class.simpleName
    private var carModel:CarModel?=null

    companion object {
        fun newInstance() = CarDetailsFragment()
    }
    constructor():super()
    constructor(carModel: CarModel):super(){
        this.carModel=carModel
    }

    private lateinit var viewModel: CarDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.Theme_GazaCars_CarDetailsDialogTheme)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        carDetailsFragmentBinding= FragmentCarDetailsBinding.inflate(inflater,container,false)
        carDetailsFragmentBinding.btnBack.setOnClickListener { dismiss() }
        carDetailsFragmentBinding.carDetailsCarImage.setOnClickListener {
//            if (carModel?.images?.size!!>1)
                showCarImages()
//            else
//                Toast.makeText(requireContext(),getString(R.string.dontanotherimage),Toast.LENGTH_LONG).show()
        }
        return carDetailsFragmentBinding.root
    }

    private fun showCarImages() {
        val carImages=ArrayList<String>()
        carImages.add("https://www.extremetech.com/wp-content/uploads/2019/12/SONATA-hero-option1-764A5360-edit.jpg")
        carImages.add("https://media.wired.com/photos/5d09594a62bcb0c9752779d9/125:94/w_1994,h_1500,c_limit/Transpo_G70_TA-518126.jpg")
        carImages.add("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/bugatti-chiron-pur-sport-106-1582836604.jpg")
        carImages.add("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/bugatti-chiron-pur-sport-106-1582836604.jpg")


        CarImagesDialog(carImages).show(
            (requireActivity() as AppCompatActivity).supportFragmentManager,
            CarImagesDialog::class.simpleName
        )

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CarDetailsViewModel::class.java)
        carDetailsFragmentBinding.carModel=carModel
        carDetailsFragmentBinding.carDetailsContentIn.carModel=carModel
    }

}