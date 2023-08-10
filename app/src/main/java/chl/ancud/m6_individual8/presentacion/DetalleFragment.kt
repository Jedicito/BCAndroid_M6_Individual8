package chl.ancud.m6_individual8.presentacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import chl.ancud.m6_individual8.R
import chl.ancud.m6_individual8.databinding.FragmentDetalleBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val RAZA = "nombre"
class DetalleFragment : Fragment() {
    private var raza: String? = null
    lateinit var binding: FragmentDetalleBinding
    private val razaViewModel: RazaViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            raza = it.getString(RAZA)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetalleBinding.inflate(layoutInflater)
        setComponentes()
        razaViewModel.getDetalleRaza(raza!!)
        binding.flbVolverListado.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_detalleFragment_to_listaRazasFragment)
        }
        return binding.root
    }

    private fun setComponentes() {
        binding.tvNombreRazaDetalle.text = raza
    }

}