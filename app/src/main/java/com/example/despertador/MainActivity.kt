package com.example.despertador


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    //GUARDA DATOS ESTATICOS
    private val sharedPrefFile = "despertador"


    //AVERIGUA HORA ACTUAL
    var dateFormat: SimpleDateFormat = SimpleDateFormat("hh:mm", Locale.getDefault())
    var date = Date()
    var horaActual = dateFormat.format(date)


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //IMPORTA LA HORA INGRESADA A LA VARIABLE
        val minutosingresados = findViewById(R.id.TextMinutos) as TextView

        //IMPORTA LA HORA INGRESADA A LA VARIABLE
        val horaingresada = findViewById(R.id.TextHora) as TextView


        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
        val sharedMinutos = sharedPreferences.getInt("idminutos", 0)
        val sharedHora = sharedPreferences.getInt("idhora", 0)


        //MUESTRA EL VALOR QUE SE GUARDO ANTERIORMENTE EN ARCHIVO ESTATICO
        minutosingresados.setText(sharedMinutos.toString())

        //MUESTRA EL VALOR QUE SE GUARDO ANTERIORMENTE EN ARCHIVO ESTATICO
        horaingresada.setText(sharedHora.toString())







        /////////////////// BOTON ENVIAR ///////////////////////////////////////////

        val boton = findViewById(R.id.BontonActivar) as Button
        boton.setOnClickListener {





            //Convierte valor-id de la caja de texto y luego guarda el valor ingresado
            val id: Int = Integer.parseInt(minutosingresados.text.toString())
            val name: String = minutosingresados.text.toString()
            val editor: SharedPreferences.Editor = sharedPreferences.edit()

            editor.putInt("idminutos", id)
            editor.putString("nameminutos", name)

            editor.apply()
            editor.commit()




            val idh: Int = Integer.parseInt(horaingresada.text.toString())
            val nameh: String = horaingresada.text.toString()
            val editorr: SharedPreferences.Editor = sharedPreferences.edit()
            editorr.putInt("idhora", idh)
            editorr.putString("namehora", nameh)



            editorr.apply()
            editorr.commit()






        }
        /////////////////////////////////////////////////////////////////////////////












    }







}










