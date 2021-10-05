package com.example.pmm_33pooherenciaclasesabstractas_serranocanoruben_as

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pmm_33pooherenciaclasesabstractas_serranocanoruben_as.databinding.ActivityProblemaPropuestoBinding

class ProblemaPropuesto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_problema_propuesto)

        val binding = ActivityProblemaPropuestoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cajaAhorro = CajaAhorro("Juan",3102.73)
        val plazoFijo = PlazoFijo("Luis",1000.0,180,1.2)

        binding.tvCuenta0.text = cajaAhorro.toString()
        binding.tvCuenta1.text = plazoFijo.toString()

    }
}

abstract class Cuenta(val nombreTitular:String, val monto:Double){
    abstract var tipoCuenta:String
    abstract override fun toString(): String
}
class CajaAhorro(nombreTitular: String,monto: Double):Cuenta(nombreTitular,monto){
    override var tipoCuenta = "Ahorro"
    override fun toString(): String {
        return "Tipo de cuenta: ${tipoCuenta}\nTitular: $nombreTitular \nMonto: $monto"
    }
}
class PlazoFijo(nombreTitular: String,monto: Double, val plazo:Int, val intereses:Double):Cuenta(nombreTitular,monto){
    override var tipoCuenta = "Plazo fijo"
    fun expectativaInteres():Double{
        return (monto*intereses*(plazo.toDouble()/360.0))
    }
    override fun toString(): String {
        return "Tipo de cuenta: ${tipoCuenta}\nTitular: $nombreTitular \nMonto: $monto" +
                "\nExpectativa de interés generado: ${expectativaInteres()}\nPlazo: $plazo"
    }
}
