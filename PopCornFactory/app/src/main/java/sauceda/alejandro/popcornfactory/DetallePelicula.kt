package sauceda.alejandro.popcornfactory

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

        if (bundle != null) {
            findViewById<android.widget.ImageView>(R.id.iv_pelicula_imagen).setImageResource(bundle.getInt("header"))
            findViewById<android.widget.TextView>(R.id.tv_nombre_pelicula).setText(bundle.getString("titulo"))
            findViewById<android.widget.TextView>(R.id.tv_pelicula_desc).setText(bundle.getString("sinopsis"))

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}