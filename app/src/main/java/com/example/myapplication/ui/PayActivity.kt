package com.example.myapplication.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityPayBinding
import com.example.myapplication.viewmodel.PayViewModel

/*
* 添加支出
*/
class PayActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPayBinding
    private val viewModel by lazy { ViewModelProvider(this).get(PayViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btFinish.setOnClickListener { view ->
            if (binding.etProject.text.toString().isEmpty() || binding.etFee.text.toString().isEmpty()){
                Toast.makeText(this,"输入不能为空",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            viewModel.getUSDAmount(binding.etProject.text.toString(),binding.etFee.text.toString().toDouble())

        }

        viewModel.resultLiveData.observe(this, Observer {
            intent.apply {
                setResult(RESULT_OK,this)
                finish()
            }
        })
    }


}