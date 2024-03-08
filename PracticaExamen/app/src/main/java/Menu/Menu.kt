package Menu

import NuevoIMC.IMC
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.practicaexamen.BoardGames
import com.example.practicaexamen.R

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val IMCButton = findViewById<Button>(R.id.btnIrIMCapp)
        IMCButton.setOnClickListener{
            navigateIMCApp()
        }
        val BoardGameButtom = findViewById<Button>(R.id.btnIrBoardGame)
        BoardGameButtom.setOnClickListener{
            navigateBoardGames()
        }
    }

    private fun navigateBoardGames() {
        var intent = Intent(this, BoardGames::class.java)
        startActivity(intent)

    }

    private fun navigateIMCApp() {
        var intent = Intent(this, IMC::class.java)
        startActivity(intent)
    }
}