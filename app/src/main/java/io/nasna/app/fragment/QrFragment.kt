package io.nasna.app.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.nasna.app.R
public class QrFragment : Fragment() {

    companion object {

        fun newInstance(): QrFragment {
            return QrFragment()
        }
    }

    //3
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_saved_qr, container, false)
    }

}