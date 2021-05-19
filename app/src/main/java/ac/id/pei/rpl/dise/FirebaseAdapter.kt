package ac.id.pei.rpl.dise

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.ArrayList

class FirebaseAdapter(private val listDataku: ArrayList<FirebaseDataClassView>): RecyclerView.Adapter<FirebaseAdapter.FirebaseViewHolder>() {
    inner class FirebaseViewHolder(myView: View):RecyclerView.ViewHolder(myView) {
        var tvNama: TextView = myView.findViewById(R.id.tv_nama)
        var tvSarapan: TextView = myView.findViewById(R.id.tv_sarapan)
        var tvMakansiang: TextView = myView.findViewById(R.id.tv_makansiang)
        var tvMakanmalam: TextView = myView.findViewById(R.id.tv_makanmalam)
        lateinit var ref: DatabaseReference
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirebaseViewHolder {
        val viewku: View = LayoutInflater.from(parent.context).inflate(R.layout.laporan_item, parent, false)
        return FirebaseViewHolder(viewku)
    }

    override fun onBindViewHolder(holder: FirebaseViewHolder, position: Int) {
        val dataku = listDataku[position]
        holder.tvNama.text = dataku.Nama
        holder.tvSarapan.text = dataku.Sarapan
        holder.tvMakansiang.text = dataku.Makansiang
        holder.tvMakanmalam.text = dataku.Makanmalam
        holder.ref = FirebaseDatabase.getInstance().getReference("Laporan").child(dataku.uid)
//        holder.btnDel.setOnClickListener{
//            holder.ref.removeValue()
//        }
//        holder.btnEdit.setOnClickListener {
//            val bundle = Bundle()
//            val pindah = Intent(holder.itemView.context, Update::class.java)
//            bundle.putString("uid", dataku.uid)
//            bundle.putString("name", dataku.Nama)
//            bundle.putString("price", dataku.Harga.toInt().toString())
//            pindah.putExtras(bundle)
//            holder.itemView.context.startActivity(pindah)
//        }

    }

    override fun getItemCount(): Int {
        return listDataku.size
    }
}
