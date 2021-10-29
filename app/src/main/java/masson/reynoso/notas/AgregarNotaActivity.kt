package masson.reynoso.notas

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.jar.Manifest


class AgregarNotaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_nota)

        val btn_guardar: Button = findViewById(R.id.btn_guardar)

        btn_guardar.setOnClickListener {
            guardar_nota()
        }

    }

    fun guardar_nota(){
        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), 235)
        } else {
            guardar()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            235 -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    guardar()
                } else {
                    Toast.makeText(this, "Error, permisos denegados", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    public fun guardar() {
        var titulo: EditText = findViewById(R.id.et_titulo)
        var cuerpo: EditText = findViewById(R.id.et_contenido)

        titulo.text.toString()
        cuerpo.text.toString()
    }

}