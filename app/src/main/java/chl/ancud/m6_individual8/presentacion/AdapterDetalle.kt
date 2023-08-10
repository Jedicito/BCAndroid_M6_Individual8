package chl.ancud.m6_individual8.presentacion

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import chl.ancud.m6_individual8.data.local.FotosDetalleEntity
import chl.ancud.m6_individual8.databinding.ItemDetallerazaBinding
import coil.load

class AdapterDetalle: RecyclerView.Adapter<AdapterDetalle.DetalleViewHolder>() {
    lateinit var binding: ItemDetallerazaBinding
    private val listaFotosDetalle = mutableListOf<FotosDetalleEntity>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterDetalle.DetalleViewHolder {
        binding = ItemDetallerazaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetalleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterDetalle.DetalleViewHolder, position: Int) {
        val item = listaFotosDetalle[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return listaFotosDetalle.size
    }

    fun setData(fotos: List<FotosDetalleEntity>) {
        this.listaFotosDetalle.clear()
        this.listaFotosDetalle.addAll(fotos)
        notifyDataSetChanged()
    }
    class DetalleViewHolder(val binding: ItemDetallerazaBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FotosDetalleEntity) {
            binding.imgFotoRaza.load(item.ruta)
        }

    }

}