package de.weichwarenprojekt.getherfit.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import de.weichwarenprojekt.getherfit.R
import de.weichwarenprojekt.getherfit.shared.ScrollWatcher

class RoutinesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_routines, container, false)
        ScrollWatcher.setActiveScrollbar(view.findViewById(R.id.scroll_view))
        return view
    }
}