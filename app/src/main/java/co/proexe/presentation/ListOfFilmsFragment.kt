package co.proexe.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.proexe.R

class ListOfFilmsFragment : Fragment() {

    companion object {
        fun newInstance() = ListOfFilmsFragment()
    }

    private lateinit var viewModel: ListOfFilmsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_of_films, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListOfFilmsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}