package com.example.ritaflix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvMain: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // lista de filmes
        val mainItems = mutableListOf<MainItem>()
        mainItems.add(
            MainItem(
                id = 1,
                drawableID = R.drawable.img_guardians_galaxy,
                textNameFilme = R.string.guardians_of_the_galaxyaum,
                textNameDirector = R.string.name_director_guardians_of_the_galaxyaum,
                textTimeFilme = R.string.time_guardians_of_the_galaxyaum,
                textImb = R.string.imb_guardians_of_the_galaxyaum
            )
        )
        mainItems.add(
            MainItem(
                id = 2,
                drawableID = R.drawable.img_spider_man_no_way_home,
                textNameFilme = R.string.spider_man_no_way_home,
                textNameDirector = R.string.name_director_spider_man_no_way_home,
                textTimeFilme = R.string.time_spider_man_no_way_home,
                textImb = R.string.imb_spider_man_no_way_home
            )
        )
        mainItems.add(
            MainItem(
                id = 3,
                drawableID = R.drawable.img_doctor_strange_in_the_multiverse_of_madness_poster,
                textNameFilme = R.string.Doctor_Strange_in_the_Multiverse_of_Madness,
                textNameDirector = R.string.name_director_Doctor_Strange_in_the_Multiverse_of_Madness,
                textTimeFilme = R.string.time_Doctor_Strange_in_the_Multiverse_of_Madness,
                textImb = R.string.imb_Doctor_Strange_in_the_Multiverse_of_Madness
            )
        )
        mainItems.add(
            MainItem(
                id = 4,
                drawableID = R.drawable.img_avengers_infinity_war,
                textNameFilme = R.string.Avengers_Infinity_War,
                textNameDirector = R.string.name_director_Avengers_Infinity_War,
                textTimeFilme = R.string.time_Avengers_Infinity_War,
                textImb = R.string.imb_Avengers_Infinity_War
            )
        )
        mainItems.add(
            MainItem(
                id = 5,
                drawableID = R.drawable.img_avengers_endgame,
                textNameFilme = R.string.Avengers_Endgame,
                textNameDirector = R.string.name_director_Avengers_Endgame,
                textTimeFilme = R.string.time_Avengers_Endgame,
                textImb = R.string.imb_Avengers_Endgame
            )
        )

        // classe que diz qual o layout
        // cria celula de lista
        val adapter = MainAdapter(mainItems) { id ->
            val intent = Intent(this, InfoActivity::class.java)
            intent.putExtra("filmId", id) // Passa o ID do filme clicado para a infoActivity
            startActivity(intent)
        }

        rvMain = findViewById(R.id.rv_main)
        // recebe o adaptador
        rvMain.adapter= adapter
        // faz com que os componentes funciuonem de cima pra baixo
        rvMain.layoutManager = LinearLayoutManager(this)


    }

    // classe para administrar a recyclerview e suas celulas
    // passamos a lista para dentro do adapter
    private inner class MainAdapter(
        private val mainItems: List<MainItem>,
        private val onItemClickListener: (Int) -> Unit,
    ) : RecyclerView.Adapter<MainAdapter.MainViewHolder>(){

        // qual layout xml da celula especifica
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            val view = layoutInflater.inflate(R.layout.main_item, parent, false)
            return MainViewHolder(view)
        }

        // dispara sempre que houver uma rlagem an tela e for nescessário trcar o conteúdo da celula
        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            // vamos pegar o a posição dos elementos para elterar o texto
            val itemCurrent = mainItems[position]
            holder.bind(itemCurrent)
        }

        // retorna um inteiro que informa quantas celulas a listagem terá
        override fun getItemCount(): Int {
            return mainItems.size
        }

        // classe da celula em si
        private inner class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            // pega o valor e altera o conteudo
            fun bind(item: MainItem){
                val img: ImageView = itemView.findViewById(R.id.img_banner)
                val title: TextView = itemView.findViewById(R.id.text_name_filme)
                val director: TextView = itemView.findViewById(R.id.name_director)
                val time: TextView = itemView.findViewById(R.id.text_time_hours)
                val imb: TextView= itemView.findViewById(R.id.text_imb)
                val container: ConstraintLayout = itemView.findViewById(R.id.constraint_container)

                // adiconando a imagem/texto do arquivo da lista
                img.setImageResource(item.drawableID)
                title.setText(item.textNameFilme)
                director.setText(item.textNameDirector)
                time.setText(item.textTimeFilme)
                imb.setText(item.textImb)

                container.setOnClickListener {
                    onItemClickListener.invoke(item.id)
                }
            }
        }
    }
}