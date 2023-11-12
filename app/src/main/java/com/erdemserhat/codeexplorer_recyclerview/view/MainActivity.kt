package com.erdemserhat.codeexplorer_recyclerview.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.erdemserhat.codeexplorer_recyclerview.R
import com.erdemserhat.codeexplorer_recyclerview.databinding.ActivityMainBinding
import com.erdemserhat.codeexplorer_recyclerview.model.ProgrammingLanguage
import com.erdemserhat.codeexplorer_recyclerview.view_model.ProgrammingLanguageAdapter

/**
 * If you decalre a variable above the class this variable can been seen every class
 *  This is a top-level property, often referred to as a global variable
 */

var exampleGlobalVariable:Any? = null

lateinit var globalList:List<ProgrammingLanguage>

class MainActivity : AppCompatActivity() {
    //View Binding
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //View Binding
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //static data
        val java: ProgrammingLanguage = ProgrammingLanguage("Java",getString(R.string.javaDescription),
            R.drawable.java
        )
        val python: ProgrammingLanguage = ProgrammingLanguage("Python",getString(R.string.pythonDescription),
            R.drawable.python
        )
        val javaScript: ProgrammingLanguage = ProgrammingLanguage("Java Script",getString(R.string.javaScriptDescription),
            R.drawable.java_script
        )
        val cplus: ProgrammingLanguage = ProgrammingLanguage("C++",getString(R.string.cplusDescription),
            R.drawable.cplus
        )

        //static list
        val programmingLanguageList:List<ProgrammingLanguage> = listOf(java,python,javaScript,cplus)
        globalList=programmingLanguageList
        ListSingleton.programmingLanguageList=programmingLanguageList

        //We need to crate an adapter for recycler view ( to bind data and views together)...

        val adapter = ProgrammingLanguageAdapter(programmingLanguageList)

        binding.recyclerView.adapter= adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)






    }


}