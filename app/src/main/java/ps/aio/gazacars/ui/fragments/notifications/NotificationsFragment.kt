package ps.aio.gazacars.ui.fragments.notifications

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ps.aio.gazacars.R
import ps.aio.gazacars.databinding.FragmentNotificationsBinding
import ps.aio.gazacars.ui.adapters.AdapterHomeRv
import ps.aio.gazacars.ui.fragments.home.HomeViewModel


class NotificationsFragment : Fragment() {

    private lateinit var fragmentNotificationsBinding: FragmentNotificationsBinding
    private var notificationsViewModel:NotificationsViewModel?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentNotificationsBinding=FragmentNotificationsBinding.inflate(inflater, container, false)
        return fragmentNotificationsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notificationsViewModel = ViewModelProvider.NewInstanceFactory().create(NotificationsViewModel::class.java)
        notificationsViewModel?.getNotificationsFromDB(R.raw.notifications,view.context)

        val notificationAdapter=AdapterHomeRv()
        notificationAdapter.setViewType(4)
        fragmentNotificationsBinding.adapter=notificationAdapter
        notificationsViewModel?.notificationsModel?.observe(requireActivity(),
        Observer {
            notificationAdapter.setNotiList(it)
        })

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NotificationsFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}