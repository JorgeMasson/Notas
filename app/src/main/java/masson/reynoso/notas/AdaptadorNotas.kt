package masson.reynoso.notas

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class AdaptadorNotas: BaseAdapter {
    lateinit var context: Context
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
        TODO("Not yet implemented")
    }

}