package com.triwaluyo07.androidsubmission1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.triwaluyo07.androidsubmission1.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var userData: UserData

    companion object{
        const val EXTRA_DETAIL = "EXTRA DETAIL"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)



        userData = intent.getParcelableExtra<UserData>(EXTRA_DETAIL) as UserData

        supportActionBar!!.title = userData.username

        binding.tvName.text = userData.name
        binding.tvUsername.text = userData.username
        Glide.with(this).load(userData.avatar).apply(
                RequestOptions().override(80,80)
                ).into(binding.imgAvatar)

        binding.tvRepository.text = userData.repository
        binding.tvFollowers.text = userData.followers  //followers
        binding.tvFollowing.text = userData.following  //following
        binding.tvLocation.text = userData.location  //lokasi
        binding.tvCompany.text = userData.company  //company
    }
}