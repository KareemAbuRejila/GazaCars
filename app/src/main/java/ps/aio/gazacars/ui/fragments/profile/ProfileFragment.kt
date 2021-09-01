package ps.aio.gazacars.ui.fragments.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.DialogFragment
import ps.aio.gazacars.R
import ps.aio.gazacars.databinding.FragmentProfileBinding
import ps.aio.gazacars.ui.dialogs.ChangePasswordDialog
import ps.aio.gazacars.ui.dialogs.ForgotPasswordDialog

class ProfileFragment : Fragment() {
    private lateinit var fragmentProfileBinding: FragmentProfileBinding

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        fragmentProfileBinding=
            FragmentProfileBinding.inflate(inflater, container, false)
        fragmentProfileBinding.tvChpassword.setOnClickListener {
            openChangePasswordDialog()
        }
        return fragmentProfileBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main,menu)
    }

    private fun openChangePasswordDialog(){
        ChangePasswordDialog().show(
            (requireActivity()).supportFragmentManager, ChangePasswordDialog::class.simpleName
        )
    }

}