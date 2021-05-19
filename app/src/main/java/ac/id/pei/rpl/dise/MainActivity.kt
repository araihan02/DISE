package ac.id.pei.rpl.dise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tampilhasil: TextView = findViewById(R.id.tampilhasil)
        val btnlaporan: LinearLayout = findViewById(R.id.laporan)
        val btnmakanan: LinearLayout = findViewById(R.id.makanan)
        val btnolahraga: LinearLayout = findViewById(R.id.olahraga)

        val bundle = intent.extras
        tampilhasil.setText(bundle?.getString("hasil"))

        btnlaporan.setOnClickListener {
            val intent = Intent(this, LaporanActivity::class.java)
            startActivity(intent)
        }
        btnmakanan.setOnClickListener {
            val intent = Intent(this, OpsiMakananActivity::class.java)
            startActivity(intent)
        }
        btnolahraga.setOnClickListener {
            val intent = Intent(this, OlahragaActivity::class.java)
            startActivity(intent)
        }
    }
}