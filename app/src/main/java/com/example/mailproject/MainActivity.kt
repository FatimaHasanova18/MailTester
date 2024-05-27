package com.example.mailproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mailproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mailList: ArrayList<Mail>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()

        mailList = ArrayList<Mail>()
        val sam = Mail("Sam", "Weekend adventure", "Let's go fishing with John and others. We will...", "10:42am", R.drawable.s, R.drawable.star,R.drawable.fishing)
        val facebook = Mail("Facebook", "Update", "Here's what's new this week...", "16:09pm", R.drawable.f, R.drawable.star,R.drawable.facebook)
        val google = Mail("Google", "Security Alert", "New sign-in from an unknown device...", "18:44pm", R.drawable.g, R.drawable.star,R.drawable.goolee)
        val twitter = Mail("Twitter", "New Follower", "You have a new follower...", "20:04pm", R.drawable.t, R.drawable.star,R.drawable.twitter)
        val pinterest = Mail("Pinterest", "New Pins", "Check out these new pins...", "09:04am", R.drawable.p, R.drawable.star,R.drawable.pinterest)
        val josh = Mail("Josh", "Meeting Reminder", "Don't forget our meeting tomorrow...", "01:04am", R.drawable.j, R.drawable.star,R.drawable.lunch)

        mailList.add(sam)
        mailList.add(facebook)
        mailList.add(google)
        mailList.add(twitter)
        mailList.add(pinterest)
        mailList.add(josh)

        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        val mailAdapter = MailAdapter(mailList)
        binding.recyclerview.adapter = mailAdapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
