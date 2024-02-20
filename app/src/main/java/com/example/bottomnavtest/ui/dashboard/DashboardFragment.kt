package com.example.bottomnavtest.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.axiomc.sdk.LoyalKit
import com.axiomc.sdk.LoyalKit.loadLoyalHubAsChild
import com.axiomc.sdk.LoyalSession
import com.example.bottomnavtest.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

  private var _binding: FragmentDashboardBinding? = null

  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {

    // ----------------------------------
    // These can be assigned at any point,
    // but always before loading the hub.
    LoyalKit.onBalance = { }
    LoyalKit.onExpiration = { }
    LoyalKit.session = LoyalSession("", "65849017", listOf())
    // ----------------------------------

    _binding = FragmentDashboardBinding.inflate(inflater, container, false)
    val root: View = binding.root

    return root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    if (savedInstanceState == null /* || session has changed */)
      loadLoyalHubAsChild(binding.root.id)
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}