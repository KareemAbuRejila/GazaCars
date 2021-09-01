package ps.aio.gazacars.ui.fragments.cars

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import ps.aio.gazacars.R
import ps.aio.gazacars.databinding.FragmentCarsBinding
import ps.aio.gazacars.models.CarModel
import ps.aio.gazacars.ui.adapters.AdapterMore


class CarsFragment : Fragment() {
    private lateinit var fragmentCarsBinding: FragmentCarsBinding
    private var myGalleryViewModel:MyGalleryViewModel?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
        if (myGalleryViewModel==null){
            myGalleryViewModel=ViewModelProvider.NewInstanceFactory().create(MyGalleryViewModel::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentCarsBinding= FragmentCarsBinding.inflate(inflater, container, false)
        return fragmentCarsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val carsAdapter=AdapterMore()
        carsAdapter.setHolderType(AdapterMore.GALLERY_TYPE)
        fragmentCarsBinding.adapter=carsAdapter
//        myGalleryViewModel?.salesCars?.observe(requireActivity(), Observer {
//            carsAdapter.setList(it)
//        })
        fragmentCarsBinding.myGalleryTablayout.selectTab(fragmentCarsBinding.myGalleryTablayout.getTabAt(0))
        fragmentCarsBinding.myGalleryTablayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0->{
                        myGalleryViewModel?.getCarsFromDB(R.raw.cars,view.context)
                        myGalleryViewModel?.salesCars?.observe(requireActivity(), Observer {
                            carsAdapter.setList(it)
                        })
                    }
                    else->{
                        myGalleryViewModel?.getCarsFromDB(R.raw.cars,view.context)
                        myGalleryViewModel?.salesCars?.observe(requireActivity(), Observer {
                            carsAdapter.setList(it)
                        })
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                return
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                return
            }

        })
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CarsFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}