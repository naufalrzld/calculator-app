package com.example.calculatorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var etBilangan1: EditText
    private lateinit var etBilangan2: EditText
    private lateinit var tvHasil: TextView
    private lateinit var btnTambah: Button
    private lateinit var btnKurang: Button
    private lateinit var btnKali: Button
    private lateinit var btnBagi: Button
    private lateinit var btnRiwayat: Button

    private val histories = arrayListOf<HistoryData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etBilangan1 = findViewById(R.id.et_bil_1)
        etBilangan2 = findViewById(R.id.et_bil_2)
        tvHasil = findViewById(R.id.tv_hasil)
        btnTambah = findViewById(R.id.btn_tambah)
        btnKurang = findViewById(R.id.btn_kurang)
        btnKali = findViewById(R.id.btn_kali)
        btnBagi = findViewById(R.id.btn_bagi)
        btnRiwayat = findViewById(R.id.btn_riwayat)

        btnTambah.setOnClickListener {
            val bilangan1 = etBilangan1.text.toString().toInt()
            val bilangan2 = etBilangan2.text.toString().toInt()
            val hasil = "${bilangan1 + bilangan2}"
            val operasi = "+"

            tvHasil.text = hasil
            saveToHistory(bilangan1, bilangan2, operasi, hasil)
        }

        btnKurang.setOnClickListener {
            val bilangan1 = etBilangan1.text.toString().toInt()
            val bilangan2 = etBilangan2.text.toString().toInt()
            val hasil = "${bilangan1 - bilangan2}"
            val operasi = "-"

            tvHasil.text = hasil
            saveToHistory(bilangan1, bilangan2, operasi, hasil)
        }

        btnKali.setOnClickListener {
            val bilangan1 = etBilangan1.text.toString().toInt()
            val bilangan2 = etBilangan2.text.toString().toInt()
            val hasil = "${bilangan1 * bilangan2}"
            val operasi = "X"

            tvHasil.text = hasil
            saveToHistory(bilangan1, bilangan2, operasi, hasil)
        }

        btnBagi.setOnClickListener {
            val bilangan1 = etBilangan1.text.toString().toInt()
            val bilangan2 = etBilangan2.text.toString().toInt()
            val hasil = "${bilangan1 / bilangan2}"
            val operasi = ":"

            tvHasil.text = hasil
            saveToHistory(bilangan1, bilangan2, operasi, hasil)
        }

        btnRiwayat.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            intent.putParcelableArrayListExtra("histories", histories)
            startActivity(intent)
        }
    }

    private fun saveToHistory(bilangan1: Int, bilangan2: Int, operasi: String, hasil: String) {
        val bilangan = "$bilangan1 $operasi $bilangan2"
        val history = HistoryData(bilangan, hasil)
        histories.add(history)
    }
}