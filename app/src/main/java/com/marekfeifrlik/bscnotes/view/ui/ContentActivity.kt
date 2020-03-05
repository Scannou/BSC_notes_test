package com.marekfeifrlik.bscnotes.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.marekfeifrlik.bscnotes.R
import kotlinx.android.synthetic.main.component_appbarlayout.*

/**
 * Created by Marek Feifrlik on 05/03/2020.
 */
class ContentActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        setSupportActionBar(toolbar)
        setupNavigation()
        setupAppBar()
    }

    private fun setupNavigation() {
        navController = Navigation.findNavController(this, R.id.navHostFragment)
    }

    private fun setupAppBar() {
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
        toolbar.setNavigationOnClickListener {
            navController.navigate(NoteDetailFragmentDirections.actionToNotesListFragmentFromNoteDetailFragment())
        }
    }

}
