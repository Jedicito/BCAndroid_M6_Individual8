package chl.ancud.m6_individual8.presentacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import chl.ancud.m6_individual8.R
import chl.ancud.m6_individual8.databinding.FragmentListaRazasBinding

class ListaRazasFragment : Fragment() {
   lateinit var binding: FragmentListaRazasBinding
   private val razaViewModel: RazaViewModel by activityViewModels()
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
        binding = FragmentListaRazasBinding.inflate(layoutInflater)
        initAdapter()
        razaViewModel.getAllRazas()
        return binding.root
    }

    private fun initAdapter(){
        val adapter = AdapterRazas()
        binding.rvListaRazas.adapter = adapter
        razaViewModel.razasLiveData().observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }


}