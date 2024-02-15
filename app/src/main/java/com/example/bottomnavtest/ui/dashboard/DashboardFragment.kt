package com.example.bottomnavtest.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.axiomc.sdk.CockpitServers
import com.axiomc.sdk.CockpitSession
import com.axiomc.sdk.LoyalHelper.loadLoyalHub
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

    _binding = FragmentDashboardBinding.inflate(inflater, container, false)
    val root: View = binding.root

    if (savedInstanceState == null) {
      loadLoyalHub(
        binding.root.id,
        session = CockpitSession("", "65849017", listOf(), {}, {}),
        servers = CockpitServers.AXIOM
      )
    }
    return root
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}