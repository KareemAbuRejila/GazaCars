package ps.aio.gazacars.ui.fragments.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import androidx.fragment.app.Fragment
import ps.aio.gazacars.R
import ps.aio.gazacars.databinding.FragmentAddBinding


class ADDFragment : Fragment() {

    private lateinit var fragmentAddBinding: FragmentAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        fragmentAddBinding= FragmentAddBinding.inflate(inflater, container, false)
        return fragmentAddBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            fragmentAddBinding.scrollAddFragment.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
                if (scrollY==0){
                    fragmentAddBinding.btnAddToSale.visibility=View.GONE
                }
//                if (scrollY==(v.measuredHeight )){
//                    fragmentAddBinding.btnAddToSale.visibility=View.VISIBLE
//                }
                if (scrollY>oldScrollY){
                    fragmentAddBinding.btnAddToSale.visibility=View.VISIBLE
                }
                if (scrollY<oldScrollY){
                    fragmentAddBinding.btnAddToSale.visibility=View.GONE
                }

            }
        }
    }


}