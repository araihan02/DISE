package ac.id.pei.rpl.dise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class BmiActivity : AppCompatActivity() {
    lateinit var height : EditText
    lateinit var weight : EditText
    lateinit var hasil : TextView
    lateinit var btn_send : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)
        btn_send = findViewById(R.id.send)
        weight = findViewById(R.id.berat)
        height = findViewById(R.id.tinggi)
        hasil = findViewById(R.id.hasil)


//        var hasil="Berat badan idealmu 90 'kamu obesitas'"

        btn_send.setOnClickListener {
            val h = (height.text).toString().toFloat() /100
            val w = weight.text.toString().toFloat()
            val res = w/(h*h)
            hasil.text = "%.2f".format(res)
            val ganti=hasil.text.toString().toFloat()
            if (ganti<=18){
                val x="Berat badan idealmu $ganti 'kamu kurus'"
                val bundle = Bundle()
                bundle.putString("hasil",x)
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }else if(ganti>18 && ganti<=25){
                val x="Berat badan idealmu $ganti 'kamu normal'"
                val bundle = Bundle()
                bundle.putString("hasil",x)
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }else if(ganti>25 && ganti<=27){
                val x="Berat badan idealmu $ganti 'kamu kegemukan'"
                val bundle = Bundle()
                bundle.putString("hasil",x)
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }else{
                val x="Berat badan idealmu $ganti 'kamu obesitas'"
                val bundle = Bundle()
                bundle.putString("hasil",x)
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }

        }

    }
}