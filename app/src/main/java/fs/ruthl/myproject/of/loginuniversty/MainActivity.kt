package fs.ruthl.myproject.of.loginuniversty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(FLAG_LAYOUT_NO_LIMITS,FLAG_LAYOUT_NO_LIMITS )
        setContentView(R.layout.activity_main)

        val btnlogin = findViewById<Button>(R.id.btnlog)
        val btnregister = findViewById<Button>(R.id.btnRegister)
        btnlogin.setOnClickListener {
            val intent = Intent(this, LogInPage::class.java)
            startActivity(intent)
        }
        btnregister.setOnClickListener {
            val intent = Intent(this, RegisterPage::class.java)
            startActivity(intent)
        }
    }
}