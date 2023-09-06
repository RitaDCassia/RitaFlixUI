package com.example.ritaflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val filmId = intent.getIntExtra("filmId", -1) // recupera o id do filme

        val imgFilme: ImageView = findViewById(R.id.img_fundo)
        val textTitleFlime: TextView = findViewById(R.id.text_name_filme)
        val imbFilme: TextView = findViewById(R.id.imb_filme)
        val sinopseFilme: TextView = findViewById(R.id.text_sinopse)

        // configurações especificas com base no id so filme
        when(filmId){
            1 -> {
                imgFilme.setImageResource(R.drawable.img_fund_guardians_galaxy)
                textTitleFlime.setText(R.string.guardians_of_the_galaxyaum)
                imbFilme.setText(R.string.imb_guardians_of_the_galaxyaum)
                sinopseFilme.setText(R.string.sinopse_guardians_of_the_galaxyaum)
            }
            2 -> {
                imgFilme.setImageResource(R.drawable.img_fund_spaider_man)
                textTitleFlime.setText(R.string.spider_man_no_way_home)
                imbFilme.setText(R.string.imb_spider_man_no_way_home)
                sinopseFilme.setText(R.string.sinopsespider_man_no_way_home)
            }
            3 -> {
                imgFilme.setImageResource(R.drawable.img_fund_doctor_stranger)
                textTitleFlime.setText(R.string.Doctor_Strange_in_the_Multiverse_of_Madness)
                imbFilme.setText(R.string.imb_Doctor_Strange_in_the_Multiverse_of_Madness)
                sinopseFilme.setText(R.string.sinopse_Doctor_Strange_in_the_Multiverse_of_Madness)
            }
            4 -> {
                imgFilme.setImageResource(R.drawable.img_fund_aevangers_infinity_war)
                textTitleFlime.setText(R.string.Avengers_Infinity_War)
                imbFilme.setText(R.string.imb_Avengers_Infinity_War)
                sinopseFilme.setText(R.string.sinopse_Avengers_Infinity_War)
            }
            5 -> {
                imgFilme.setImageResource(R.drawable.img_fund_aevangers_infinity_war)
                textTitleFlime.setText(R.string.Avengers_Infinity_War)
                imbFilme.setText(R.string.imb_Avengers_Infinity_War)
                sinopseFilme.setText(R.string.sinopse_Avengers_Infinity_War)
            }
        }

    }
}