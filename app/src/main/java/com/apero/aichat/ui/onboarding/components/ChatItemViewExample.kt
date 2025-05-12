package com.apero.aichat.ui.onboarding.components

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.apero.aichat.R

/**
 * Example of how to use ChatItemView
 */
class ChatItemViewExample : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_item_example)
        
        val chatItemView = findViewById<ChatItemView>(R.id.chat_item_view)
        
        // Set properties
        chatItemView.apply {
            // Set avatar image (from drawable)
            setImageContent(ContextCompat.getDrawable(this@ChatItemViewExample, R.drawable.ic_avatar))
            
            // Or from URL
            // setImageContent("https://example.com/avatar.png")
            
            // Set label icon
            setSmallIcon(ContextCompat.getDrawable(this@ChatItemViewExample, R.drawable.ic_education))
            
            // Set label text
            setLabelText("Education")
            
            // Set title
            setTitle("Write an academic essay on...")
            
            // Set description
            setDescription("This is a description text that explains more about this chat item")
        }
    }
}