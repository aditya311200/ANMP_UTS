package com.example.uts_160419051.view

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_160419051.R
import com.example.uts_160419051.model.Kuliner
import kotlinx.android.synthetic.main.kuliner_list_item.view.*

class KulinerListAdapter(val kulinerList:ArrayList<Kuliner>): RecyclerView.Adapter<KulinerListAdapter.KulinerViewHolder>() {
    class KulinerViewHolder(var view: View): RecyclerView.ViewHolder(view)

    fun updateKulinerList(newKulinerList: List<Kuliner>) {
        kulinerList.clear()
        kulinerList.addAll(newKulinerList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KulinerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.kuliner_list_item, parent, false)

        return KulinerViewHolder(v)
    }

    override fun onBindViewHolder(holder: KulinerViewHolder, position: Int) {
        holder.view.txtKulinerNama.text = kulinerList[position].nama
        holder.view.txtKulinerBuka.text = kulinerList[position].jam_buka
        holder.view.txtKulinerTutup.text = kulinerList[position].jam_tutup
        holder.view.txtKulinerRating.text = kulinerList[position].rating

        holder.view.btnKulinerDetail.setOnClickListener {
            val action = KulinerListFragmentDirections.actionDetailKulinerFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return kulinerList.size
    }

}