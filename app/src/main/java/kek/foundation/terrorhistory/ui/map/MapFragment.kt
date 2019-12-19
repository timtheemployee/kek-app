package kek.foundation.terrorhistory.ui.map

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.UiSettings
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.snackbar.Snackbar
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.clustering.algo.GridBasedAlgorithm
import com.google.maps.android.clustering.algo.PreCachingAlgorithmDecorator
import kek.foundation.terrorhistory.R
import kek.foundation.terrorhistory.data.events.Event
import kek.foundation.terrorhistory.presentation.map.FilterMapView
import kek.foundation.terrorhistory.presentation.map.MapPresenter
import kek.foundation.terrorhistory.ui.BaseFragment
import kotlinx.android.synthetic.main.information_layout.*
import kotlinx.android.synthetic.main.map_fragment.*
import java.lang.IllegalArgumentException

class MapFragment : BaseFragment(), FilterMapView, OnMapReadyCallback {

    companion object {
        fun newInstance(): Fragment = MapFragment()
    }

    override val layout = R.layout.map_fragment
    lateinit var presenter: MapPresenter
    private lateinit var googleMap: GoogleMap
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>
    private lateinit var cluster: ClusterManager<EventItem>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomSheetBehavior = BottomSheetBehavior.from(coordinatorContainer)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN

        val mapFragment =
            childFragmentManager.findFragmentById(R.id.mapContainer) as? SupportMapFragment

        mapFragment?.getMapAsync(this)
    }

    override fun updateEvents(events: List<Event>) {
        requireActivity().runOnUiThread {
            progress.isVisible = false
            events
                .map { event ->
                    EventItem(
                        LatLng(event.latitude, event.longitude),
                        event.group,
                        event.eventId
                    )
                }
                .toList()
                .let(cluster::addItems)

            cluster.cluster()
        }
    }

    override fun showLoadingError() {
        Snackbar.make(progress, "Что-то пошло не так...", Snackbar.LENGTH_LONG)
            .setAction("Повторить") {
                presenter.onFirstViewAttach()
            }
            .show()
    }

    override fun onMapReady(map: GoogleMap?) {
        require(map != null) { IllegalArgumentException("Map is not initialized") }
        googleMap = map
        cluster = ClusterManager(requireContext(), map)
        cluster.setAnimation(true)

        cluster.algorithm = PreCachingAlgorithmDecorator(GridBasedAlgorithm<EventItem>())
        cluster.setOnClusterItemClickListener {
            presenter.onMarkerClicked(it)
            true
        }

        googleMap.setOnCameraIdleListener(cluster)
        googleMap.setOnMarkerClickListener(cluster)

        presenter.attachView(this)
    }

    @SuppressLint("SetTextI18n")
    override fun showEvent(target: Event) {
        dateView.text = "${target.day}.${target.month}.${target.year}"
        regionView.text = target.region
        countryView.text = target.country
        coordinatesView.text = "${target.latitude} ${target.longitude}"

        if (target.summary != null) {
            summaryView.text = target.summary
        } else {
            summaryLabel.isVisible = false
            summaryView.isVisible = false
        }

        successView.text = if (target.isSuccess) {
            "Да"
        } else {
            "Нет"
        }

        suicideView.text = if (target.isSuicide) {
            "Да"
        } else {
            "Нет"
        }

        attackTypeView.text = target.attackType
        targetTypeView.text = target.targetType
        killsView.text = target.killsCount.toString()
        groupView.text = target.group

        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    override fun showEmptyListError() {
        progress.isVisible = false
        Snackbar.make(
            progress,
            "Кажется ничего не найдено, попробуйте обновить фильтры",
            Snackbar.LENGTH_LONG
        ).show()
    }
}