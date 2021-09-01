package ps.aio.gazacars.ui.fragments.more

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ps.aio.gazacars.R
import ps.aio.gazacars.databinding.FragmentMoreBinding
import ps.aio.gazacars.ui.adapters.AdapterMore
import ps.aio.gazacars.ui.fragments.home.HomeViewModel

class MoreFragment : Fragment() {
    private lateinit var fragmentPopularBinding: FragmentMoreBinding
    private lateinit var homeModel: HomeViewModel
    var FRAGMENT_TYPE:Int=0
    val POP_TYPE:Int=1
    val LATEST_TYPE:Int=2
    val CON_TYPE:Int=3


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            FRAGMENT_TYPE = it.getInt("type")
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        fragmentPopularBinding= FragmentMoreBinding.inflate(inflater,container,false)
        return fragmentPopularBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeModel = ViewModelProvider.NewInstanceFactory().create(HomeViewModel::class.java)
        homeModel.getCarsFromDB(R.raw.cars,view.context)

        when(FRAGMENT_TYPE){
            POP_TYPE->{
                val popAdapter=AdapterMore()
                popAdapter.setHolderType(AdapterMore.POP_TYPE)
                fragmentPopularBinding.popAdapter=popAdapter
                homeModel.cars.observe(requireActivity(), Observer {
                    popAdapter.setList(it)
                })
            }
            LATEST_TYPE->{
                val latestAdapter=AdapterMore()
                latestAdapter.setHolderType(AdapterMore.LATEST_TYPE)
                fragmentPopularBinding.popAdapter=latestAdapter
                homeModel.cars.observe(requireActivity(), Observer {
                    latestAdapter.setList(it)
                })
            }
            CON_TYPE->{
                val conAdapter=AdapterMore()
                conAdapter.setHolderType(AdapterMore.CON_TYPE)
                fragmentPopularBinding.popAdapter=conAdapter
                homeModel.cars.observe(requireActivity(), Observer {
                    conAdapter.setList(it)
                })
            }
        }
    }

}