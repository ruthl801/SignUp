package fs.ruthl.myproject.of.loginuniversty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.lang.reflect.Method


class RegisterPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContentView(R.layout.register_page)
        val userNameEditText =
            findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.tInputusernameR)
        val emailEditText =
            findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.tInputEmailR)
        val passwordEditText =
            findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.tInputpasswordR)
        val btnSignUp = findViewById<Button>(R.id.btnSignUpR)
        val iconBack = findViewById<ImageView>(R.id.IVBackIcon)

        iconBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnSignUp.setOnClickListener {
            signUp(userNameEditText, emailEditText, passwordEditText)
        }
        }


    private fun signUp(
        userNameEditText: com.google.android.material.textfield.TextInputEditText,
        emailEditText: com.google.android.material.textfield.TextInputEditText,
        passwordEditText: com.google.android.material.textfield.TextInputEditText
    ) {
        val userName = userNameEditText.getText().toString();
        val email = emailEditText.getText().toString();
        val password = passwordEditText.getText().toString();

        if (userName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }

        val stringRequest = object : StringRequest(
            Method.POST,
            "http://192.168.1.10/signup.php",
            Response.Listener<String> { response ->
                if (response.trim() == "success") {
                    Toast.makeText(this, "Sign Up Success", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Sign Up Failed", Toast.LENGTH_SHORT).show()
                }
            },
            Response.ErrorListener { error ->
                Toast.makeText(this, "Error: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        ) {
            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String> {
                return HashMap<String, String>().apply {
                    put("username", userName)
                    put("email", email)
                    put("password", password)


                }
            }
        }

        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)
    }
}



