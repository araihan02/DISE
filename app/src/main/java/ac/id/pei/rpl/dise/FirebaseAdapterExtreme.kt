package ac.id.pei.rpl.dise

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.ArrayList

class FirebaseAdapterExtreme(private val listDataku: ArrayList<FirebaseDataClassView>): RecyclerView.Adapter<FirebaseAdapterExtreme.FirebaseViewHolder>() {
    inner class FirebaseViewHolder(myView: View):RecyclerView.ViewHolder(myView) {
        var tvHari: TextView = myView.findViewById(R.id.tv_hari)
        var tvSarapan: TextView = myView.findViewById(R.id.tv_sarapan)
        var tvMakansiang: TextView = myView.findViewById(R.id.tv_makansiang)
        var tvMakanmalam: TextView = myView.findViewById(R.id.tv_makanmalam)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirebaseViewHolder {
        val viewku: View = LayoutInflater.from(parent.context).inflate(R.layout.extream_item, parent, false)
        return FirebaseViewHolder(viewku)
    }

    override fun onBindViewHolder(holder: FirebaseViewHolder, position: Int) {
        val dataku = listDataku[position]
        holder.tvHari.text = dataku.Hari
        holder.tvSarapan.text = dataku.Sarapan
        holder.tvMakansiang.text = dataku.Makansiang
        holder.tvMakanmalam.text = dataku.Makanmalam
    }

    override fun getItemCount(): Int {
        return listDataku.size
    }
}
