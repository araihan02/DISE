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

class FirebaseAdapterOlahraga(private val listDataku: ArrayList<FirebaseDataClassView>): RecyclerView.Adapter<FirebaseAdapterOlahraga.FirebaseViewHolder>() {
    inner class FirebaseViewHolder(myView: View):RecyclerView.ViewHolder(myView) {
        var tvOlahraga: TextView = myView.findViewById(R.id.tv_olahraga)
        var tvWaktu: TextView = myView.findViewById(R.id.tv_waktu)
        lateinit var ref: DatabaseReference
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirebaseViewHolder {
        val viewku: View = LayoutInflater.from(parent.context).inflate(R.layout.olahraga_item, parent, false)
        return FirebaseViewHolder(viewku)
    }

    override fun onBindViewHolder(holder: FirebaseViewHolder, position: Int) {
        val dataku = listDataku[position]
        holder.tvOlahraga.text = dataku.Olahraga
        holder.tvWaktu.text = dataku.Waktu
        holder.ref = FirebaseDatabase.getInstance().getReference("Olahraga").child(dataku.uid)

    }

    override fun getItemCount(): Int {
        return listDataku.size
    }
}
