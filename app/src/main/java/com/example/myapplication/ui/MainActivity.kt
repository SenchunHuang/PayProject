package com.example.myapplication.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.model.AdapterEntity
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.viewmodel.MainViewModel

/*
* 支出列表页
*/
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }
    private var customAdapter: CustomAdapter? = null

    /*
    * 监听返回的数据
    */
    private val register = registerForActivityResult(StartActivityForResult()) {
        viewModel.queryAllData()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListener()
        initData()

        viewModel.adapterLiveData.observe(this) {
            customAdapter?.run {
                this.notifyDataSetChanged()
            }?: run {
                val linearLayout = LinearLayoutManager(this@MainActivity)
                binding.recyclerView.layoutManager = linearLayout
                customAdapter = CustomAdapter(it)
                binding.recyclerView.adapter = customAdapter
            }
            setTotal(it)
        }
    }

    private fun initListener() {
        binding.fab.setOnClickListener { view ->
            val intent = Intent(this, PayActivity::class.java)
            register.launch(intent)
        }
    }

    private fun initData(){
        viewModel.queryAllData()
    }

    private fun setTotal(list: MutableList<AdapterEntity>) {
        var total = 0.0
        for (projectEntity in list) {
            total += projectEntity.feeCny!!.toDouble()
        }
        binding.tvPay.text = "${total} CNY"
    }

}