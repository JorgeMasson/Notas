package masson.reynoso.notas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.lang.Exception
import java.io.File as File

class AdaptadorNotas: BaseAdapter {
    var context: Context
    var notas = ArrayList<Nota>()

    constructor(context: Context, notas: ArrayList<Nota>) {
        this.context = context
        this.notas = notas
    }

    override fun getCount(): Int {
        return notas.size
    }

    override fun getItem(position: Int): Any {
        return notas[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var inflador = LayoutInflater.from(context)
        var vista = inflador.inflate(R.layout.nota_layout, null)
        var nota = notas[position]

        val tv_titulo_det: TextView = vista.findViewById(R.id.tv_titulo_det)
        val tv_contenido_det: TextView = vista.findViewById(R.id.tv_contenido_det)
        val btn_borrar: ImageView = vista.findViewById(R.id.btn_borrar)

        btn_borrar.setOnClickListener {
            eliminar(nota.titulo)
            notas.remove(nota)
            this.notifyDataSetChanged()
        }

        return vista
    }

    private fun eliminar(titulo: String) {
        if (titulo == "") {
            Toast.makeText(context, "Error: título vacío", Toast.LENGTH_SHORT).show()
        } else {
            try {
                val archivo = File(ubicacion(), titulo + ".txt")
                archivo.delete()

                Toast.makeText(context, "Se eliminó el archivo", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(context, "Error al eliminar el archivo", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun ubicacion(): String {
        val album = File(context?.getExternalFilesDir(null), "notas")
        if (!album.exists()) {
            album.mkdir()
        }
        return album.absolutePath
    }

}