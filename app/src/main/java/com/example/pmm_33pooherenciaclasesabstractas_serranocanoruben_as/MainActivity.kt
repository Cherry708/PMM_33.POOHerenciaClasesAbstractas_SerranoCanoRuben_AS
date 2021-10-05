package com.example.pmm_33pooherenciaclasesabstractas_serranocanoruben_as

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pmm_33pooherenciaclasesabstractas_serranocanoruben_as.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val suma = Suma(2,2)
        suma.operar()
        val resta = Resta (3,1)
        resta.operar()

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvSuma10.text = suma.toString()
        binding.tvResta10.text = resta.toString()

    }
}

abstract class Operacion(val valor0:Int,val valor1:Int){
    var operacion = 0
    var resultado = ""
    abstract fun operar()
    abstract override fun toString(): String
}

class Suma(valor0:Int, valor1: Int):Operacion(valor0,valor1){
    override fun operar() {
        operacion = valor0+valor1
    }
    override fun toString(): String {
        resultado = "Suma de $valor0 y $valor1: $operacion"
        return resultado
    }
}

class Resta(valor0: Int,valor1: Int):Operacion(valor0,valor1){
    override fun operar() {
        operacion = valor0-valor1
    }
    override fun toString(): String {
        resultado = "Resta de $valor0 y $valor1: $operacion"
        return resultado
    }
}