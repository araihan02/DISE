package ac.id.pei.rpl.dise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddActivity : AppCompatActivity() {
    lateinit var btnSimpan: Button
    lateinit var btnBatal: Button
    lateinit var tnama: EditText
    lateinit var tsarapan: EditText
    lateinit var tmakansiang: EditText
    lateinit var tmakanmalam: EditText
    lateinit var ref: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        declaration()
        myfunction()
    }
    fun declaration(){
        tnama = findViewById(R.id.tnama)
        tsarapan = findViewById(R.id.tsarapan)
        tmakansiang = findViewById(R.id.tmakansiang)
        tmakanmalam = findViewById(R.id.tmakanmalam)
        btnSimpan = findViewById(R.id.simpan)
        btnBatal = findViewById(R.id.batal)
        ref = FirebaseDatabase.getInstance().getReference("Laporan")
    }
    fun myfunction(){
        val pindah = Intent(this, LaporanActivity::class.java)
        val arrayKu = FirebaseDataClassView()
        btnSimpan.setOnClickListener {
            arrayKu.Nama = tnama.text.toString()
            arrayKu.Sarapan = tsarapan.text.toString()
            arrayKu.Makansiang = tmakansiang.text.toString()
            arrayKu.Makanmalam = tmakanmalam.text.toString()
            val taskPush = ref.push()
            taskPush.setValue(arrayKu)
            startActivity(pindah)
        }
        btnBatal.setOnClickListener {
            startActivity(pindah)
        }
    }
}