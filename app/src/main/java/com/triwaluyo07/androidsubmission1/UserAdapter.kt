package com.triwaluyo07.androidsubmission1


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.triwaluyo07.androidsubmission1.databinding.ItemRowUserBinding

class UserAdapter (var listUser : ArrayList<UserData>) :
                    RecyclerView.Adapter<UserAdapter.ListViewHolder>(){

    inner class ListViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)
    {
        val binding = ItemRowUserBinding.bind(itemView)
    }

    private lateinit var onItemClickCallback: OnItemClickCallBack



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ListViewHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_user,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.ListViewHolder, position: Int) {
        val user = listUser[position]
        Glide.with(holder.itemView.context)
            .load(user.avatar)
            .apply(RequestOptions().override(60,60))
            .into(holder.binding.imgRowImage)
        holder.binding.mainName.text = user.name
        holder.binding.mainUsername.text = user.username

        holder.itemView.setOnClickListener {
            onItemClickCallback.onitemClicked(listUser[holder.adapterPosition])
        }

    }

    override fun getItemCount(): Int =  listUser.size

    fun setOnItemClickCallback(onItemClickCallBack: OnItemClickCallBack) {
        this.onItemClickCallback = onItemClickCallBack
    }

    interface OnItemClickCallBack {
        fun onitemClicked(data: UserData)

    }
}


