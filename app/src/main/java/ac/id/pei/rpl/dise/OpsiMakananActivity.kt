package ac.id.pei.rpl.dise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.google.firebase.database.FirebaseDatabase

class OpsiMakananActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opsimakanan)

        var btnExtreme: LinearLayout = findViewById(R.id.extreme)
        var btnSeharihari: LinearLayout = findViewById(R.id.seharihari)

        btnSeharihari.setOnClickListener {
            val intent = Intent(this, MakananActivity::class.java)
            startActivity(intent)
        }
        btnExtreme.setOnClickListener {
            val intent = Intent(this, ExtremeActivity::class.java)
            startActivity(intent)
        }
    }
}