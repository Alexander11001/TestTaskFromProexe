package co.proexe.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.proexe.R
import co.proexe.presentation.adapters.DateAdapter
import co.proexe.presentation.adapters.ProgrammeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListOfFilmsFragment : Fragment() {

    companion object {
        fun newInstance() = ListOfFilmsFragment()
    }

    private val viewModel: ListOfFilmsViewModel by viewModels()

    //todo ImplementViewBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_of_films, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = requireActivity().findViewById<RecyclerView>(R.id.recyclerProgrammes)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = ProgrammeAdapter()
        recyclerView.adapter = adapter

        viewModel.programmes.observe(viewLifecycleOwner) {
//            adapter.submitList(it)
            adapter.submitList(viewModel.programmes.value?.let { viewModel.sortProgrammes(it) })
        }

        val horizontalRecyclerView =
            requireActivity().findViewById<RecyclerView>(R.id.horizontalRecyclerDate)
        horizontalRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        horizontalRecyclerView.scrollToPosition(Integer.MAX_VALUE / 2)
        val daysOfWeek =
            listOf("poniedziałek", "wtorek", "środa", "czwartek", "piątek", "sobota", "niedziela")
        val dateAdapter = DateAdapter(daysOfWeek)
        horizontalRecyclerView.adapter = dateAdapter






        adapter.setOnLongClickListener { tvProgramme ->
            if (viewModel.sharedPreferencesUtil.isProgrammeFavorite(tvProgramme.id)) {
                viewModel.removeProgrammeFromFavorites(tvProgramme.id)
            } else {
                viewModel.addProgrammeToFavorites(tvProgramme.id)
            }
            // Refresh the list
            adapter.submitList(viewModel.programmes.value?.let { viewModel.sortProgrammes(it) })
        }
    }
}