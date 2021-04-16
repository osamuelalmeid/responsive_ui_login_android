package com.samuelalmeida.loginfirebase.ui.login

import android.os.Bundle
import android.view.View
import android.widget.ViewFlipper
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.samuelalmeida.loginfirebase.R
import com.samuelalmeida.loginfirebase.databinding.LoginFragmentBinding

class LoginFragment : Fragment(R.layout.login_fragment) {

    private val viewModel: LoginViewModel by viewModels()

    lateinit var binding: LoginFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = LoginFragmentBinding.bind(view)
        binding.apply {

            tabLayout.addTab(tabLayout.newTab().setText("Entrar"))
            tabLayout.addTab(tabLayout.newTab().setText("Nova Conta"))
            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabReselected(tab: TabLayout.Tab?) {/*no action */}
                override fun onTabUnselected(tab: TabLayout.Tab?) {/*no action */}
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    if (tab?.position == 0) {
                        viewFlipper.setInAnimation(requireContext(), R.anim.slide_in_left)
                        viewFlipper.setOutAnimation(requireContext(), R.anim.slide_out_right)
                        viewFlipper.showPrevious()
                    } else if (tab?.position == 1) {
                        viewFlipper.setInAnimation(requireContext(), R.anim.slide_in_right)
                        viewFlipper.setOutAnimation(requireContext(), R.anim.slide_out_left)
                        viewFlipper.showNext()
                    }
                }
            })

            setAnimation(buttonLoginFacebook, null, null, 400)
            setAnimation(buttonLoginGoogle, null, null, 600)
            setAnimation(buttonLoginTwitter, null, null,800)
            setAnimation(null, viewFlipper, null, 700)
            setAnimation(null, null, tabLayout, 400)

        }
    }

    private fun setAnimation(button: FloatingActionButton?, viewFlipper: ViewFlipper?, tabLayout: TabLayout?, startDelay: Long) {
        button?.apply {
            translationY = 300F
            alpha = 0F
            animate().translationY(0F).alpha(1F).setDuration(1000).setStartDelay(startDelay).start()
        }
        viewFlipper?.apply {
            translationX = 800F
            alpha = 0F
            animate().translationX(0F).alpha(1F).setDuration(800).setStartDelay(startDelay).start()
        }
        tabLayout?.apply {
            translationX = 800F
            alpha = 0F
            animate().translationX(0F).alpha(1F).setDuration(600).setStartDelay(startDelay).start()
        }
    }
}