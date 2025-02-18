package sauceda.alejandro.popcornfactory

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_pelicula)

        var bundle = intent.extras
        var ns = 0
        var id = -1
        var titulo = ""

        if (bundle != null) {
            findViewById<android.widget.ImageView>(R.id.iv_pelicula_imagen).setImageResource(bundle.getInt("header"))
            findViewById<android.widget.TextView>(R.id.tv_nombre_pelicula).setText(bundle.getString("titulo"))
            findViewById<android.widget.TextView>(R.id.tv_pelicula_desc).setText(bundle.getString("sinopsis"))

            ns = bundle.getInt("numberSeats")
            id = bundle.getInt("pos")
            titulo = bundle.getString("titulo")!!
            findViewById<android.widget.TextView>(R.id.seatsLeft).setText("$ns seats available")
        }

        var btn_comprar = findViewById<android.widget.Button>(R.id.btn_comprar)

        btn_comprar.setOnClickListener{
            var intento = Intent(this,SeatSelection::class.java)
            this.startActivity(intento)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}