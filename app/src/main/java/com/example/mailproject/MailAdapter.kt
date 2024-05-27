package com.example.mailproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mailproject.databinding.RecyclerRowBinding

class MailAdapter(val mailList: ArrayList<Mail>):RecyclerView.Adapter<MailAdapter.MailHolder>() {
    class MailHolder(val binding: RecyclerRowBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MailHolder {
       val binding=RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
return MailHolder(binding)
    }

    override fun getItemCount(): Int {
        return  mailList.size
    }

    override fun onBindViewHolder(holder: MailHolder, position: Int) {
        holder.binding.name.text=mailList.get(position).name
        holder.binding.TitileMessage.text=mailList.get(position).titleMessage
        holder.binding.time.text=mailList.get(position).time
        holder.binding.Message.text=mailList.get(position).message
        holder.binding.imgview.setImageResource(mailList.get(position).profileimg)
        holder.binding.Icon.setImageResource(mailList.get(position).icon)
        holder.itemView.setOnClickListener {
            val intent= Intent(holder.itemView.context,DetailsActivity::class.java)
            intent.putExtra("Mail",mailList.get(position))
            holder.itemView.context.startActivity(intent)
        }
    }
}