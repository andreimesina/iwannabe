package com.trojans.iwannabe.messenger

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.trojans.iwannabe.R
import org.json.JSONException
import org.json.JSONObject
import java.util.*

class UsersFragment : Fragment() {

    private lateinit var usersList: ListView
    private lateinit var noUsersText: TextView
    private var arrayList = ArrayList<String>()

    private var totalUsers = 0

    private lateinit var progressDialog: ProgressDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        usersList = view.findViewById<View>(R.id.usersList) as ListView
        noUsersText = view.findViewById<View>(R.id.noUsersText) as TextView

        progressDialog = ProgressDialog(this.context)
        progressDialog.setMessage("Loading...")
        progressDialog.show()

        doOnSuccess("{\"Stefan\":{\"password\":\"1234\"},\"Monica\":{\"password\":\"1234\"},\"Nic\":{\"password\":\"1234\"},\"Andrei\":{\"password\":\"1234\"},\"UPB\":{\"password\":\"1234\"},\"FMI\":{\"password\":\"1234\"},\"Mate-info-intensiv\":{\"password\":\"1234\"}}")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        usersList.setOnItemClickListener { _, _, position, _ ->
            UserDetails.chatWith = arrayList[position]

            val fm = activity!!.supportFragmentManager
            val ft = fm.beginTransaction()

            ft.replace(R.id.container, MessengerFragment(), "user")
                .addToBackStack(null)
                .commit()
        }
    }

    private fun doOnSuccess(s: String) {
        try {
            val obj = JSONObject(s)

            val i = obj.keys()
            var key: String

            while (i.hasNext()) {
                key = i.next().toString()

                if (key != UserDetails.username) {
                    arrayList.add(key)
                }

                totalUsers++
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }

        if (totalUsers <= 1) {
            noUsersText.visibility = View.VISIBLE
            usersList.visibility = View.GONE
        } else {
            noUsersText.visibility = View.GONE
            usersList.visibility = View.VISIBLE
            usersList.adapter =
                ArrayAdapter(
                    this@UsersFragment.context!!,
                    android.R.layout.simple_list_item_1,
                    arrayList
                )
        }

        progressDialog.dismiss()
    }
}