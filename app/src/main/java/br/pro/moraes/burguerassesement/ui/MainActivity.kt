package br.pro.moraes.burguerassesement.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import br.pro.moraes.burguerassesement.R
import br.pro.moraes.burguerassesement.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var appBarConfiguration: AppBarConfiguration

    val viewModel: BurguerViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.hide()

        val navHostFragment = supportFragmentManager.findFragmentById (R.id.nav_host_fragment) as NavHostFragment

        val navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.nav_home, R.id.nav_cart, R.id.nav_share))

        setupActionBarWithNavController(navController, appBarConfiguration)
        findViewById<BottomNavigationView>(R.id.nav_view)?.setupWithNavController(navController)

        setupObservers()
    }

    private fun setupObservers() {
        viewModel.textoCompartilhado.observe(this){
            if (!it.isNullOrBlank()){
                enviarTexto(it)
                viewModel.setTextoCompartilhado("")
            }
        }
    }

    // Enviar texto para alguém
    private fun enviarTexto(textMessage : String) {
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, textMessage)
            type = "text/plain"
        }
        if (sendIntent.resolveActivity(packageManager) != null) {
            startActivity(sendIntent)
        }
    }

}