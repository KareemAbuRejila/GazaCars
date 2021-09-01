package ps.aio.gazacars.ui.fragments.home

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import ps.aio.gazacars.R
import ps.aio.gazacars.databinding.FragmentHomeBinding
import ps.aio.gazacars.models.CarModel
import ps.aio.gazacars.ui.adapters.AdapterHomeRv
import ps.aio.gazacars.ui.dialogs.FilterDialog
import ps.aio.gazacars.ui.fragments.car_details.CarDetailsFragment

class HomeFragment : Fragment(),AdapterHomeRv.ItemCarListener{
    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    private lateinit var homeModel:HomeViewModel

    private lateinit var appBarConfigurationDrawer: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        retainInstance=true
        fragmentHomeBinding= FragmentHomeBinding.inflate(layoutInflater,container,false)


        return fragmentHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeModel = ViewModelProvider.NewInstanceFactory().create(HomeViewModel::class.java)
        homeModel.getCarsFromDB(R.raw.cars,view.context)

        val popAdapter=AdapterHomeRv()
        popAdapter.setViewType(1)
        fragmentHomeBinding.popAdapter=popAdapter
        homeModel.cars.observe(requireActivity(), Observer {
            popAdapter.setPopList(it)
        })
        popAdapter.setOnItemCarListener(this)

        val latestAdapter=AdapterHomeRv()
        latestAdapter.setViewType(2)
        fragmentHomeBinding.latestAdapter=latestAdapter
        homeModel.cars.observe(requireActivity(), Observer {
            latestAdapter.setLatestList(it)
        })

        val conAdapter=AdapterHomeRv()
        conAdapter.setViewType(3)
        fragmentHomeBinding.conAdapter=conAdapter
        homeModel.cars.observe(requireActivity(), Observer {
            conAdapter.setConList(it)
        })

        fragmentHomeBinding.tvPopularM.setOnClickListener {
            val popBundle=Bundle()
            popBundle.putInt("type",1)
            findNavController().navigate(R.id.action_navigation_home_to_popularFragment,popBundle)
        }
        fragmentHomeBinding.tvLatestM.setOnClickListener {
            val latestBundle=Bundle()
            latestBundle.putInt("type",2)
            findNavController().navigate(R.id.action_navigation_home_to_latestFragment,latestBundle)
        }
        fragmentHomeBinding.tvContractedM.setOnClickListener {
            val conBundle=Bundle()
            conBundle.putInt("type",3)
            findNavController().navigate(R.id.action_navigation_home_to_conFragment,conBundle)
        }
        fragmentHomeBinding.icFilter.setOnClickListener {
            FilterDialog().show(
                (activity as AppCompatActivity).supportFragmentManager,
                FilterDialog::class.simpleName
            )
        }


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.home_drawer_menu,menu)
    }

    override fun onCarClicked(carModel: CarModel) {
        val carDetailsDialog=CarDetailsFragment(carModel)
        carDetailsDialog.show(
            requireActivity()?.supportFragmentManager,
            CarDetailsFragment::class.simpleName
        )
    }
}