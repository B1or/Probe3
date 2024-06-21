package tech.droi.probe3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import tech.droi.probe3.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val model: SharedViewModel by viewModels { SharedViewModel.Factory }
//    @Inject lateinit var model: SharedViewModel
    @Inject lateinit var computer: Computer
    @Inject lateinit var axe: Axe

    override fun onCreate(savedInstanceState: Bundle?) {

        (applicationContext as MainApp).appComp.inject(this)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        model.count.observe(this) {
            binding.tvCount.text = it.toString()
        }
        binding.bPlus.setOnClickListener {
            model.plus()
        }
        binding.bMinus.setOnClickListener {
            model.minus()
        }
        binding.tvCount.setOnClickListener {
            model.axeThrow()
        }
    }
}
