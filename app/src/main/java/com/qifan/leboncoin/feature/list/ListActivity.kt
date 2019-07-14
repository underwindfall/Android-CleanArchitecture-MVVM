package com.qifan.leboncoin.feature.list

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.rxbinding3.view.clicks
import com.qifan.leboncoin.R
import com.qifan.leboncoin.core.NetWorkState
import com.qifan.leboncoin.core.base.BaseActivity
import com.qifan.leboncoin.core.behaviors.BehaviorObservers
import com.qifan.leboncoin.core.behaviors.builder
import com.qifan.leboncoin.core.behaviors.reactive.ReactiveBehavior
import com.qifan.leboncoin.core.behaviors.reactive.reactive
import com.qifan.leboncoin.core.extension.snack
import com.qifan.leboncoin.feature.list.adapter.JsonListAdapter
import com.qifan.leboncoin.feature.list.model.LeBonCoin
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_list.*
import org.koin.android.ext.android.inject

class ListActivity : BaseActivity(), ReactiveBehavior {
    private val viewModel: ListViewModel by inject()
    private lateinit var adapter: JsonListAdapter
    private var dataSourceList: MutableList<LeBonCoin> = mutableListOf()
    override fun getLayoutId(): Int = R.layout.activity_list

    override val behaviors: BehaviorObservers by builder {
        use(
            reactive()
        )
    }

    override fun startObserve(compositeDisposable: CompositeDisposable) {
        compositeDisposable.addAll(
            handleNetWorkState().subscribe(),
            handleDataList().subscribe(),
            handleFabClick().subscribe()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
        viewModel.loadData()
    }


    private fun setupView() {
        recycler_view.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        adapter = JsonListAdapter(dataSourceList)
        recycler_view.adapter = adapter
    }

    private fun handleFabClick() = fab.clicks()
        .switchMapCompletable {
            Completable.fromCallable {
                viewModel.loadData()
            }
        }

    private fun handleDataList() = viewModel.dataList
        .doOnNext {
            dataSourceList.clear()
            dataSourceList.addAll(it)
        }

    private fun handleNetWorkState() =
        viewModel.networkStatus
            .doOnNext {
                when (it) {
                    NetWorkState.LOADING -> showLoading()
                    NetWorkState.SUCCESS -> showSuccess()
                    NetWorkState.FAIL -> showFail()
                    else -> showLoading()
                }
            }


    private fun showLoading() {
        loading.visibility = View.VISIBLE
        recycler_view.visibility = View.GONE
    }


    private fun showSuccess() {
        loading.visibility = View.GONE
        recycler_view.visibility = View.VISIBLE
        adapter.notifyDataSetChanged()
    }

    private fun showFail() {
        loading.visibility = View.GONE
        recycler_view.visibility = View.VISIBLE
        fab.snack(R.string.network_error) {
            viewModel.loadData()
        }
    }

}
