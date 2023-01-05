package com.codelabs.musisifavorit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.codelabs.musisifavorit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val binding : ActivityMainBinding by viewBinding()
    private val list : ArrayList<Films> = arrayListOf()
    private lateinit var listFilmAdapter: ListFilmAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.setTitle("Film Favorit")

        binding.rvFilms.setHasFixedSize(true)
        list.addAll(FilmData.listData)

        showRecycleViewList()

    }

    private fun showRecycleViewList() {
        binding.apply {
            rvFilms.layoutManager = LinearLayoutManager(this@MainActivity)
            listFilmAdapter = ListFilmAdapter(list)
            rvFilms.adapter = listFilmAdapter
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this,AboutActivity::class.java)
        when(item.itemId){
            R.id.menu_profile -> startActivity(intent)
        }
        return true
    }


}