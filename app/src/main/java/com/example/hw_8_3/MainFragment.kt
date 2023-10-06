package com.example.hw_8_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.hw_8_3.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding:FragmentMainBinding
    private val listOfMult = arrayListOf(
        MultModel("https://citaty.info/files/characters/8604.jpg", "Harry Potter", "Alive"),
        MultModel("https://4.bp.blogspot.com/-8pBMIsRfVjM/T1B5W19Ac3I/AAAAAAAAAHA/9Ro7WO4UOVw/s1600/ron.jpg", "Ron Weasley", "Alive"),
        MultModel("https://ic.pics.livejournal.com/dubikvit/65747770/9409940/9409940_900.jpg", "Hermione Granger", "Alive"),
        MultModel("https://purplecowblog.files.wordpress.com/2016/12/x_00d89aae.jpg", "Neville Longbottom", "Alive"),
        MultModel("https://i.pinimg.com/474x/3e/d8/db/3ed8db0739e5dd8bf2e517e4851c038c.jpg", "Draco Malfoy", "Alive"),
        MultModel("https://static.wikia.nocookie.net/cf6cbd48-a19f-40a6-9d49-da83543556ab", "Albus Dambldor", "Dead"),
        MultModel("https://chakiris.club/uploads/posts/2023-01/1674778498_chakiris-club-p-garri-potter-minerva-makgonagall-pinterest-1.jpg", "Minerva McGonagall", "Alive"),
        MultModel("https://upload.wikimedia.org/wikipedia/ru/thumb/a/a3/Severus_Snape.jpg/250px-Severus_Snape.jpg", "Severus Snape", "Dead"),
        MultModel("https://static.wikia.nocookie.net/harrypotter/images/3/32/Rubeus.jpg/revision/latest?cb=20080207002912&path-prefix=ru", "Rubeus Hagrid", "Dead"),
        MultModel("https://i.pinimg.com/736x/c7/b4/4e/c7b44e75a3d31ead2e6f83e8966e0a09.jpg", "Lord Woldemort", "Dead"),
        MultModel("https://potter-base.ru/uploads/posts/2019-04/1554822522_sirius-black.jpg", "Sirius Black", "Dead"),)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MultAdapter(listOfMult, this::onClick)
        binding.rvMult.adapter = adapter
    }

    private fun onClick(model:MultModel){
        findNavController().navigate(R.id.secondFragment, bundleOf("character" to model))
    }
}