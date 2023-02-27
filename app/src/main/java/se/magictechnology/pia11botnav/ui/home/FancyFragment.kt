package se.magictechnology.pia11botnav.ui.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import se.magictechnology.pia11botnav.R


class FancyFragment : Fragment() {

    var thecounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fancy_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.banan_item) {
            requireView().findViewById<TextView>(R.id.fancyNumberTV).text = "Banan"
            return true
        }
        if(item.itemId == R.id.apelsin_item) {
            requireView().findViewById<TextView>(R.id.fancyNumberTV).text = "Apelsin"
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fancy, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Toolbar>(R.id.fancyToolbar).inflateMenu(R.menu.fancy_menu)

        view.findViewById<Toolbar>(R.id.fancyToolbar).setOnMenuItemClickListener {
            if(it.itemId == R.id.banan_item) {
                view.findViewById<TextView>(R.id.fancyNumberTV).text = "XBanan"
            }
            false
        }


        view.findViewById<TextView>(R.id.fancyNumberTV).text = thecounter.toString()

        view.findViewById<Button>(R.id.fancyButton).setOnClickListener {
            thecounter = thecounter + 1

            view.findViewById<TextView>(R.id.fancyNumberTV).text = thecounter.toString()
        }

        view.findViewById<Button>(R.id.fancyDetailButton).setOnClickListener {
            findNavController().navigate(R.id.action_navigation_fancy_to_fancyDetailFragment)
        }


    }

}