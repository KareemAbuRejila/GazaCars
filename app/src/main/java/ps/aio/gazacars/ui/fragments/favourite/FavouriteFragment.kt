package ps.aio.gazacars.ui.fragments.favourite

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import ps.aio.gazacars.R
import ps.aio.gazacars.databinding.FavouriteFragmentBinding
import ps.aio.gazacars.ui.adapters.AdapterMore
import ps.aio.gazacars.ui.fragments.home.HomeViewModel

class FavouriteFragment : Fragment() {
    private lateinit var fragmentFavouriteFragmentBinding: FavouriteFragmentBinding

    companion object {
        fun newInstance() = FavouriteFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        fragmentFavouriteFragmentBinding=FavouriteFragmentBinding.inflate(inflater, container, false)
        return fragmentFavouriteFragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        viewModel = ViewModelProvider.NewInstanceFactory().create(HomeViewModel::class.java)
        viewModel.getCarsFromDB(R.raw.cars,view?.context!!)

        val popAdapter= AdapterMore()
        popAdapter.setHolderType(AdapterMore.POP_TYPE)
        fragmentFavouriteFragmentBinding.favouriteAdapter=popAdapter
        viewModel.cars.observe(requireActivity(), Observer {
            popAdapter.setList(it)
        })
    }

}