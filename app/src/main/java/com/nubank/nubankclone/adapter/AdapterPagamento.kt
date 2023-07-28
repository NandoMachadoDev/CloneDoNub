package com.nubank.nubankclone.adapter

import android.app.ProgressDialog.show
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.nubank.nubankclone.MainActivity
import com.nubank.nubankclone.R
import com.nubank.nubankclone.databinding.PagamentoItemBinding
import com.nubank.nubankclone.model.Pagamento

class AdapterPagamento(private val context: Context, private val listaPagamento: MutableList<Pagamento>,val view: MainActivity): //essa variavel view, vai permitir usar todos os metodos nao privados na Main
    RecyclerView.Adapter<AdapterPagamento.PagamentoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagamentoViewHolder {
        val itemLista = PagamentoItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return PagamentoViewHolder(itemLista)
    }

    override fun getItemCount() = listaPagamento.size


    inner class PagamentoViewHolder(binding: PagamentoItemBinding): RecyclerView.ViewHolder(binding.root) {
        val iconePagamento = binding.icPagamento
        val txtTituloPagamento = binding.txtTituloPagamento
        val showDialogDeposit = binding.showDialogDeposit
    }

    override fun onBindViewHolder(holder: PagamentoViewHolder, position: Int) {
        holder.iconePagamento.setBackgroundResource(listaPagamento[position].icone!!)
        holder.txtTituloPagamento.text = listaPagamento[position].titulo

        holder.showDialogDeposit.setOnClickListener {
            if(listaPagamento[position].titulo == "Depositar"){
            }
            //findViewById<RecyclerView>(R.id.showDialogDeposit).setOnClickListener {
            //    showDialogDeposit()
            //}
        }


    }

}
