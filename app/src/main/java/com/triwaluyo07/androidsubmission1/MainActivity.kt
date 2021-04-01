package com.triwaluyo07.androidsubmission1

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.triwaluyo07.androidsubmission1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserAdapter

    private lateinit var dataAvatar : TypedArray
    private lateinit var dataUserName: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataRepository : Array<String>
    private lateinit var dataFollower : Array<String>
    private lateinit var dataFollowing : Array<String>
    private lateinit var dataLocation : Array<String>
    private lateinit var dataCompany : Array<String>


    private var listUser = arrayListOf<UserData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layout: RecyclerView.LayoutManager = LinearLayoutManager(this)

        adapter = UserAdapter(listUser)
        binding.rvMain.adapter = adapter
        binding.rvMain.layoutManager = layout

        prepare()
        addItem()

        showRecyclerList()
    }

    private fun prepare()
    {
        dataUserName = resources.getStringArray(R.array.username)
        dataName = resources.getStringArray(R.array.name)
        dataAvatar = resources.obtainTypedArray(R.array.avatar)
        dataRepository = resources.getStringArray(R.array.repository)
        dataFollower = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
        dataLocation = resources.getStringArray(R.array.location)
        dataCompany = resources.getStringArray(R.array.company)


    }

    private fun addItem(){
        for (position in dataName.indices){

            val user = UserData(
                dataAvatar.getResourceId(position, -1),
                dataUserName[position],
                dataName[position],
                dataRepository[position],
                dataFollower[position],
                dataFollowing[position],
                dataLocation[position],
                dataCompany[position]
            )
            listUser.add(user)

        }
        adapter.listUser = listUser
    }


    private fun showRecyclerList(){
        binding.rvMain.layoutManager = LinearLayoutManager(this)
        val userAdapter = UserAdapter(listUser)
        binding.rvMain.adapter = userAdapter

        userAdapter.setOnItemClickCallback(object : UserAdapter.OnItemClickCallBack {

            override fun onitemClicked(data: UserData) {
                showSelectedUser(data)
            }
        })

    }

    private fun showSelectedUser(userData: UserData){
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_DETAIL, userData)
        startActivity(intent)
    }
}
