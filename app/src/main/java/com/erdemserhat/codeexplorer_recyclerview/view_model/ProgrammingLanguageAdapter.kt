package com.erdemserhat.codeexplorer_recyclerview.view_model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.erdemserhat.codeexplorer_recyclerview.databinding.RecyclerViewRowLayoutBinding
import com.erdemserhat.codeexplorer_recyclerview.model.ProgrammingLanguage
import com.erdemserhat.codeexplorer_recyclerview.view.ListSingleton

/**
 * Adapter for the RecyclerView that displays a list of programming languages.
 *
 * @param programmingLanguageList The list of programming languages to be displayed.
 *                               This should be a serializable dataset represented as an array.
 *
 * ProgrammingLanguageAdapter class extends RecyclerView.Adapter<>(),
 * where RecyclerView.Adapter is the base class providing general-purpose functionality
 * for a RecyclerView adapter.
 *

 * Example usage:
 * ```kotlin
 * val adapter = ProgrammingLanguageAdapter(programmingLanguageList)
 * recyclerView.adapter = adapter
 * ```
 *

 *
 * Note: Ensure that the your data  class is serializable. (In this case programmingLanguage)
 */
class ProgrammingLanguageAdapter(val programmingLanguageList: List<ProgrammingLanguage>) :
    RecyclerView.Adapter<ProgrammingLanguageAdapter.ProgrammingLanguageHolder>() {

    /**
     * The RecyclerView.Adapter<...> class requires a parameter specifying the data type of the ViewHolder
     * and its subtypes. Therefore, you need to define a class that extends RecyclerView.ViewHolder.
     * To customize the appearance of each item in the RecyclerView, create a subclass of
     * ViewHolder and implement the necessary functionalities.
     *
     */
    class ProgrammingLanguageHolder(val binding: RecyclerViewRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    /**
     * onCreateViewHolder is called when the RecyclerView needs to create a new ViewHolder,
     * typically when it's initializing or when existing ViewHolders are not available for recycling.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingLanguageHolder {
        /**
         * Create an binding type of your customizable class (in this case :RecyclerViewRowLayoutBinding)
         * and inflate your binding with inflate() function when you press to ctrl and wait, you can see the parameter
         * types which you should give them
         */

        val binding: RecyclerViewRowLayoutBinding =
            RecyclerViewRowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ProgrammingLanguageHolder(binding)




    }

    override fun getItemCount(): Int {
        return programmingLanguageList.size
    }

    override fun onBindViewHolder(holder: ProgrammingLanguageHolder, position: Int) {
        //You can also reach with globalList-->globalList (less security)
        //You can also reach with Singleton-->ListSingleton.programmingLanguageList(
        //You can also reach with programmingLanguageList (attributed)



        holder.binding.name.text=ListSingleton.programmingLanguageList[position].name
        holder.binding.description.text=ListSingleton.programmingLanguageList[position].description
        holder.binding.image.setImageDrawable(AppCompatResources.getDrawable(holder.itemView.context,ListSingleton.programmingLanguageList[position].id))

    }


}