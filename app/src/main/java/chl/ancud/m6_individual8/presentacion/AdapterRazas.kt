package chl.ancud.m6_individual8.presentacion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import chl.ancud.m6_individual8.R
import chl.ancud.m6_individual8.data.local.RazaEntity
import chl.ancud.m6_individual8.data.remote.Raza
import chl.ancud.m6_individual8.databinding.FragmentListaRazasBinding
import chl.ancud.m6_individual8.databinding.ItemRazasBinding

class AdapterRazas: RecyclerView.Adapter<AdapterRazas.ItemRazasViewHolder>() {
    lateinit var binding: ItemRazasBinding
    private val listaItemesRazas = mutableListOf<RazaEntity>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterRazas.ItemRazasViewHolder {
        binding = ItemRazasBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemRazasViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterRazas.ItemRazasViewHolder, position: Int) {
        val raza = listaItemesRazas[position]
        holder.bind(raza)
    }

    override fun getItemCount(): Int {
        return listaItemesRazas.size
    }

    fun setData(razas: List<RazaEntity>) {
        this.listaItemesRazas.clear()
        this.listaItemesRazas.addAll(razas)
        notifyDataSetChanged()
    }
    class ItemRazasViewHolder(val binding: ItemRazasBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(raza: RazaEntity) {
            binding.tvItemNombre.text = raza.raza
            var bundle = Bundle()
            binding.cvItemRaza.setOnClickListener {
                bundle.putString("nombre", raza.raza)
                Navigation.findNavController(binding.root).navigate(R.id.action_listaRazasFragment_to_detalleFragment, bundle)
            }
        }

    }

}