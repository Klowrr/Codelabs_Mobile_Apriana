package com.codelabs.musisifavorit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.codelabs.musisifavorit.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity(R.layout.activity_detail) {
    private val binding : ActivityDetailBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.setTitle("Film Detail")

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setData()

    }

    private fun setData() {
        binding.apply {
            val films = intent.getParcelableExtra<Films>(EXTRA_DETAIL)

            tvFilmName.text = films?.name
            tvSutradara.text = films?.sutradara
            tvProduser.text = films?.produser
            tvtahunRilis.text = films?.rilis
            tvDetail.text = films?.detail

            Glide.with(this@DetailActivity)
                .load(films?.photo)
                .apply(RequestOptions())
                .into(ivFilm)

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object{
        const val EXTRA_DETAIL = "extra_detail"
    }
}