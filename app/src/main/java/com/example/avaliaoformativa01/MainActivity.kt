package com.example.avaliaoformativa01

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val list = mutableListOf<Noticia>()
    private var noticiaAtual = 0

    private val mViewHolder = ViewHolder()

    class ViewHolder {
        var imagem: ImageView? = null
        var titulo: TextView? = null
        var texto: TextView? = null
        var data: TextView? = null
        var proximo: Button? = null
        var anterior: Button? = null
    }

    class Noticia(id: Int, titulo: String, texto: String, data: String) {
        var id: Int = 0
        var titulo: String = ""
        var texto: String = ""
        var data: String = ""

        init {
            this.id = id
            this.titulo = titulo
            this.texto = texto
            this.data = data
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mViewHolder.imagem = findViewById<ImageView>(R.id.img_game)
        mViewHolder.titulo = findViewById<TextView>(R.id.tv_newsTitle)
        mViewHolder.texto = findViewById<TextView>(R.id.tv_newsText)
        mViewHolder.data = findViewById<TextView>(R.id.tv_date)
        mViewHolder.proximo = findViewById<Button>(R.id.btn_next)
        mViewHolder.anterior = findViewById<Button>(R.id.btn_previous)

        mViewHolder.proximo!!.setOnClickListener(this)
        mViewHolder.anterior!!.setOnClickListener(this)

        val noticiaAge = Noticia(
            R.drawable.age,
            "Age of Empires 4 está free to play esta semana na Steam",
            "É difícil de acreditar, mas Age of Empires foi lançado em 15 de outubro de 1997, o que significa que está se aproximando rapidamente de seu 25º aniversário. 25 anos de idade! Esse é um grande – o aniversário de prata – e para comemorar, a Relic Entertainment está tornando Age of Empires 4 grátis para jogar por uma semana.",
            "24/07/22"
        )
        val noticiaCiv = Noticia(
            R.drawable.civ,
            "A próxima atualização do Civilization está se preparando para ser grande",
            "Embora sua mecânica simplificada e estilo visual quase Pixar tenham sido inicialmente recebidos com algum ceticismo pelos fãs obstinados da série, a entrada cresceu gradualmente em escopo através de uma infinidade de atualizações de conteúdo gratuitas e lançamentos de DLC. Agora com mais de cinquenta líderes mundiais para jogar, uma série de modos de jogo que vão desde o surpreendentemente estratégico 'Secret Societies' ao modificador 'Apocalypse' sem desculpas e até mesmo um componente multiplayer de battle-royale, Civilization VI pode ficar orgulhoso ao lado de seus antecessores da série muito amados como um sucessor digno.",
            "09/04/2021"
        )
        val noticiaDestiny = Noticia(
            R.drawable.destiny2,
            "Um enorme nerf para um dos exóticos mais poderosos de Destiny 2 ficou de fora das notas de atualização de hoje",
            "Rede Titan, talvez seja hora de pendurar seu chapéu favorito. Após um hotfix lançado para Destiny 2 hoje cedo, os jogadores começaram a perceber que o Loreley Splendor Helm não estava mais funcionando como antes do patch. Na verdade, parecia ter comido um nerf substancial. O texto da vantagem principal do item ainda diz: \"Quando você for gravemente ferido com energia de habilidade de classe completa ou quando lançar uma Barricada, crie uma Mancha Solar em seu local que tenha efeitos de restauração aprimorados.",
            "13/09/2022"
        )
        val noticiaGow = Noticia(
            R.drawable.gow,
            "God Of War Ragnarök recebe trailer de nova história temperamental",
            "O novo trailer está repleto de cenas legais de ação de Dad of War e seu adolescente assustadoramente parecido com Aaron Paul, Atreus, lutando contra harpias, assistindo gigantes águas-vivas voadoras flutuando no horizonte e libertando Tyr, o deus nórdico da guerra, de escravidão. Mas porque esta é a nova série God of War, o trailer não economizou nos personagens lendo Kratos por imundície, chamando-o de falso deus, dizendo que ninguém o adorava e que ele é simplesmente um palhaço bêbado de sangue.",
            "13/09/2022"
        )
        val noticiaGTA = Noticia(
            R.drawable.gtav,
            "Algumas horas com GTA Online no PS5: parece um novo jogo\n",
            "Tendo jogado Grand Theft Auto Online por quase uma década, não acho que você ficará chocado ao saber que recentemente me senti... terminado com o jogo. Embora eu tenha gostado de algumas das atualizações e eventos recentes, meu desejo de passar horas da minha vida no GTA Online praticamente desapareceu. Então eu não tinha certeza do que esperar com as novas portas PS5 e Xbox Series X/S lançadas hoje. Isso realmente mudaria como me sinto todos esses anos depois?",
            "15/03/2022"
        )

        list.add(noticiaAge)
        list.add(noticiaCiv)
        list.add(noticiaGow)
        list.add(noticiaDestiny)
        list.add(noticiaGTA)

        mViewHolder.imagem!!.setImageResource(list[noticiaAtual].id)
        mViewHolder.titulo!!.text = list[noticiaAtual].titulo
        mViewHolder.texto!!.text = list[noticiaAtual].texto
        mViewHolder.data!!.text = list[noticiaAtual].data

    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_next) {
            if (noticiaAtual != 4) {
                mViewHolder.imagem!!.setImageResource(list[noticiaAtual + 1].id)
                mViewHolder.titulo!!.text = list[noticiaAtual + 1].titulo
                mViewHolder.texto!!.text = list[noticiaAtual + 1].texto
                mViewHolder.data!!.text = list[noticiaAtual + 1].data
                noticiaAtual++
            }
        }

        if (v.id == R.id.btn_previous) {
            if (noticiaAtual > 0) {
                mViewHolder.imagem!!.setImageResource(list[noticiaAtual - 1].id)
                mViewHolder.titulo!!.text = list[noticiaAtual - 1].titulo
                mViewHolder.texto!!.text = list[noticiaAtual - 1].texto
                mViewHolder.data!!.text = list[noticiaAtual - 1].data
                noticiaAtual--
            }
        }
    }

}